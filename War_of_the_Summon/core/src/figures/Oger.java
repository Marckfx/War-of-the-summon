package figures;

import com.badlogic.gdx.graphics.Texture;

public class Oger extends Figures{
    public Oger(int player, int x, int y, int live) {
        super("Oger",player, x, y, 8, live, 4, 1, 3, new Texture("Oger1.png"), new Texture("Oger2.png"), new Texture("Oger1click.png"), new Texture("Oger2click.png"), 0, false, false);
    }
}
