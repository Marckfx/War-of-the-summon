package figures;

import com.badlogic.gdx.graphics.Texture;

public class Katapult extends Figures {
    public Katapult(int player, int x, int y, int live) {
        super("Katapult",player, x, y, 1, live, 5, 3, 1, new Texture("Katapult1.png"), new Texture("Katapult2.png"), new Texture("Katapult1click.png"), new Texture("Katapult2click.png"), 0, false, false);
    }
}
