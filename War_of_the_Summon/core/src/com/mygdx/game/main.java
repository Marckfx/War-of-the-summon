package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Field field = new Field();
    Click click = new Click();
    int clickx = -1;
    int clicky = -1;
    boolean build = true;


    @Override
    public void create() {
        batch = new SpriteBatch();
        field.generatField();
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
        if (build) {
            for (int i = 0; i < field.getFieldparts().size(); i++) {
                Fieldparts fields = field.getFieldparts().get(i);
                if (fields.X == clickx && fields.Y == clicky) {
                    batch.draw(fields.getTextures().get(1), fields.Xpix, fields.Ypix);

                } else if (i == 5 || i == 6 || i == 7 || i == 162 || i == 161 || i == 163) {
                } else if (i <= 13 * 3 - 1) {
                    batch.draw(fields.getTextures().get(4), fields.Xpix, fields.Ypix);
                } else if (i >= 13 * 10) {
                    batch.draw(fields.getTextures().get(5), fields.Xpix, fields.Ypix);
                }

            }
        } else {

            for (int i = 0; i < field.getFieldparts().size(); i++) {
                Fieldparts fields = field.getFieldparts().get(i);
                if (fields.X == clickx && fields.Y == clicky) {
                    batch.draw(fields.getTextures().get(1), fields.Xpix, fields.Ypix);
                } else if (i == 5 || i == 6 || i == 7) {
                    batch.draw(fields.getTextures().get(4), fields.Xpix, fields.Ypix);
                } else if (i == 162 || i == 161 || i == 163) {
                    batch.draw(fields.getTextures().get(5), fields.Xpix, fields.Ypix);
                } else {
                    batch.draw(fields.getTextures().get(0), fields.Xpix, fields.Ypix);


                }
            }
        }


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
