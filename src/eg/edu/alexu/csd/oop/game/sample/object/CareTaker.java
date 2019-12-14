package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.LinkedList;
import java.util.List;


public class CareTaker {
    private static CareTaker instance;
    private List<Momento> saved = new LinkedList<>();
    public int getsize(){
        return saved.size();
    }
    protected CareTaker() {
    }


    public void addMomento(Momento m){
        saved.add(m);
        System.out.println(saved.size());
        System.out.println("hello");
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
