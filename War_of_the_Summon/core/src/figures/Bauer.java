package figures;

import com.badlogic.gdx.graphics.Texture;



public class Bauer extends Figures {

    public Bauer(int player, int x, int y,int live) {
        super("Bauer",player, x, y, 3, 3,1,1, 2, new Texture("Bauer1.png"), new Texture("Bauer2.png"), new Texture("Bauer1click.png"), new Texture("Bauer2click.png"),2,false,false);
    }
}
