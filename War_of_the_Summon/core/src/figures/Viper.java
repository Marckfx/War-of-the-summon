package figures;

import com.badlogic.gdx.graphics.Texture;

public class Viper extends Figures{
    public Viper(int player, int x, int y, int live) {
        super("Viper",player, x, y, 4, live, 1, 1, 3, new Texture("Viper1.png"), new Texture("Viper2.png"), new Texture("Viper1click.png"), new Texture("Viper2click.png"), 0, false, false);
    }
}
