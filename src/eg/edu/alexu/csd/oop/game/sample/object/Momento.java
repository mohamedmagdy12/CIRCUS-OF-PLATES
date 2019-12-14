package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;

import java.util.List;

public class Momento {
    private List<GameObject> control;
    private List<GameObject> movable;
    private List<GameObject> statical;

    public Momento(List<GameObject> control, List<GameObject> movable, List<GameObject> statical) {
        this.control = control;
        this.movable = movable;
        this.statical = statical;
    }

    public List<GameObject> getControl() {
        return control;
    }

    public List<GameObject> getMovable() {
        return movable;
    }

    public List<GameObject> getStatical() {
        return statical;
    }
}
