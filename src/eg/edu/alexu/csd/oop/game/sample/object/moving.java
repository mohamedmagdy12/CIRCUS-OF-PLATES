package eg.edu.alexu.csd.oop.game.sample.object;

public class moving{
    private ShapeState state;
    private horizontal horizontalmode;
    private vertical verticalmode;
    private int x;
    private int y;
    private boolean left;
    private ImageObject image;

    public ImageObject getImage() {
        return image;
    }

    public moving(ImageObject image) {
        this.image = image;
        horizontalmode = new horizontal(this);
        verticalmode = new vertical(this);
        state = verticalmode;

    }

    public boolean isLeft() {
        return image.isLeft();
    }



    public int getX() {
        return image.getX();
    }

    public void setX(int x) {
        image.setX(x);
    }

    public int getY() {
        return image.getY();
    }

    public void setY(int y) {
       image.setY(y);
    }




    public horizontal getHorizontalmode() {
        return horizontalmode;
    }

    public vertical getVerticalmode() {
        return verticalmode;
    }

    public ShapeState getState() {
        return state;
    }

    public void setState(ShapeState state) {
        this.state = state;
    }

    public void moveshape(){
        state.move();
    }

}
