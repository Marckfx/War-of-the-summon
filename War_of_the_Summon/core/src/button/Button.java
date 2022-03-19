package button;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Textures;

public class Button {
    int Xpix;
    int Ypix;
    int x;
    int y;

    public Button(int XPix, int YPix, int x, int y) {
        this.Xpix = XPix;
        this.Ypix = YPix;
        this.x = x;
        this.y = y;
    }

    public Texture getTexture() {
        return null;
    }

    public Texture getTextureclick() {
        return null;
    }

    public Texture getTexture2() {
        return null;
    }

    public Texture getTextureclick2() {
        return null;
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
