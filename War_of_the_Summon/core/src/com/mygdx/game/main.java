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
    boolean build = true;
    Figures bauer;
    ArrayList<Figures> figures = new ArrayList();
    int[] bewegenmalen = null;
    Calculate calculate = new Calculate();
    Figures clickf = null;
    int[] attackmalen = null;
    int playerturn = 1;

    @Override
    public void create() {
        batch = new SpriteBatch();
        field.generatField();
        bauer = new Bauer(1, 5, 5);
        figures.add(bauer);
        bauer = new Bauer(2, 10, 10);
        figures.add(bauer);
        bauer = new Bauer(1, 6, 5);
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
        if (build) {
            buildphase();
        } else {
            gamephase();
        }
        for (int i = 1; i < field.getFieldparts().size(); i++) {
            Fieldparts fields = field.getFieldparts().get(i);
            drawfield(fields, i);
            for (int j = 0; j < figures.size(); j++) {
                drawfigures(fields, figures.get(j));
                clickfigures(fields, i, figures.get(j));

            }
            movefigur(fields, i);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public void drawfield(Fieldparts fields, int i) {

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
            if (attackmalen != null && bewegenmalen != null) {
                for (int j = 0; j < attackmalen.length; j++) {
                    if (attackmalen[j] == i && attackmalen[j] > 0 && attackmalen[j] < 170) {
                        batch.draw(fields.getTextures().get(2), fields.Xpix, fields.Ypix);
                    }
                }
                for (int j = 0; j < bewegenmalen.length; j++) {
                    for (int k = 0; k < figures.size(); k++) {
                        if (bewegenmalen[j] == i && bewegenmalen[j] > 0 && bewegenmalen[j] < 170 && fields.X == figures.get(k).getX() && fields.Y == figures.get(k).getY() && figures.get(k).getPlayer() != playerturn) {
                            batch.draw(fields.getTextures().get(2), fields.Xpix, fields.Ypix);
                        } else if (bewegenmalen[j] == i && bewegenmalen[j] > 0 && bewegenmalen[j] < 170 && fields.X == figures.get(k).getX() && fields.Y == figures.get(k).getY() && figures.get(k).getPlayer() == playerturn) {
                            batch.draw(fields.getTextures().get(0), fields.Xpix, fields.Ypix);
                        } else if (bewegenmalen[j] == i && bewegenmalen[j] > 0 && bewegenmalen[j] < 170) {
                            batch.draw(fields.getTextures().get(1), fields.Xpix, fields.Ypix);
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
            bewegenmalen = calculate.calculatmove(clickx, clicky, j, figures);
            attackmalen = calculate.calculateattack(clickx, clicky, j, figures);
            clickf = figur;
        } else if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            clickx = -1;
            clicky = -1;
            bewegenmalen = null;
            attackmalen = null;
            clickf = null;
        }
    }

    public void movefigur(Fieldparts fields, int i) {
        if (fields.X == clickx && fields.Y == clicky && bewegenmalen != null && clickf.getPlayer() == playerturn) {
            for (int j = 0; j < bewegenmalen.length; j++) {
                if (bewegenmalen[j] == i) {
                    clickf.setX(clickx);
                    clickf.setY(clicky);
                    bewegenmalen = null;
                    attackmalen = null;
                    clickx = -1;
                    clicky = -1;
                    clickf = null;
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
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && playerturn == 2) {
            playerturn = 1;
        }
    }
}
