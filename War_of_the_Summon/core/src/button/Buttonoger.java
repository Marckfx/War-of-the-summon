package button;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Textures;

public class Buttonoger extends Button {

    Texture texture;
    Texture textureclick;
    Texture texture2;
    Texture textureclick2;


    public Buttonoger(int XPix, int YPix, int x, int y) {
        super(XPix, YPix, x, y);
        this.texture = Textures.oger1;
        this.textureclick = Textures.oger1click;
        this.texture2 = Textures.oger2;
        this.textureclick2 = Textures.oger2click;

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
