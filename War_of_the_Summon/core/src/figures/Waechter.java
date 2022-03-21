package figures;

import com.badlogic.gdx.graphics.Texture;

public class Waechter extends Figures{
    public Waechter(int player, int x, int y, int live) {
        super("Waechter",player, x, y, 8, live, 4, 1, 3, new Texture("Waechter1.png"), new Texture("Waechter2.png"), new Texture("Waechter1click.png"), new Texture("Waechter2click.png"), 0, false, false);
    }
}
