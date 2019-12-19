package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.World;

public class movingObjectX implements moveX {
   private World world;
    private int x;
    private int y;
    private boolean isContrable;
    public movingObjectX(int x, int y,boolean isContrable,World world) {
        this.x = x;
        this.y = y;
        this.isContrable = isContrable;
        this.world = world;
    }

    @Override
    public int moveX(int mX) {
        if(!isContrable)
            this.x = mX;
        else{
            if (world.getControlableObjects().get(1).getX() <= 0 || world.getControlableObjects().get(2).getX() >= 750)
                this.x = x;
            else this.x = mX;
        }
     return this.x;
    }
    @Override
    public int moveY(int mY) {
        if (!isContrable)
            this.y = mY;
        return this.y;
    }

    @Override
    public void setcontro(boolean control) {
        this.isContrable = control;
    }
}
