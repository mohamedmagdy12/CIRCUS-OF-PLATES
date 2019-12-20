package eg.edu.alexu.csd.oop.game.sample.object;

public class clownmoveX implements moveX{
    private int x;
    private int y;
    private boolean isContrable;

    public clownmoveX(int x, int y,boolean isContrable) {
        this.x = x;
        this.y = y;
        this.isContrable = isContrable;
    }

    @Override
    public boolean moveX(int mX) {
        if(mX <= 20)
            return false;
        else if(mX >= 650)
            return false;

        return true;
    }

    @Override
    public int moveY(int mY) {
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
