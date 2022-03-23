package button;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Textures;

public class Buttonschildwacht extends Button {

    Texture texture;
    Texture textureclick;
    Texture texture2;
    Texture textureclick2;


    public Buttonschildwacht(int XPix, int YPix, int x, int y) {
        super(XPix, YPix, x, y);
        this.texture = Textures.schildwacht1;
        this.textureclick = Textures.schildwacht1click;
        this.texture2 = Textures.schildwacht2;
        this.textureclick2 = Textures.schildwacht2click;

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
