package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class CareTaker {
    private static CareTaker instance;
    public int present = -1;
    public int size = 0;
    private HashMap<Integer,Momento> saved = new HashMap<>();
    public int getsize(){
        return size;
    }
    protected CareTaker() {
    }

    public void addMomento(Momento m){
        saved.put(++present,m);
        System.out.println(present);
        System.out.println("hello");
        size = present+1;
    }
    public Momento getMomento(int index){
        return saved.get(index);
    }

    public static CareTaker get_Instance(){
        if(instance == null){
            instance = new CareTaker();
        }
        return instance;
    }

}
