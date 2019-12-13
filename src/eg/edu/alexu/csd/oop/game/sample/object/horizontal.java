package eg.edu.alexu.csd.oop.game.sample.object;

public class horizontal implements ShapeState {
    moving shape;
    ObjectPool pool = ObjectPool.get_instance();

    public horizontal(moving shape) {
        this.shape = shape;
    }

    @Override
    public void move() {
        shape.setY(shape.getY() + 1);
        if (shape.getY() == 700 || shape.getImage().isVisible() == false) {
            pool.releaseImage(shape.getImage());
            shape.setState(shape.getVerticalmode());
        }
    }
}


