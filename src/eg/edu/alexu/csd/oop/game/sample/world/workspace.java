package eg.edu.alexu.csd.oop.game.sample.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.object.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class workspace implements World {
    private int x =0;
    private Subject subject;
    private Observer o1;
    public boolean Clicked;
 private JButton btn1;
    private static workspace workSpace = new workspace();
    private Originator originator = new Originator();
    private CareTaker careTaker;
    int up1 =1;
    int up2 =1;
  private static int timeofthegame = 60000;
  private double starttime =0;
  private double endtime =System.nanoTime()/1000000000.0;;
  private double passedtime =0;
  private double unprocessedtime =0;
  private int sw;
  private int sh;
  private ObjectPool pool;
  private  List<GameObject> constant = new LinkedList();
  private List<GameObject> moving = new LinkedList();
  private   List<GameObject> control = new LinkedList();
  private LevelFacade levelFacade = new LevelFacade();
  Level1 level1 = new Level1() ;
    private  int speed =10 ;


    public void setConstant(List<GameObject> constant) {
        this.constant = constant;
    }

    public void setMoving(List<GameObject> moving) {
        this.moving = moving;
    }

    public void setControl(List<GameObject> control) {
        this.control = control;
    }

    public int getControlSpeed() {
        return 10;
    }

    private LinkedList<ImageObject> onBar1 = new LinkedList<>();
    private LinkedList<ImageObject> onBar2 = new LinkedList<>();
    private PlatesIntersection platesIntersection = PlatesIntersection.getInstance();
    private VanishSimilarPlates  vanishSimilarPlates = VanishSimilarPlates.getInstance();
  //  private workspace workspace = new workspace();
    private PlatesFacade platesFacade ;
    private  Level1 l1  = new Level1();
    private  Level2 l2 = new Level2();
    private  Level3 l3  = new Level3();


    private int red = 0,blue = 0,pink = 0;

  private cloneFactory cloneFactory = new cloneFactory();

    public static workspace getInstance(){
        return workSpace;
    }
    private workspace(){}

    public workspace(int screenWidth, int screenHeight) throws CloneNotSupportedException {
      int dist =0;
      int dist2 = 0;
        sw = screenWidth;
        sh = screenHeight;
      ImageObject m = new ImageObject(screenWidth/2, (int)(screenHeight*0.8), "/clown2.png",3,false,0,new clownmoveX(screenWidth/2, (int)(screenHeight*0.8),false));
      control.add(m);
      //m.setMoveX(new clownmoveX(m.x,m.y,false));
      m.setContrable(true);

     btn1 = new JButton("undo");
     btn1.addActionListener(new ButtonListener(this));
      System.out.println(control.get(0).getHeight());
      System.out.println(control.get(0).getWidth());
      System.out.println(control.get(0).getX());
      System.out.println(control.get(0).getY());
      // moving objects (enemy)
      /*
      for(int i=0; i<20; i++) {
        ImageObject s = new ImageObject(0, 10, "/alien1.png", 3,true);
        System.out.println(s.getHeight());
        System.out.println(s.getWidth());
        s.setX(screenWidth + dist * 50 + 200*dist);
        moving.add(s);
        dist++;
      }
      */

     pool= ObjectPool.get_instance();
        pool.setWorld(this);
        moving = pool.aquireimage();

        moving = pool.aquireimage();
        careTaker = CareTaker.get_Instance();

      /*
      for(int i=0; i<20; i++) {
        ImageObject s = new ImageObject(0, 10, "/alien1.png", 3,false);

        s.setX(-1 * dist2 * 50 - 200*dist2);
        moving.add(s);
        dist2++;
      }


       */
      // constants objects (gold)


         subject = new ScoreSubject();
         o1 = new ScoreObserver();
         subject.register(o1);
        constant.add(new BarObject(0, 70, 150, true, Color.GREEN,0,new barmovex(0,70,0)));
      constant.add(new BarObject(sw-140, 70, 150, true, Color.GREEN,0,new barmovex(sw-140,70,1)));
        control.add(new BarObject(sw/3+110, (int)(sh*.8), 50, true, Color.ORANGE,0,new barmovex(sw/3+110,(int)(sh*.8),0)));
        control.add(new BarObject(2*sw/3-30, (int)(sh*.8), 50, true, Color.ORANGE,1,new barmovex(2*sw/3-30,(int)(sh*.8),1)));
      //control.add(new BarObject(sw/3, (int)(sh*.7), 50, true, Color.ORANGE));
      //control.add(new BarObject(2*sw/3, (int)(sh*.7), 50, true, Color.ORANGE));

    }


public boolean intersect(GameObject o1 , GameObject o2){
  //System.out.println(control.get(1).getX());
      if(o2.getY()  + o2.getHeight()*up1 == o1.getY() && ( ( o1.getX() >= o2.getX() && o1.getX() <= o2.getX() + o2.getWidth() ) || ( o1.getX() + o2.getWidth() >= o2.getX() && o1.getX() + o2.getWidth() <= o2.getX() + o2.getWidth() ) ))return true;
      return false;
}
  public boolean intersect2(GameObject o1 , GameObject o2){
    //System.out.println(control.get(1).getX());
    if(o2.getY()  + o2.getHeight()*up2 == o1.getY() && ( ( o1.getX() >= o2.getX() && o1.getX() <= o2.getX() + o2.getWidth() ) || ( o1.getX() + o2.getWidth() >= o2.getX() && o1.getX() + o2.getWidth() <= o2.getX() + o2.getWidth() ) ))return true;
    return false;
  }

  @Override
  public List<GameObject> getConstantObjects() {
    return constant;
  }

  @Override
  public List<GameObject> getMovableObjects() {
    return moving;
  }

  @Override
  public List<GameObject> getControlableObjects() {
    return control;
  }

  @Override
  public int getWidth() {
    return sw;
  }

  @Override
  public int getHeight() {
    return sh;
  }

   private int ones =1;
  @Override


  public boolean refresh() {
      System.out.println(control.get(0).getX());
     if(Clicked){
         int x = careTaker.getsize();
         if(ones > x)return true;
       //  System.out.println(careTaker.getMomento(x-ones).getMovable().get(0).getX());

         List<GameObject> movable = careTaker.getMomento(x-ones).getMovable();
         List<GameObject> statical = careTaker.getMomento(x-ones).getStatical();
         List<GameObject> controlable = careTaker.getMomento(x-ones).getControl();
         this.setMoving(movable);
         this.setConstant(statical);
         this.setControl(controlable);
         ones++;
         return true;
     }
     originator.setStatical((List<GameObject>) constant);
     originator.setMovable((List<GameObject>)moving);
      originator.setControl((List<GameObject>)control);
     careTaker.addMomento(originator.StoreInMomento());
      //System.out.println(control.get(2).getX());
      lock criticalSection = new lock();
      starttime = System.nanoTime()/1000000000.0;
      passedtime = starttime - endtime;
      endtime = starttime;
      unprocessedtime += passedtime;
    //System.out.println(unprocessedtime);
      if(unprocessedtime > 3){
          try {
              moving = pool.aquireimage();
              moving = pool.aquireimage();
          } catch (CloneNotSupportedException e) {
              e.printStackTrace();
          }
          unprocessedtime =0;
      }

    // 0 blue, 1 red, 2 pink
    for (GameObject m : moving ) {
        if( ((ImageObject)m).isInuse()) {
            if (intersect(control.get(1), m)) {
                up1++;
                try {
                    ImageObject copied = (ImageObject) cloneFactory.getColone((protoType) m);
                    copied.setContrable(true);
                    control.add(copied);
                    onBar1.add(copied);
                    platesFacade = new PlatesFacade(onBar1 , (LinkedList<GameObject>) control);
                    if (platesFacade.Similarity()) {

                        platesFacade.deleteSimilar();
                       // platesIntersection.addScore();
                      //  System.out.println( "    score =      " + platesIntersection.getScore());
                        ((ScoreSubject)subject).setScore( ((ScoreSubject)subject).getScore()+1);
                        /*
                        if ((((ScoreSubject)subject).getScore()) > 3 && platesIntersection.getScore() <5 ){
                            this.setSpeed(levelFacade.getLevelOneSpeed());
                            System.out.println("the speed of the facade  plates is  " + levelFacade.getLevelOneSpeed());
                            System.out.println("the speed of the plates is  " + this.getSpeed());
                            System.out.println("variable speed is "+ speed);
                        }else if (platesIntersection.getScore() >=5 && platesIntersection.getScore() <7){
                            this.setSpeed(levelFacade.getLevelTwoSpeed());
                            System.out.println("the speed of the facade plates is  " + levelFacade.getLevelTwoSpeed());
                            System.out.println("variable speed is "+ speed);
                        }else if (platesIntersection.getScore() >=7){
                            this.setSpeed(levelFacade.getLevelThreeSpeed());
                            System.out.println("the speed of the facade plates is  " + levelFacade.getLevelThreeSpeed());
                            System.out.println("the speed of  plates is  " + this.getSpeed());
                            System.out.println("variable speed is "+ speed);
                        }
                        */
                        up1 = up1 -3;

                    }
                 /*   if(platesIntersection.isSimilar(onBar1)){
                        System.out.println( "    score =      " + platesIntersection.addScore() );
                        for (int i=0;i<3;i++){
                            ImageObject temp = (ImageObject) onBar1.get(onBar1.size() - 1);
                            temp.setVisible(false);
                            control.remove(temp);
                            onBar1.removeLast();
                        }
                        up1 = up1 -3;
                    }*/

                    ((ImageObject) m).setVisible(false);
                    System.out.println(((ImageObject) m).getColor() +"           ?");
                    System.out.println("yes");
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            } else if (intersect2(control.get(2), m)) {
                up2++;
                try {
                    ImageObject copied = (ImageObject) cloneFactory.getColone((protoType) m);
                    copied.setContrable(true);
                    control.add(copied);
                    onBar2.add(copied);
                    platesFacade = new PlatesFacade(onBar2, (LinkedList<GameObject>) control);
                    if (platesFacade.Similarity()) {
                        platesFacade.deleteSimilar();
                       // platesIntersection.addScore();
                        ((ScoreSubject)subject).setScore( ((ScoreSubject)subject).getScore()+1);
                        /*
                        if (platesIntersection.getScore() > 2 && platesIntersection.getScore() <3 ){
                            this.setSpeed(levelFacade.getLevelOneSpeed());
                            System.out.println("the speed of the facade  plates is  " + levelFacade.getLevelOneSpeed());
                            System.out.println("the speed of the plates is  " + this.getSpeed());
                        }else if (platesIntersection.getScore() >=3 && platesIntersection.getScore() <4){
                            this.setSpeed(levelFacade.getLevelTwoSpeed());
                            System.out.println("the speed of the facade plates is  " + levelFacade.getLevelTwoSpeed());
                        }else if (platesIntersection.getScore() >=4){
                            this.setSpeed(levelFacade.getLevelThreeSpeed());
                            System.out.println("the speed of the facade plates is  " + levelFacade.getLevelThreeSpeed());
                            System.out.println("the speed of  plates is  " + this.getSpeed());
                        }
                        */
                        up2 = up2 -3;
                    }
                    /*if(platesIntersection.isSimilar(onBar2)){
                        System.out.println("    score =      " + platesIntersection.addScore() );
                        for (int i=0;i<3;i++){
                            ImageObject temp = (ImageObject) onBar2.get(onBar2.size() - 1);
                            temp.setVisible(false);
                            control.remove(temp);
                            onBar2.removeLast();
                        }
                        up2 = up2 -3;
                    }*/
                    ((ImageObject) m).setVisible(false);
                    System.out.println(((ImageObject) m).getColor() +"           ?");
                    System.out.println("yes");
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
            ((ImageObject) m).getMoveshape().moveshape();

        }

    }


    criticalSection.release();
    return true;
  }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        System.out.println("megzooooooooooooooooooooooooo");
      System.out.println("my speed is "+ speed);
        return speed;
    }
  @Override
  public String getStatus() {
    return "Score is " + Integer.toString(((ScoreObserver)o1).getScore());
  }


}
