package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;
import java.util.ArrayList;

public class Fieldparts {
    int X = 0;
    int Y = 0;
    int Xpix=0;
    int Ypix=0;
    Texture empty = new Texture("Feldleer.png");
    Texture move = new Texture("Feldanbewegen.png");
    Texture attack = new Texture("Feldangriff.png");
    Texture action = new Texture("Feldaktion.png");
    Texture castle1 = new Texture("Feldanfeste1.png");
    Texture castle2 = new Texture("Feldanfeste2.png");
    ArrayList<Texture> textures = new ArrayList();

    public Fieldparts(int Xpix, int Ypix,int X,int Y) {
        this.X = X;
        this.Y = Y;
        this.Xpix=Xpix;
        this.Ypix=Ypix;
        textures.add(empty);
        textures.add(move);
        textures.add(attack);
        textures.add(action);
        textures.add(castle1);
        textures.add(castle2);

    }

    public ArrayList<Texture> getTextures() {
        return textures;
    }
}
