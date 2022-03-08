package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Click {
    int mousex = 0;
    int mousey = 0;
    public int clicksx() {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            mousex = Gdx.input.getX()/151;

            return mousex;
        }
        return-1;
    }
    public int clicksy() {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {

            mousey = Math.abs(Gdx.input.getY()-1963)/151;
            return mousey;
        }
        return-1;
    }

}
