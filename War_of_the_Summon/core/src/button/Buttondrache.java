package button;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Textures;

public class Buttondrache extends Button {

    Texture texture;
    Texture textureclick;
    Texture texture2;
    Texture textureclick2;


    public Buttondrache(int XPix, int YPix, int x, int y) {
        super(XPix, YPix, x, y);
        this.texture = Textures.drache1;
        this.textureclick = Textures.drache1click;
        this.texture2 = Textures.drache2;
        this.textureclick2 = Textures.drache2click;

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
