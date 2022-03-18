package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import figures.Figures;

public class Button {
    Texture texture;
    Texture textureclick;
    int Xpix;
    int Ypix;
    int x;
    int y;
    public Button(int XPix, int YPix, int x , int y, Texture texture, Texture textureclick) {
        this.texture=texture;
        this.textureclick=textureclick;
        this.x=x;
        this.y=y;
        this.Xpix=XPix;
        this.Ypix=YPix;
    }



    public Texture getTexture() {
        return texture;
    }

    public Texture getTextureclick() {
        return textureclick;
    }

    public int getXpix() {
        return Xpix;
    }

    public int getYpix() {
        return Ypix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
