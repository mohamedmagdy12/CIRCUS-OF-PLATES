package eg.edu.alexu.csd.oop.game.sample.object;

public class constantX implements moveX {
    @Override
    public boolean moveX(int mX) {
      return true;
    }

    @Override
    public int moveY(int mY) {
        return mY;
    }

    @Override
    public void setX(int mX) {

    }

    @Override
    public void setcontro(boolean control) {

    }
}
