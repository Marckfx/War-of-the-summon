package button;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Textures;

public class Buttonschildwacht extends Button {
    Textures textures = new Textures();
    Texture texture;
    Texture textureclick;
    Texture texture2;
    Texture textureclick2;


    public Buttonschildwacht(int XPix, int YPix, int x, int y) {
        super(XPix, YPix, x, y);
        this.texture = textures.getSchildwacht1();
        this.textureclick = textures.getSchildwacht1click();
        this.texture2 = textures.getSchildwacht2();
        this.textureclick2 = textures.getSchildwacht2click();

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
