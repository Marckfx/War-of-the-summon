package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Fieldparts {
    int X = 0;
    int Y = 0;
    int Xpix=0;
    int Ypix=0;
    Textures texture =new Textures();
    ArrayList<Texture> textures = new ArrayList();

    public Fieldparts(int Xpix, int Ypix,int X,int Y) {
        this.X = X;
        this.Y = Y;
        this.Xpix=Xpix;
        this.Ypix=Ypix;
        textures.add(texture.getEmpty());
        textures.add(texture.getMove());
        textures.add(texture.getAttack());
        textures.add(texture.getAction());
        textures.add(texture.getCastle1());
        textures.add(texture.getCastle2());
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public ArrayList<Texture> getTextures() {
        return textures;
    }
}

