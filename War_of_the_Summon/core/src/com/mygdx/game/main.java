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
import figures.Bauer;
import figures.Castle;
import figures.Figures;

import java.util.ArrayList;

public class main extends ApplicationAdapter {
    SpriteBatch batch;
    Field field = new Field();
    Click click = new Click();
    Buildbuttons buildbuttons = new Buildbuttons();
    Calculate calculate = new Calculate();
    int clickx = -1;
    int clicky = -1;
    int clickrx = -1;
    int clickry = -1;
    int playerturn = 1;
    int player1live = 40;
    int player2live = 40;
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
    String test = "";

    @Override
    public void create() {
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
        if (newturn) {
            getsend();
        }
        clickhandler();

        if (build) {
            buildphase();
        } else {
            gamephase();
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

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();

    }

    public void deletdeadfigurs() {
        Figures deletme = null;
        for (Figures dead : figures) {
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
                if (clickx == button2.getX() && clicky == button2.getY() || clickx == button1.getX() && clicky == button1.getY() && buildfigure < 0) {
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
        String send = test;
        String[] resultfigure = send.split("-");
        ArrayList<Figures> figuressend = new ArrayList<>();
        for (String figurestring : resultfigure) {
            String[] resultfigurestats = figurestring.split("#");
            Figures figuresend;
            int playersend = Integer.parseInt(resultfigurestats[1]);
            int livesend = Integer.parseInt(resultfigurestats[2]);
            int xsend = Integer.parseInt(resultfigurestats[3]);
            int ysend = Integer.parseInt(resultfigurestats[4]);
            if (resultfigurestats[0].equals("Bauer")) {
                figuresend = new Bauer(playersend, xsend, ysend, livesend);
                figuressend.add(figuresend);
            } else if (resultfigurestats[0].equals("Castle")) {
                figuresend = new Castle(playersend, xsend, ysend, livesend);
                figuressend.add(figuresend);
            }
        }
        figures = figuressend;
        newturn = false;
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
            if (buildfigure == 0) {
                if (playerturn == 1 && j <= 39 && j != 6 && j != 7 && j != 8) {
                    buildfigur = new Bauer(playerturn, clickrx, clickry, 3);
                    buildfigure = -1;
                    resetclick();
                    turnend = true;
                } else if (playerturn == 2 && j > 130 && j != 163 && j != 162 && j != 164) {
                    buildfigur = new Bauer(playerturn, clickrx, clickry, 3);
                    buildfigure = -1;
                    resetclick();
                    turnend = true;
                }
            }

        } else if (clickf != null && clickrx > 0 && clickry > 0) {
            for (int i = 0; i < attackmalen.length; i++) {
                if (attackmalen[i] >= 0) {
                    if (field.getFieldparts().get(attackmalen[i]).getX() == clickrx && field.getFieldparts().get(attackmalen[i]).getY() == clickry) {
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

    public void movefigur(Fieldparts fields, int i) {
        boolean moveble = true;
        if (fields.X == clickrx && fields.Y == clickry && bewegenmalen != null && clickf.getPlayer() == playerturn) {
            for (int j = 0; j < bewegenmalen.length; j++) {
                for (Figures figure : figures) {
                    if (fields.X == figure.getX() && fields.Y == figure.getY()) {
                        moveble = false;
                        break;
                    }
                }
                if (bewegenmalen[j] == i && moveble) {
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
            for (int j = 0; j < attackmalen.length; j++) {
                for (Figures figure : figures) {
                    if (attackmalen[j] == i && fields.X == figure.getX() && fields.Y == figure.getY() && figure.getPlayer() != playerturn) {
                        attackeble = true;
                        attacked = figure;
                    }
                }

                if (attackeble) {
                    if (attacked instanceof Castle) {
                        if (attacked.getPlayer() == 1) {
                            player1live -= clickf.getAttack();
                            clickf.setX(attacked.getX() + clickf.getAttackrange());
                        } else {
                            player2live -= clickf.getAttack();
                            clickf.setX(attacked.getX() - clickf.getAttackrange());
                        }
                        clickf.setMoved(true);
                        clickf.setAttacked(true);
                    } else {
                        if (attacked.getPlayer() == 1) {
                            attacked.setX(attacked.getX() - 1);
                            attacked.setLive(attacked.getLive() - clickf.getAttack());
                        } else {
                            attacked.setX(attacked.getX() + 1);
                            attacked.setLive(attacked.getLive() - clickf.getAttack());
                        }
                        clickf.setX(clickrx);
                        clickf.setY(clickry);
                        clickf.setMoved(true);
                        clickf.setAttacked(true);

                    }
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
            newturn = true;
        }
        if (turnbuild == 2) {
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
            newturn = true;
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
        String sendstring = "";
        for (Figures sendfigures : figures) {
            sendstring += sendfigures.getName() + "#" + sendfigures.getPlayer() + "#" + sendfigures.getLive() + "#" + sendfigures.getX() + "#" + sendfigures.getY() + "-";
            test = sendstring;
        }
    }
}
