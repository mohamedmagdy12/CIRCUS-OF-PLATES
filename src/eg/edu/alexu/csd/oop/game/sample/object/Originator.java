package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.LinkedList;
import java.util.List;


public class Originator implements Cloneable{
    private cloneFactory cloneFactory;
    private List<GameObject> control;
    private List<GameObject> movable;
    private List<GameObject> statical;

    public Originator() {
        this.cloneFactory = new cloneFactory();
    }

    public void setControl(List<GameObject> control){
        List<GameObject> New = null;
        try {
            New = take_copy(control);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        this.control = New;
        System.out.println(control.get(0).hashCode());
        System.out.println(New.get(0).hashCode());

    }

    public void setMovable(List<GameObject> movable) {
        List<GameObject> New = null;
      try {
         New = take_copy(movable);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
      this.movable = New;
        System.out.println(movable.get(0).hashCode());
        System.out.println(New.get(0).hashCode());
    }

    public void setStatical(List<GameObject> statical) {
        List<GameObject> cloned_list  = new LinkedList(statical);
        this.statical = cloned_list;
    }

    public Momento StoreInMomento(){
        System.out.println("memento is done");
        return new Momento(control,movable,statical);
    }

    public List<GameObject> RestoreMovableFromMomento(Momento momento){
        return momento.getMovable();
    }
    public List<GameObject> RestorestaticalFromMomento(Momento momento){
        return momento.getStatical();
    }
    public List<GameObject> RestorecontrolFromMomento(Momento momento){
        return momento.getControl();
    }

public List<GameObject> take_copy(List<GameObject> s) throws CloneNotSupportedException {
    List<GameObject> New = new LinkedList<GameObject>();
    for (GameObject m : s) {
        New.add((GameObject) cloneFactory.getColone((protoType)m));
    }
    return New;
}

/*
    @Override
    public protoType makeCopy() throws CloneNotSupportedException {
        List<GameObject> New = new LinkedList<GameObject>();
        for(GameObject m : s){
            New.add((ImageObject)super.clone());
        }
    }
    */

}
