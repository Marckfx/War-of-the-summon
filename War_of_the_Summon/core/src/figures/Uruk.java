package figures;

import com.badlogic.gdx.graphics.Texture;

public class Uruk extends Figures{
    public Uruk(int player, int x, int y, int live) {
        super("Uruk",player, x, y, 6, live, 3, 1, 3, new Texture("Uruk1.png"), new Texture("Uruk2.png"), new Texture("Uruk1click.png"), new Texture("Uruk2click.png"), 0, false, false);
    }
}
