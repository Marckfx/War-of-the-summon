package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Click {
    private int mousex = 0;
    private int mousey = 0;
    public int clicksx() {
            mousex = Gdx.input.getX()/82;
            return mousex;
    }
    public int clicksy() {
            mousey = Math.abs(Gdx.input.getY()-1080)/82;
            return mousey;

    }


}
