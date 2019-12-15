package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.LinkedList;
import java.util.List;

public class VanishSimilarPlates {

    private static VanishSimilarPlates vanishSimilarPlates = new VanishSimilarPlates();
    private LinkedList<ImageObject> onBar = new LinkedList<>();
    private   List<GameObject> control = new LinkedList();


    private VanishSimilarPlates(){};
    public static VanishSimilarPlates getInstance(){
        return vanishSimilarPlates;
    }
    public VanishSimilarPlates(LinkedList<ImageObject> onBar ,List<GameObject> control ){
        this.control = control ;
        this.onBar = onBar;
    }


    private int n = onBar.size();
    PlatesIntersection Intersection = new PlatesIntersection(onBar);


    public void vanish(LinkedList<ImageObject>onBar,  List<GameObject> control){
        if (Intersection.isSimilar(onBar)){
            for (int i=0;i<3;i++){
                ImageObject temp = (ImageObject) onBar.get(onBar.size() - 1);
                temp.setVisible(false);
                control.remove(temp);
                onBar.removeLast();
            }
        }
    }

}
