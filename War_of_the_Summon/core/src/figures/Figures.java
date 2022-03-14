package figures;

import com.badlogic.gdx.graphics.Texture;

public class Figures {
    int maxlive;
    int live = maxlive;
    int attack;
    int move;
    Texture sprite;
    Texture spriteclick;
    int x;
    int y;
    int attackrange;
int spawntime;
int player;
    public Figures(int player, int x, int y, int maxlive, int attack,int attackrange, int move, Texture sprite1, Texture sprite2, Texture spriteclick1, Texture spriteclick2,int spawntime) {
        this.x = x;
        this.y = y;
        this.maxlive=maxlive;
        this.attack=attack;
        this.move=move;
        this.spawntime=spawntime;
        this.attackrange=attackrange;
        this.player=player;

        if (player == 1) {
            sprite = sprite1;
            spriteclick = spriteclick1;
        } else {
            sprite = sprite2;
            spriteclick = spriteclick2;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public Texture getSprite() {
        return sprite;
    }

    public Texture getSpriteclick() {
        return spriteclick;
    }

    public int getAttack() {
        return attack;
    }

    public int getMove() {
        return move;
    }

    public int getAttackrange() {
        return attackrange;
    }

    public int getPlayer() {
        return player;
    }
}
