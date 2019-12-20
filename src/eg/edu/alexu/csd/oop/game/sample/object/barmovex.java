package eg.edu.alexu.csd.oop.game.sample.object;

public class barmovex implements moveX {
    private int x;
    private int y;
   private int left;
    public barmovex(int x, int y,int left ) {
        this.x = x;
        this.y = y;
        this.left = left;
    }
    @Override
    public boolean moveX(int mX) {
        if(left == 0 &&  this.x <= 143 && mX < 143){
            return false;
        }else if(left == 1 && this.x  >= 630 && mX > 630){
           return false;
        }
        return true;
    }

    @Override
    public int moveY(int mY) {
      return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setcontro(boolean control) {

    }
}
