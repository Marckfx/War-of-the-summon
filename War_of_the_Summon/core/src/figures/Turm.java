package figures;

import com.badlogic.gdx.graphics.Texture;

public class Turm extends Figures{

    public Turm(int player, int x, int y,int live) {
        super("Turm",player, x, y, 5, live,1,1, 0, new Texture("Turm1.png"), new Texture("Turm2.png"), new Texture("Turm1click.png"), new Texture("Turm2click.png"),2,false,false);
    }
}
