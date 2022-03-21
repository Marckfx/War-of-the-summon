package figures;

import com.badlogic.gdx.graphics.Texture;

public class Armbrustschuetze extends Figures{
    public Armbrustschuetze(int player, int x, int y, int live) {
        super("Armbrustschuetze",player, x, y, 2, live, 3, 3, 3, new Texture("Arbrustschuetze1.png"), new Texture("Arbrustschuetze2.png"), new Texture("Arbrustschuetze1click.png"), new Texture("Arbrustschuetze2click.png"), 0, false, false);
    }
}
