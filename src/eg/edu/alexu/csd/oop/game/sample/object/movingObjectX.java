package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.World;

public class movingObjectX implements moveX {
   private World world;
    private int x;
    private int y;
    private boolean isContrable;
    private int controledby;
    public movingObjectX(int x, int y,boolean isContrable,World world) {
        this.x = x;
        this.y = y;
        this.isContrable = isContrable;
        this.world = world;
    }

    public void setControledby(int controledby) {
        this.controledby = controledby;
    }

    @Override
    public boolean moveX(int mX) {
        if(!isContrable)
            return true;
        else{
            if ( (controledby == 2 && mX <= 143) || (controledby == 1 && mX >= 630)) {
                return false;
            }
        }
     return true;
    }
    @Override
    public int moveY(int mY) {
        if (!isContrable)
            this.y = mY;
        return this.y;
    }

    @Override
    public void setX(int mX) {
        this.x = mX;
    }

    @Override
    public void setcontro(boolean control) {
        this.isContrable = control;
    }
}
