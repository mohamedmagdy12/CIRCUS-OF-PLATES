package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.world.workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ObjectPool {
    private static ObjectPool instance = null;
    private ArrayList <GameObject> reusables ;
    private int maxsize = 20;

    private PlateFactory plateFactory = PlateFactory.getInstance();

    private workspace workSpace = workspace.getInstance();

    private Random random = new Random();
    private int iterator = 0;


    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    protected ObjectPool(){
        reusables = new ArrayList<>();
    }

   int direct =0;
    public ArrayList<GameObject> aquireimage() throws CloneNotSupportedException {

        if (reusables.size() < maxsize) {
            ImageObject plate = plateFactory.generatePlate();
            ImageObject object = plate.draw();
            object.setInuse(true);
            reusables.add(object);
            if(direct == 0){
                object.setX(0);
                object.setLeft(false);
                direct =1;
            }else{
                object.setX(725);
                object.setLeft(true);
                direct =0;
            }
            object.setVisible(true);
        } else {
            Collections.shuffle(reusables);
            for (GameObject m : reusables) {
                if (!((ImageObject)m).isInuse()) {
                    ((ImageObject)m).setInuse(true);
                    if(direct == 0){
                        m.setX(0);
                        m.setY(30);
                        ((ImageObject)m).setLeft(false);
                        direct =1;
                    }else{
                        m.setX(725);
                        m.setY(30);
                        ((ImageObject)m).setLeft(true);
                        direct =0;
                    }
                    ((ImageObject) m).setVisible(true);
                    break;
                }
            }
         }
        return reusables;
    }
    public void releaseImage(ImageObject m){
        m.setInuse(false);
    }

    public static  ObjectPool get_instance(){
        if(instance == null){
            instance = new ObjectPool();
        }
        return instance;
    }



}
