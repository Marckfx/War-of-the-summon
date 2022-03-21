package button;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Textures;

public class Buttonreiter extends Button {
    Textures textures = new Textures();
    Texture texture;
    Texture textureclick;
    Texture texture2;
    Texture textureclick2;


    public Buttonreiter(int XPix, int YPix, int x, int y) {
        super(XPix, YPix, x, y);
        this.texture = textures.getReiter1();
        this.textureclick = textures.getReiter1click();
        this.texture2 = textures.getReiter2();
        this.textureclick2 = textures.getReiter2click();

    }


    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public Texture getTextureclick() {
        return textureclick;
    }

    @Override
    public Texture getTexture2() {
        return texture2;
    }

    @Override
    public Texture getTextureclick2() {
        return textureclick2;
    }

}