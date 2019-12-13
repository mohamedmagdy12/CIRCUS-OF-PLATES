package eg.edu.alexu.csd.oop.game.sample.object;

public class vertical implements ShapeState{

    moving shape;
    public vertical(moving shape){
        this.shape = shape;
    }

    @Override
    public void move() {
          if(shape.isLeft()){
              shape.setX(shape.getX()-1);
              if(shape.getX() ==  600){
                  shape.setState(shape.getHorizontalmode());
              }
          }
          else {
              shape.setX(shape.getX() + 1);
              if(shape.getX() ==  150){
                  shape.setState(shape.getHorizontalmode());
              }
          }
    }
}
