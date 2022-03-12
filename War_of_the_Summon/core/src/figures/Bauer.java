package figures;

import com.badlogic.gdx.graphics.Texture;


public class Bauer extends Figures {
    public Bauer(int player, int x, int y) {
        super(player, x, y, 3, 1, 3, new Texture("Bauer1.png"), new Texture("Bauer2.png"), new Texture("Bauer1click.png"), new Texture("Bauer2click.png"));
    }
}
