package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Buildbuttons {
    ArrayList<Texture> textures1 = new ArrayList<>();
    ArrayList<Texture> texturesclick1 = new ArrayList<>();
    ArrayList<Texture> textures2 = new ArrayList<>();
    ArrayList<Texture> texturesclick2 = new ArrayList<>();
    ArrayList<Button> button1 = new ArrayList<>();
    ArrayList<Button> button2 = new ArrayList<>();
    Textures textures=new Textures();
    public Buildbuttons() {
        Texture();
        for (int i = 0; i < textures1.size(); i++) {
            button1.add(new Button(13 * 151, (13 + i) * 151, i, 13, textures1.get(i), texturesclick1.get(i)));
            button2.add(new Button(14 * 151, (13 + i) * 151, i, 13, textures2.get(i), texturesclick2.get(i)));
        }
    }


    public void Texture() {
        textures1.add(textures.getBauer1());
        texturesclick1.add(textures.getBauer1click());
        textures2.add(textures.getBauer2());
        texturesclick2.add(textures.getBauer2click());

    }

    public ArrayList<Button> getButton1() {
        return button1;
    }

    public ArrayList<Button> getButton2() {
        return button2;
    }
}
