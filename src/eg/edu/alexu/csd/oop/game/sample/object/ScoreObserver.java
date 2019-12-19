package eg.edu.alexu.csd.oop.game.sample.object;


import eg.edu.alexu.csd.oop.game.World;

public class ScoreObserver implements Observer {

    private int score;
    @Override
    public void update(int score) {
      this.score = score;
    }

    public int getScore() {
        return score;
    }
}
