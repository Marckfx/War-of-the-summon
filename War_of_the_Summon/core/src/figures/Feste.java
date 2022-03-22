package figures;

import com.badlogic.gdx.graphics.Texture;

public class Feste extends Figures {
    public Feste(int player, int x, int y, int live) {
        super("Feste",player, x, y, 40, live, 0, 0, 0, new Texture("Feldanfeste1.png"), new Texture("Feldanfeste2.png"), new Texture("Feldanfeste1.png"), new Texture("Feldanfeste2.png"), 0, false, false);
    }
}
