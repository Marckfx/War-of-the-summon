package figures;

import com.badlogic.gdx.graphics.Texture;

public class Schildwacht extends Figures{
    public Schildwacht(int player, int x, int y, int live) {
        super("Schildwacht",player, x, y, 9, live, 2, 1, 1, new Texture("Schildwacht1.png"), new Texture("Schildwacht2.png"), new Texture("Schildwacht1click.png"), new Texture("Schildwacht2click.png"), 0, false, false);
    }
}
