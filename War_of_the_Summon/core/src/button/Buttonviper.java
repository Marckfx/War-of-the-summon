package button;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Textures;

public class Buttonviper extends Button {
    Textures textures = new Textures();
    Texture texture;
    Texture textureclick;
    Texture texture2;
    Texture textureclick2;


    public Buttonviper(int XPix, int YPix, int x, int y) {
        super(XPix, YPix, x, y);
        this.texture = textures.getViper1();
        this.textureclick = textures.getViper1click();
        this.texture2 = textures.getViper2();
        this.textureclick2 = textures.getViper2click();

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