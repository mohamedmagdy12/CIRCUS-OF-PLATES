package eg.edu.alexu.csd.oop.game.sample.object;


import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.List;

public class LevelFacade  {
   private Level1 level1 = new Level1();
    private Level2 level2 = new Level2();
    private Level3 level3 = new Level3();

  public int getLevelOneSpeed (){
      return level1.getSpeed();
  }
    public int getLevelTwoSpeed (){
        return level2.getSpeed();
    }
    public int getLevelThreeSpeed (){
        return level3.getSpeed();
    }

}
