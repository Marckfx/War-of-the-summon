package figures;

import com.badlogic.gdx.graphics.Texture;

public class Drache extends Figures{
    public Drache(int player, int x, int y, int live) {
        super("Drache",player, x, y, 3, live, 3, 1, 4, new Texture("Drache1.png"), new Texture("Drache2.png"), new Texture("Drache1click.png" ), new Texture("Drache2click.png"), 0, false, false);
    }
}
