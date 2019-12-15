package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.LinkedList;
import java.util.List;

public class PlatesFacade {
    private static PlatesIntersection platesIntersection ;
    private  VanishSimilarPlates vanishSimilarPlates ;


    private boolean similar = false;
    private LinkedList<ImageObject> onBar = new LinkedList<>();
    private   LinkedList<GameObject> control = new LinkedList();

    public  PlatesFacade( LinkedList<ImageObject> onBar , LinkedList<GameObject> control ){
        this.control = control ;
        this .onBar = onBar ;
        platesIntersection = new PlatesIntersection();
        vanishSimilarPlates = new VanishSimilarPlates(onBar,control);
    }
    public boolean Similarity (){
        return platesIntersection.isSimilar(onBar);
    }
    public void  deleteSimilar (){
        vanishSimilarPlates.vanish(onBar,control);
    }
    public  int AddScore (){ return platesIntersection.addScore();}
    public  int getScore (){return platesIntersection.getScore();}



}
