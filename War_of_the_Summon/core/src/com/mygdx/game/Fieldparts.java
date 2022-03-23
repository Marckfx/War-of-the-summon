package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Fieldparts {
    int X;
    int Y;
    int Xpix;
    int Ypix;

    ArrayList<Texture> textures = new ArrayList();

    public Fieldparts(int Xpix, int Ypix,int X,int Y) {
        this.X = X;
        this.Y = Y;
        this.Xpix=Xpix;
        this.Ypix=Ypix;
        textures.add(Textures.empty);
        textures.add(Textures.move);
        textures.add(Textures.attack);
        textures.add(Textures.action);
        textures.add(Textures.castle1);
        textures.add(Textures.castle2);
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

