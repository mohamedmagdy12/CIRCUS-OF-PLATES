package eg.edu.alexu.csd.oop.game.sample.object;

import java.util.Random;

public class PlateFactory {


    private static PlateFactory plateFactory = new PlateFactory();
    private Random random = new Random();

    private PlateFactory(){}

    public static PlateFactory getInstance(){
        return plateFactory;
    }

    public ImageObject generatePlate(){

       int sqORrec = random.nextInt(2);
       int[] x = {0,725};
       int XAXIS = x[random.nextInt(2)];


       // 0 squareImg , 1 RectangleImg
       if(sqORrec == 1){
          return new RectanglePlate(XAXIS,30,random.nextInt(3),60,30,true);
       }else{
           return new SquarePlate(XAXIS,30,random.nextInt(3),60,30,true);
       }

    }

}
