package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Textures {
    Texture Bauer1=new Texture("Bauer1.png");
    Texture Bauer1click=new Texture("Bauer1click.png");
    Texture Bauer2=new Texture("Bauer1.png");
    Texture Bauer2click=new Texture("Bauer1click.png");
    Texture empty = new Texture("Feldleer.png");
    Texture move = new Texture("Feldanbewegen.png");
    Texture attack = new Texture("Feldangriff.png");
    Texture action = new Texture("Feldaktion.png");
    Texture castle1 = new Texture("Feldanfeste1.png");
    Texture castle2 = new Texture("Feldanfeste2.png");

    public Texture getCastle2() {
        return castle2;
    }

    public Texture getCastle1() {
        return castle1;
    }

    public Texture getAction() {
        return action;
    }

    public Texture getAttack() {
        return attack;
    }

    public Texture getMove() {
        return move;
    }

    public Texture getEmpty() {
        return empty;
    }

    public Texture getBauer1() {
        return Bauer1;
    }

    public Texture getBauer1click() {
        return Bauer1click;
    }

    public Texture getBauer2() {
        return Bauer2;
    }

    public Texture getBauer2click() {
        return Bauer2click;
    }
}
