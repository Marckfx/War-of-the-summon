package button;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Textures;

public class Buttonbauer extends Button {
    Textures textures = new Textures();
    Texture texture;
    Texture textureclick;
    Texture texture2;
    Texture textureclick2;


    public Buttonbauer(int XPix, int YPix, int x, int y) {
        super(XPix, YPix, x, y);
        this.texture = textures.getBauer1();
        this.textureclick = textures.getBauer1click();
        this.texture2 = textures.getBauer2();
        this.textureclick2 = textures.getBauer2click();

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
