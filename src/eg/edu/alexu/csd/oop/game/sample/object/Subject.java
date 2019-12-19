package eg.edu.alexu.csd.oop.game.sample.object;

public interface Subject {
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserves();
}
