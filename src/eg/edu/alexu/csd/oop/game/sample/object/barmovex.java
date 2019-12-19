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
    public int moveX(int mX) {
        if(left == 1 && this.x <= 125 && mX < 125){
            this.x = 125;
        }else if(left == 0 && this.x  >= 630  && mX > 630){
            this.x = 630;
        }else{
            this.x = mX;
        }
        return this.x;
    }

    @Override
    public int moveY(int mY) {
      return this.y;
    }

    @Override
    public void setcontro(boolean control) {

    }
}
