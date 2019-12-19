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
    public int moveX(int mX) {
        if(mX <= 20)
            this.x = 20;
        else if(mX >= 650)
            this.x = 650;
        else this.x = mX;
        return this.x;
    }

    @Override
    public int moveY(int mY) {
        return this.y;
    }

    @Override
    public void setcontro(boolean control) {
        this.isContrable = control;
    }
}
