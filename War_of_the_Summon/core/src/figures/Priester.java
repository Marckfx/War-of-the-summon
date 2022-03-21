package figures;

import com.badlogic.gdx.graphics.Texture;

public class Priester extends Figures{
    public Priester(int player, int x, int y, int live) {
        super("Priester",player, x, y, 4, live, 1, 1, 3, new Texture("Priester1.png"), new Texture("Priester2.png"), new Texture("Priester1click.png"), new Texture("Priester2click.png"), 0, false, false);
    }
}
