package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import figures.Bauer;
import figures.Figures;

import java.util.ArrayList;

public class main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Field field = new Field();
    Click click = new Click();
    int clickx = -1;
    int clicky = -1;
    int clickrx = -1;
    int clickry = -1;
    boolean build = true;
    Figures bauer;
    ArrayList<Figures> figures = new ArrayList<>();
    int[] bewegenmalen = null;
    Calculate calculate = new Calculate();
    Figures clickf = null;
    int[] attackmalen = null;
    int playerturn = 1;

    @Override
    public void create() {
        batch = new SpriteBatch();
        field.generatField();
        bauer = new Bauer(1, 4, 3);
        figures.add(bauer);
        bauer = new Bauer(2, 12, 3);
        figures.add(bauer);
        bauer = new Bauer(1, 8, 3);
        figures.add(bauer);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            clicky = click.clicksx();
            clickx = click.clicksy();
        }
        if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            clickry = click.clicksx();
            clickrx = click.clicksy();
        }
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

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
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
        } else {
            if (i == 6 || i == 7 || i == 8) {
                batch.draw(fields.getTextures().get(4), fields.Xpix, fields.Ypix);
            } else if (i == 163 || i == 162 || i == 164) {
                batch.draw(fields.getTextures().get(5), fields.Xpix, fields.Ypix);
            } else {
                batch.draw(fields.getTextures().get(0), fields.Xpix, fields.Ypix);
            }
            if (attackmalen != null) {
                for (int value : attackmalen) {
                    if (value == i && value > 0 && value < 170) {
                        batch.draw(fields.getTextures().get(2), fields.Xpix, fields.Ypix);
                    }
                }
                if (bewegenmalen != null) {
                    for (int value : bewegenmalen) {
                        for (Figures figure : figures) {
                            if (value == i && value > 0 && value < 170 && fields.X == figure.getX() && fields.Y == figure.getY() && figure.getPlayer() != playerturn) {
                                batch.draw(fields.getTextures().get(2), fields.Xpix, fields.Ypix);
                            } else if (value == i && value > 0 && value < 170 && fields.X == figure.getX() && fields.Y == figure.getY() && figure.getPlayer() == playerturn) {
                                batch.draw(fields.getTextures().get(0), fields.Xpix, fields.Ypix);
                            } else if (value == i && value > 0 && value < 170) {
                                batch.draw(fields.getTextures().get(1), fields.Xpix, fields.Ypix);
                            }
                        }
                    }
                }
            }
        }
    }


    public void drawfigures(Fieldparts fields, Figures figur) {
        if (fields.X == figur.getX() && fields.Y == figur.getY()) {
            if (fields.X == clickx && fields.Y == clicky) {
                batch.draw(figur.getSpriteclick(), fields.Xpix + 25, fields.Ypix + 25);
            } else {
                batch.draw(figur.getSprite(), fields.Xpix + 25, fields.Ypix + 25);
            }
        }
    }

    public void clickfigures(Fieldparts fields, int j, Figures figur) {
        if (figur.getX() == clickx && figur.getY() == clicky && fields.X == clickx && fields.Y == clicky && bewegenmalen == null) {
            bewegenmalen = calculate.calculatmove(clickx, clicky, j, figur);
            attackmalen = calculate.calculateattack(clickx, clicky, j, figur);
            clickf = figur;
        } else if (figur.getX() != clickrx && figur.getY() != clickry && fields.X == clickrx && fields.Y == clickry) {
            resetclick();
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
                    resetclick();
                    attacked = null;
                    break;
                }
            }
        }
    }


    public void buildphase() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && playerturn == 1) {
            playerturn = 2;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && playerturn == 2) {
            build = false;
            playerturn = 1;
        }

    }

    public void gamephase() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && playerturn == 1) {
            playerturn = 2;
            for (Figures figure : figures) {
                figure.setMoved(false);
            }
            resetclick();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && playerturn == 2) {
            playerturn = 1;
            for (Figures figure : figures) {
                figure.setMoved(false);
            }
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
}
