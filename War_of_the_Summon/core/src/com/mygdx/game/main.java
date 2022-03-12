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

    @Override
    public void create() {
        batch = new SpriteBatch();
        field.generatField();
        bauer = new Bauer(1, 5, 5);
        figures.add(bauer);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            build = false;
        }
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            clicky = click.clicksx();
            clickx = click.clicksy();
        }
        for (int i = 0; i < field.getFieldparts().size(); i++) {
            Fieldparts fields = field.getFieldparts().get(i);
            drawfield(fields, i);
            drawfigures(fields,i);
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
            if (i == 5 || i == 6 || i == 7 || i == 162 || i == 161 || i == 163) {
            } else if (i <= 13 * 3 - 1) {
                batch.draw(fields.getTextures().get(4), fields.Xpix, fields.Ypix);
            } else if (i >= 13 * 10) {
                batch.draw(fields.getTextures().get(5), fields.Xpix, fields.Ypix);
            }
        } else {
            if (fields.X == clickx && fields.Y == clicky) {
                batch.draw(fields.getTextures().get(1), fields.Xpix, fields.Ypix);
            } else if (i == 5 || i == 6 || i == 7) {
                batch.draw(fields.getTextures().get(4), fields.Xpix, fields.Ypix);
            } else if (i == 162 || i == 161 || i == 163) {
                batch.draw(fields.getTextures().get(5), fields.Xpix, fields.Ypix);
            } else {
                batch.draw(fields.getTextures().get(0), fields.Xpix, fields.Ypix);
            }
            if (bewegenmalen != null) {
                for (int j = 0; j < bewegenmalen.length; j++) {
                    if (bewegenmalen[j] == i&&bewegenmalen[j]>0) {
                        batch.draw(fields.getTextures().get(1), fields.Xpix, fields.Ypix);
                    }
                }
            }
        }

    }


    public void drawfigures(Fieldparts fields,int j) {

        for (int i = 0; i < figures.size(); i++) {
            if (fields.X == figures.get(i).getX() && fields.Y == figures.get(i).getY()) {

                if (fields.X == clickx && fields.Y == clicky) {
                    batch.draw(figures.get(i).getSpriteclick(), fields.Xpix + 25, fields.Ypix + 25);
                } else {
                    batch.draw(figures.get(i).getSprite(), fields.Xpix + 25, fields.Ypix + 25);
                }
            }
            if (figures.get(i).getX() == clickx && figures.get(i).getY() == clicky &&fields.X == clickx && fields.Y == clicky&& bewegenmalen == null) {
                System.out.println(j);
                bewegenmalen = calculate.calculatmove(clickx, clicky, j, figures);
            }
            else if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
                bewegenmalen=null;
            }

        }
    }
}
