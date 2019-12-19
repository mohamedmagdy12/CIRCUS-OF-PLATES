package eg.edu.alexu.csd.oop.game.sample.object;

import java.util.LinkedList;
import java.util.List;

public class ScoreSubject implements Subject {
    List<Observer> observers = new LinkedList<>();
    private int score;
    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        int x = observers.indexOf(o);
        observers.remove(observers.get(x));
    }

    @Override
    public void notifyObserves() {
        for(Observer o : observers)
            o.update(score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        notifyObserves();
    }
}
