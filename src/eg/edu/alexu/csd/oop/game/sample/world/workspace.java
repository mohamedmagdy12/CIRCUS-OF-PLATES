package eg.edu.alexu.csd.oop.game.sample.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.Main;
import eg.edu.alexu.csd.oop.game.sample.object.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class workspace implements World {
    public LevelFacade level;
    private int x =0;
    private Subject subject;
    private Observer o1;
    public boolean UndoClicked;
    public boolean redoClicked;
    public boolean counitue;
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
  public boolean Undo2;
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
        if(x==1) return 10;
        if(x==2)return 20;
        else return 30;
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
        constant.add(new BarObject(0, 70, 150, true, Color.GREEN,0,new barmovex(0,70,1)));
      constant.add(new BarObject(sw-140, 70, 150, true, Color.GREEN,0,new barmovex(sw-140,70,0)));
        control.add(new BarObject(sw/3+110, (int)(sh*.8), 50, true, Color.ORANGE,0,new barmovex(sw/3+110,(int)(sh*.8),1)));
        control.add(new BarObject(2*sw/3-30, (int)(sh*.8), 50, true, Color.ORANGE,1,new barmovex(2*sw/3-30,(int)(sh*.8),0)));
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
    private int counter =0;
    private String status;

JFrame frame;
  @Override
  public boolean refresh() {

    if(counter == 60) {
        counter =0;
       String fn = JOptionPane.showInputDialog("1 for reply press cancel for exit");
       if(fn.equals("1")){
           redoClicked = true;
           careTaker.present = -1;

       }else return false;
    }

    if(redoClicked){
          ++careTaker.present;
          int x = careTaker.getsize();
          if(x == careTaker.present){
              return false;
          }
          List<GameObject> movable = careTaker.getMomento(careTaker.present).getMovable();
          List<GameObject> statical = careTaker.getMomento(careTaker.present).getStatical();
          List<GameObject> controlable = careTaker.getMomento(careTaker.present).getControl();
          this.setMoving(movable);
          this.setConstant(statical);
          this.setControl(controlable);
          return true;
      }

     originator.setStatical((List<GameObject>) constant);
     originator.setMovable((List<GameObject>)moving);
      originator.setControl((List<GameObject>)control);
     careTaker.addMomento(originator.StoreInMomento());
      lock criticalSection = new lock();
      starttime = System.nanoTime()/1000000000.0;
      passedtime = starttime - endtime;
      endtime = starttime;
      unprocessedtime += passedtime;

      if(Main.x==1) {

          if (unprocessedtime > 3) {
              counter++;
              try {
                  moving = pool.aquireimage();
                  moving = pool.aquireimage();
              } catch (CloneNotSupportedException e) {
                  e.printStackTrace();
              }
              unprocessedtime = 0;

          }
      }else if(Main.x==2){
          counter++;
          if (unprocessedtime > 2) {
              try {
                  moving = pool.aquireimage();
                  moving = pool.aquireimage();
              } catch (CloneNotSupportedException e) {
                  e.printStackTrace();
              }
              unprocessedtime = 0;
          }
      }else{
          counter++;
          if (unprocessedtime > 1) {
              try {
                  moving = pool.aquireimage();
                  moving = pool.aquireimage();
              } catch (CloneNotSupportedException e) {
                  e.printStackTrace();
              }
              unprocessedtime = 0;
          }
      }

    // 0 blue, 1 red, 2 pink
      Iterator var = this.getMovableObjects().iterator();
      GameObject m;
    while (var.hasNext()) {
        m = (GameObject)var.next();
        if( ((ImageObject)m).isInuse()) {
            if (intersect(control.get(1), m)) {
                up1++;
                try {
                    ImageObject copied = (ImageObject) cloneFactory.getColone((protoType) m);
                    copied.setContrable(true);
                    copied.setControlledby(1);
                    control.add(copied);
                    onBar1.add(copied);
                    platesFacade = new PlatesFacade(onBar1 , (LinkedList<GameObject>) control);
                    if (platesFacade.Similarity()) {

                        platesFacade.deleteSimilar();
                        ((ScoreSubject)subject).setScore( ((ScoreSubject)subject).getScore()+1);
                        up1 = up1 -3;

                    }
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
                    copied.setControlledby(2);
                    control.add(copied);
                    onBar2.add(copied);
                    platesFacade = new PlatesFacade(onBar2, (LinkedList<GameObject>) control);
                    if (platesFacade.Similarity()) {
                        platesFacade.deleteSimilar();
                        ((ScoreSubject)subject).setScore( ((ScoreSubject)subject).getScore()+1);

                        up2 = up2 -3;
                    }
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
       if(Main.x == 1)return Level1.getSpeed();
       else if(Main.x == 2)return Level2.getSpeed();
       else return Level3.getSpeed();
    }
  @Override
  public String getStatus() {
    return "Score is " + Integer.toString(((ScoreObserver)o1).getScore()) + "    time is: " + (60 - counter);
  }


}
