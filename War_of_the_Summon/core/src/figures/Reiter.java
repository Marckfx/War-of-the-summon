package figures;

import com.badlogic.gdx.graphics.Texture;

public class Reiter extends Figures{
    public Reiter(int player, int x, int y, int live) {
        super("Reiter",player, x, y, 5, live, 3, 1, 5, new Texture("Reiter1.png"), new Texture("Reiter2.png"), new Texture("Reiter1click.png"), new Texture("Reiter2click.png"), 0, false, false);
    }
}
