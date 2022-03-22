package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Click {
    private int mousex = 0;
    private int mousey = 0;

    /**Wertet den X Wert des Mausklicks aus
     *
     * @return den X Wert des Mausklicks
     */
    public int clicksx() {
            mousex = Gdx.input.getX()/82;
            return mousex;
    }

    /**Wertet den Y Wert des Mausklicks aus
     *
     * @return den Y Wert des Mausklicks
     */
    public int clicksy() {
            mousey = Math.abs(Gdx.input.getY()-1080)/82;
            return mousey;

    }


}
