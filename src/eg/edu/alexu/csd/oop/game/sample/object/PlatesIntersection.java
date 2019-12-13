package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.security.Signature;
import java.util.LinkedList;
import java.util.List;

public class PlatesIntersection {
    private static PlatesIntersection platesIntersection = new PlatesIntersection();

    private int score = 0;
    private boolean similar = false;
    private List<ImageObject> onBar = new LinkedList<>();




    public PlatesIntersection(){};

    public static PlatesIntersection getInstance(){
        return platesIntersection;
    }



    public boolean isSimilar(List<ImageObject> onBar){
        int n = onBar.size();
        similar =false;
        if(n>=3){
            if(onBar.get(n-1).getColor() == onBar.get(n-2).getColor() && onBar.get(n-2).getColor()== onBar.get(n-3).getColor()){
                similar = true;
            }
        }
        return similar;
    }
    public int addScore(){
        score++;
        return score;
    }


}
