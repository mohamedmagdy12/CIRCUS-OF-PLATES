package eg.edu.alexu.csd.oop.game.sample.object;

import java.util.LinkedList;
import java.util.List;

public class VanishSimilarPlates {

    private static VanishSimilarPlates vanishSimilarPlates = new VanishSimilarPlates();
    private List<ImageObject> onBar = new LinkedList<>();


    private VanishSimilarPlates(){};
    public static VanishSimilarPlates getInstance(){
        return vanishSimilarPlates;
    }
    public VanishSimilarPlates(List<ImageObject> onBar){
        this.onBar = onBar;
    }

    private PlatesIntersection platesIntersection = PlatesIntersection.getInstance();
    private int n = onBar.size();

    public void vanish(){

    }

}
