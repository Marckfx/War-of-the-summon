package com.mygdx.game;

import button.Buildbuttons;
import button.Button;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import figures.*;

import java.io.*;
import java.net.*;

import java.util.ArrayList;

public class main extends ApplicationAdapter {
    SpriteBatch batch;
    Maxlive maxlive = new Maxlive();
    Field field = new Field();
    Click click = new Click();
    Buildbuttons buildbuttons = new Buildbuttons();
    Calculate calculate = new Calculate();
    int clickx = -1;
    int clicky = -1;
    int clickrx = -1;
    int clickry = -1;
    int playerturn = 1;
    int player1live = 45;
    int player2live = 45;
    int buildfigure = -1;
    int turnbuild = 0;
    boolean newturn = false;
    boolean build = true;
    boolean turnend = false;
    int[] bewegenmalen = null;
    int[] attackmalen = null;
    Figures buildfigur;
    Figures clickf = null;
    Castle castle;
    ArrayList<Figures> figures = new ArrayList<>();
    boolean player1win = false;
    boolean player2win = false;
    boolean gamestart = false;
    Socket socket;
    int player = 0;
    String sendstring;
    String becomestring;

    @Override
    public void create() {
        connection();
        batch = new SpriteBatch();
        field.generatField();
        buildbuttons.Buildbutton();
        castle = new Castle(1, 0, 5, 15);
        figures.add(castle);
        castle = new Castle(1, 0, 6, 15);
        figures.add(castle);
        castle = new Castle(1, 0, 7, 15);
        figures.add(castle);
        castle = new Castle(2, 12, 5, 15);
        figures.add(castle);
        castle = new Castle(2, 12, 6, 15);
        figures.add(castle);
        castle = new Castle(2, 12, 7, 15);
        figures.add(castle);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        if (gamestart && !player1win && !player2win) {
            if (newturn) {
                getsend();
            }
            if (player == playerturn) {
                clickhandler();
                if (build) {
                    buildphase();
                } else {
                    gamephase();
                }
            }
            for (int i = 1; i < field.getFieldparts().size(); i++) {
                Fieldparts fields = field.getFieldparts().get(i);
                drawfield(fields, i);
                for (Figures figure : figures) {
                    drawfigures(fields, figure);
                    clickfigures(fields, i, figure);
                }
                movefigur(fields, i);
                attackfigure(fields, i);
            }
            if (buildfigur != null) {
                figures.add(buildfigur);
                buildfigur = null;
            }
            drawstats();
            deletdeadfigurs();
        }else if(!gamestart && !player1win && !player2win){
            BitmapFont figurstats = new BitmapFont();
            figurstats.draw(batch, "Warte auf Spieler", 1500, 1000);
        }
        end();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void deletdeadfigurs() {
        Figures deletme = null;
        for (Figures dead : figures) {
            if (!(dead instanceof Castle))
                if (dead.getLive() <= 0) {
                    deletme = dead;
                }
        }
        if (deletme != null) {
            figures.remove(deletme);
        }
    }

    public void drawstats() {
        if (clickf != null) {
            BitmapFont figurstats = new BitmapFont();
            if (clickf.getPlayer() == 1) {
                figurstats.setColor(Color.GREEN);
            } else {
                figurstats.setColor(Color.RED);
            }
            figurstats.draw(batch, "Name: " + clickf.getName(), 2300, 1850);
            figurstats.draw(batch, "Attack: " + clickf.getAttack(), 2300, 1830);
            figurstats.draw(batch, "Move: " + clickf.getMove(), 2300, 1810);
            figurstats.draw(batch, "Attackrange: " + clickf.getAttackrange(), 2300, 1790);
            figurstats.draw(batch, "Live: " + clickf.getLive(), 2300, 1770);

        }
        if (clickrx > 0 && clickry > 0) {
            BitmapFont figurstats = new BitmapFont();
            figurstats.draw(batch, "clickrx: " + clickrx, 2300, 200);
            figurstats.draw(batch, "clickry: " + clickry, 2300, 220);
        }
        BitmapFont figurstats = new BitmapFont();
        figurstats.draw(batch, "Du bist Spieler " + player, 2300, 1750);
    }

    public void drawfield(Fieldparts fields, int i) {
        if (playerturn == 1) {
            batch.draw(new Texture("Spieler1.png"), 2300, 0);
        } else {
            batch.draw(new Texture("Spieler2.png"), 2300, 0);
        }
        if (build) {
            if (i == 6 || i == 7 || i == 8 || i == 163 || i == 162 || i == 164) {

            } else if (i <= 13 * 3) {
                batch.draw(fields.getTextures().get(4), fields.Xpix, fields.Ypix);
            } else if (i >= 13 * 10 + 1) {
                batch.draw(fields.getTextures().get(5), fields.Xpix, fields.Ypix);
            }
            for (int j = 0; j < buildbuttons.getButton1().size(); j++) {
                Button button1 = buildbuttons.getButton1().get(j);
                Button button2 = buildbuttons.getButton2().get(j);
                if ((clickx == button2.getX() && clicky == button2.getY()) || (clickx == button1.getX() && clicky == button1.getY())) {
                    batch.draw(button1.getTextureclick(), button1.getXpix(), button1.getYpix());
                    batch.draw(button2.getTextureclick2(), button2.getXpix(), button2.getYpix());
                    buildfigure = j;
                } else {
                    batch.draw(button1.getTexture(), button1.getXpix(), button1.getYpix());
                    batch.draw(button2.getTexture2(), button2.getXpix(), button2.getYpix());
                }
            }

        } else {
            if (i == 6 || i == 7 || i == 8 || i == 163 || i == 162 || i == 164) {

            } else {
                batch.draw(fields.getTextures().get(0), fields.Xpix, fields.Ypix);
            }
            if (attackmalen != null) {
                for (int attack : attackmalen) {
                    if (attack == i && attack > 0 && attack < 170) {
                        batch.draw(fields.getTextures().get(2), fields.Xpix, fields.Ypix);
                    }
                }
                if (bewegenmalen != null) {
                    for (int move : bewegenmalen) {
                        for (Figures figure : figures) {
                            if (move == i && move > 0 && move < 170 && fields.X == figure.getX() && fields.Y == figure.getY() && figure.getPlayer() != playerturn) {
                                batch.draw(fields.getTextures().get(2), fields.Xpix, fields.Ypix);
                            } else if (move == i && move > 0 && move < 170 && fields.X == figure.getX() && fields.Y == figure.getY() && figure.getPlayer() == playerturn) {
                                batch.draw(fields.getTextures().get(0), fields.Xpix, fields.Ypix);
                            } else if (move == i && move > 0 && move < 170) {
                                batch.draw(fields.getTextures().get(1), fields.Xpix, fields.Ypix);
                            }
                        }
                    }
                }
            }
        }
    }

    public void getsend() {

        String send = becomestring;
        String[] resultfigure = send.split("-");
        ArrayList<Figures> figuressend = new ArrayList<>();
        for (String figurestring : resultfigure) {
            String[] resultfigurestats = figurestring.split("#");
            int playersend = Integer.parseInt(resultfigurestats[1]);
            int livesend = Integer.parseInt(resultfigurestats[2]);
            int xsend = Integer.parseInt(resultfigurestats[3]);
            int ysend = Integer.parseInt(resultfigurestats[4]);
            getrightfigure(resultfigurestats[0], playersend, xsend, ysend, livesend,figuressend);
        }
        figures = figuressend;
        newturn = false;
    }

    public void getrightfigure(String check, int playersend, int xsend, int ysend, int livesend, ArrayList<Figures> figuressend) {
        if (check.equals("Bauer")) {
            figuressend.add(new Bauer(playersend, xsend, ysend, livesend));
        } else if (check.equals("Castle")) {
            figuressend.add(new Castle(playersend, xsend, ysend, livesend));
        } else if (check.equals("Armbrustschuetze")) {
            figuressend.add(new Armbrustschuetze(playersend, xsend, ysend, livesend));
        } else if (check.equals("Drache")) {
            figuressend.add(new Drache(playersend, xsend, ysend, livesend));
        } else if (check.equals("Katapult")) {
            figuressend.add(new Katapult(playersend, xsend, ysend, livesend));
        } else if (check.equals("Oger")) {
            figuressend.add(new Oger(playersend, xsend, ysend, livesend));
        } else if (check.equals("Priester")) {
            figuressend.add(new Priester(playersend, xsend, ysend, livesend));
        } else if (check.equals("Reiter")) {
            figuressend.add(new Reiter(playersend, xsend, ysend, livesend));
        } else if (check.equals("Schildwacht")) {
            figuressend.add(new Schildwacht(playersend, xsend, ysend, livesend));
        } else if (check.equals("Turm")) {
            figuressend.add(new Turm(playersend, xsend, ysend, livesend));
        } else if (check.equals("Uruk")) {
            figuressend.add(new Uruk(playersend, xsend, ysend, livesend));
        } else if (check.equals("Viper")) {
            figuressend.add(new Viper(playersend, xsend, ysend, livesend));
        } else if (check.equals("Waechter")) {
            figuressend.add(new Waechter(playersend, xsend, ysend, livesend));
        }
    }

    public void drawfigures(Fieldparts fields, Figures figur) {
        if (fields.X == figur.getX() && fields.Y == figur.getY()) {
            if (figur instanceof Castle) {
                if (!build) {
                    batch.draw(figur.getSpriteclick(), fields.Xpix, fields.Ypix);
                }
            } else if (fields.X == clickx && fields.Y == clicky) {
                batch.draw(figur.getSpriteclick(), fields.Xpix + 25, fields.Ypix + 25);
            } else {
                batch.draw(figur.getSprite(), fields.Xpix + 25, fields.Ypix + 25);
            }
        }
    }

    public void clickfigures(Fieldparts fields, int j, Figures figur) {
        boolean reset = true;
        if (figur.getX() == clickx && figur.getY() == clicky && fields.X == clickx && fields.Y == clicky && bewegenmalen == null) {
            bewegenmalen = calculate.calculatmove(clickx, clicky, j, figur);
            attackmalen = calculate.calculateattack(clickx, clicky, j, figur);
            clickf = figur;
        } else if (buildfigure >= 0 && clickrx == fields.X && clickry == fields.Y) {
            if (buildfigures(j)) {
                buildfigure = -1;
                resetclick();
                turnend = true;
            }
        } else if (clickf != null && clickrx > 0 && clickry > 0) {
            for (int k : attackmalen) {
                if (k >= 0) {
                    if (field.getFieldparts().get(k).getX() == clickrx && field.getFieldparts().get(k).getY() == clickry) {
                        reset = false;
                        break;
                    }
                }
            }
            if (reset) {
                resetclick();
            }
        }
    }

    public boolean buildfigures(int j) {
        if (buildfigure == 0) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Bauer(playerturn, clickrx, clickry, maxlive.getMaxlivebauer());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Bauer(playerturn, clickrx, clickry, maxlive.getMaxlivebauer());
                return true;
            }
        } else if (buildfigure == 1) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Armbrustschuetze(playerturn, clickrx, clickry, maxlive.getMaxlivearmbrustschuetze());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Armbrustschuetze(playerturn, clickrx, clickry, maxlive.getMaxlivearmbrustschuetze());
                return true;
            }
        } else if (buildfigure == 2) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Drache(playerturn, clickrx, clickry, maxlive.getMaxlivedrache());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Drache(playerturn, clickrx, clickry, maxlive.getMaxlivedrache());
                return true;
            }
        } else if (buildfigure == 3) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Katapult(playerturn, clickrx, clickry, maxlive.getMaxlivekatapult());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Katapult(playerturn, clickrx, clickry, maxlive.getMaxlivekatapult());
                return true;
            }
        } else if (buildfigure == 4) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Oger(playerturn, clickrx, clickry, maxlive.getMaxliveoger());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Oger(playerturn, clickrx, clickry, maxlive.getMaxliveoger());
                return true;
            }
        } else if (buildfigure == 5) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Priester(playerturn, clickrx, clickry, maxlive.getMaxlivepriester());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Priester(playerturn, clickrx, clickry, maxlive.getMaxlivepriester());
                return true;
            }
        } else if (buildfigure == 6) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Reiter(playerturn, clickrx, clickry, maxlive.getMaxlivereiter());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Reiter(playerturn, clickrx, clickry, maxlive.getMaxlivereiter());
                return true;
            }
        } else if (buildfigure == 7) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Schildwacht(playerturn, clickrx, clickry, maxlive.getMaxliveschildwacht());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Schildwacht(playerturn, clickrx, clickry, maxlive.getMaxliveschildwacht());
                return true;
            }
        } else if (buildfigure == 8) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Turm(playerturn, clickrx, clickry, maxlive.getMaxliveturm());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Turm(playerturn, clickrx, clickry, maxlive.getMaxliveturm());
                return true;
            }
        } else if (buildfigure == 9) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Uruk(playerturn, clickrx, clickry, maxlive.getMaxliveuruk());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Uruk(playerturn, clickrx, clickry, maxlive.getMaxliveuruk());
                return true;
            }
        } else if (buildfigure == 10) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Viper(playerturn, clickrx, clickry, maxlive.getMaxliveViper());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Viper(playerturn, clickrx, clickry, maxlive.getMaxliveViper());
                return true;
            }
        } else if (buildfigure == 11) {
            if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                buildfigur = new Waechter(playerturn, clickrx, clickry, maxlive.getMaxlivewaechter());
                return true;
            } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                buildfigur = new Waechter(playerturn, clickrx, clickry, maxlive.getMaxlivewaechter());
                return true;
            }
        }
        return false;
    }

    public void movefigur(Fieldparts fields, int i) {
        boolean moveble = true;
        if (fields.X == clickrx && fields.Y == clickry && bewegenmalen != null && clickf.getPlayer() == playerturn) {
            for (int k : bewegenmalen) {
                for (Figures figure : figures) {
                    if (fields.X == figure.getX() && fields.Y == figure.getY()) {
                        moveble = false;
                        break;
                    }
                }
                if (k == i && moveble) {
                    clickf.setX(clickrx);
                    clickf.setY(clickry);
                    clickf.setMoved(true);
                    resetclick();
                    break;
                }
            }
        }
    }

    public void attackfigure(Fieldparts fields, int i) {
        boolean attackeble = false;
        Figures attacked = null;
        if (fields.X == clickrx && fields.Y == clickry && attackmalen != null && clickf.getPlayer() == playerturn) {
            for (int k : attackmalen) {
                for (Figures figure : figures) {
                    if (k == i && fields.X == figure.getX() && fields.Y == figure.getY() && figure.getPlayer() != playerturn) {
                        attackeble = true;
                        attacked = figure;
                    }
                }

                if (attackeble) {
                    if (attacked instanceof Castle) {
                        if (attacked.getPlayer() == 1) {
                            clickf.setX(attacked.getX() + clickf.getAttackrange());
                        } else {
                            clickf.setX(attacked.getX() - clickf.getAttackrange());
                        }
                    } else {
                        if (attacked.getPlayer() == 1) {
                            attacked.setX(attacked.getX() - 1);
                        } else {
                            attacked.setX(attacked.getX() + 1);
                        }
                        clickf.setX(clickrx);
                        clickf.setY(clickry);
                    }
                    attacked.setLive(attacked.getLive() - clickf.getAttack());
                    clickf.setMoved(true);
                    clickf.setAttacked(true);
                    resetclick();
                    break;
                }
            }
        }
    }

    public void buildphase() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || turnend) {
            if (playerturn == 1) {
                playerturn = 2;
            } else if (playerturn == 2) {
                playerturn = 1;
            }
            turnbuild += 1;
            turnend = false;
            resetclick();
            send();
        }
        if (turnbuild == 10) {
            build = false;
        }
    }

    public void gamephase() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (playerturn == 1) {
                playerturn = 2;
            } else if (playerturn == 2) {
                playerturn = 1;
            }
            for (Figures figure : figures) {
                figure.setMoved(false);
            }
            send();
            resetclick();
        }

    }

    public void resetclick() {
        bewegenmalen = null;
        attackmalen = null;
        clickrx = -1;
        clickry = -1;
        clickx = -1;
        clicky = -1;
        clickf = null;
    }

    public void clickhandler() {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            clicky = click.clicksx();
            clickx = click.clicksy();
        }
        if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            clickry = click.clicksx();
            clickrx = click.clicksy();
        }
    }

    public void send() {
        sendstring = "";
        for (Figures sendfigures : figures) {
            sendstring += sendfigures.getName() + "#" + sendfigures.getPlayer() + "#" + sendfigures.getLive() + "#" + sendfigures.getX() + "#" + sendfigures.getY() + "-";
        }
        Thread t1 = new Thread(new Client(socket));
        t1.start();
    }

    public void end() {
        Texture win;
        if (figures != null) {
            player1live = 0;
            player2live = 0;
            for (Figures castlelive : figures) {
                if (castlelive instanceof Castle) {
                    if (castlelive.getPlayer() == 1) {

                        player1live += castlelive.getLive();

                    } else if (castlelive.getPlayer() == 2) {

                        player2live += castlelive.getLive();
                    }
                }
            }
        }
        if (player1live <= 0) {
            resetclick();
            player2win = true;

        } else if (player2live <= 0) {
            resetclick();
            player1win = true;

        }
        if (player1win || player2win) {
            figures = null;
            field = null;
            if (player2win) {
                win = new Texture("Player2win.png");
                batch.draw(win, 1200, 950);
                sendstring = "win2";
                Thread t1 = new Thread(new Client(socket));
                t1.start();
            } else if (player1win) {
                win = new Texture("Player2win.png");
                batch.draw(win, 1200, 950);
                sendstring = "win1";
                Thread t1 = new Thread(new Client(socket));
                t1.start();
            }
        }
    }


    public void connection() {
        try {
            socket = new Socket("185.194.217.213", 25565);
            Thread t2 = new Thread(new Listener(socket));
            t2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class Client extends Thread {

        PrintWriter writer;

        public Client(Socket socket) {

            try {
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                writer.println(sendstring);
                writer.flush();
                join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class Listener extends Thread {
        BufferedReader reader;

        public Listener(Socket socket) {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String line;
            while (true) {
                try {
                    line = reader.readLine();
                    if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                        System.out.println("[SOCKET] Socket disconnected");
                        System.exit(0);
                    } else {
                        System.out.println(line + "\n\r");
                        if (line.equals("full")) {
                            gamestart = true;
                        } else if (line.equals("win1")) {
                            player1win = true;
                        } else if (line.equals("win2")) {
                            player2win = true;
                        } else if (line.equals("1")) {
                            player = 1;
                        } else if (line.equals("2")) {
                            player = 2;
                        } else if (line.equals("newturn") && playerturn != player) {
                            newturn = true;
                            if (playerturn == 1) {
                                playerturn = 2;
                            } else if (playerturn == 2) {
                                playerturn = 1;
                            }
                        } else {
                            becomestring = line;
                        }

                    }
                } catch (IOException e) {
                    System.out.println("[SOCKET] Socket disconnected");
                    System.exit(0);
                }
            }
        }

    }
}





