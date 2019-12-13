package eg.edu.alexu.csd.oop.game.sample.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.object.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class workspace implements World {

    private static workspace workSpace = new workspace();


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
    private final List<GameObject> constant = new LinkedList();
    private List<GameObject> moving = new LinkedList();
  private  final List<GameObject> control = new LinkedList();

    private LinkedList<ImageObject> onBar1 = new LinkedList<>();
    private LinkedList<ImageObject> onBar2 = new LinkedList<>();
    private PlatesIntersection platesIntersection = PlatesIntersection.getInstance();

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

      control.add(new ImageObject(screenWidth/2, (int)(screenHeight*0.8), "/clown2.png",3,false,0));
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
        moving = pool.aquireimage();
        moving = pool.aquireimage();
      /*
      for(int i=0; i<20; i++) {
        ImageObject s = new ImageObject(0, 10, "/alien1.png", 3,false);

        s.setX(-1 * dist2 * 50 - 200*dist2);
        moving.add(s);
        dist2++;
      }


       */
      // constants objects (gold)



        constant.add(new BarObject(0, 70, 150, true, Color.GREEN));
      constant.add(new BarObject(sw-140, 70, 150, true, Color.GREEN));
        control.add(new BarObject(sw/3+110, (int)(sh*.8), 50, true, Color.ORANGE));
        control.add(new BarObject(2*sw/3-30, (int)(sh*.8), 50, true, Color.ORANGE));
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

  @Override
  public boolean refresh() {
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
              /*
              ImageObject m = (ImageObject) moving.get(moving.size()-1);
              m.setX(0);
              m.setLeft(false);
              moving = pool.aquireimage();
              ImageObject m2 = (ImageObject) moving.get(moving.size()-1);
              m2.setX(725);
              m2.setLeft(true);
               */
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
                    control.add(copied);
                    onBar1.add(copied);
                    if(platesIntersection.isSimilar(onBar1)){
                        System.out.println( "    score =      " + platesIntersection.addScore() );
                        for (int i=0;i<3;i++){
                            ImageObject temp = (ImageObject) onBar1.get(onBar1.size() - 1);
                            temp.setVisible(false);
                            control.remove(temp);
                            onBar1.removeLast();
                        }
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
                    control.add(copied);
                    onBar2.add(copied);
                    if(platesIntersection.isSimilar(onBar2)){
                        System.out.println("    score =      " + platesIntersection.addScore() );
                        for (int i=0;i<3;i++){
                            ImageObject temp = (ImageObject) onBar2.get(onBar2.size() - 1);
                            temp.setVisible(false);
                            control.remove(temp);
                            onBar2.removeLast();
                        }
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

  @Override
  public String getStatus() {
    return "yes";
  }

  @Override
  public int getSpeed() {
    return 10;
  }

  @Override
  public int getControlSpeed() {
    return 10;
  }
}
