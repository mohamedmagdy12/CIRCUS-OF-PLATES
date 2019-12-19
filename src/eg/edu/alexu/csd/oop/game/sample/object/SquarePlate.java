package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.World;

import java.awt.*;

public class SquarePlate extends ImageObject {
    public static  World world;
    public SquarePlate(int posX, int posY, int color, int width, int height, boolean visible, World world) {
        super(posX, posY, color, width, height, visible);
        this.world = world;
    }

    public ImageObject draw(){

        // 0 blue, 1 red, 2 pink
        boolean[] leftORRight = {true,false};

        switch ((this.getColor())){
            case 0 :
                ImageObject img0 = new ImageObject(this.getX(),this.getY(),"/alien0.png",3,(this.getX() == 0) ? false : true ,getColor(),new movingObjectX(this.getX(),this.getY(),false,world));
                img0.setColor(this.getColor());
               // img0.setMoveX(new movingObjectX(this.getX(),this.getY(),false,world));
                return img0;
            case 1:
                ImageObject img1 = new ImageObject(this.getX(),this.getY(),"/alien5.png",3,(this.getX() == 0) ? false : true ,getColor(),new movingObjectX(this.getX(),this.getY(),false,world));
                img1.setColor(this.getColor());
               // img1.setMoveX(new movingObjectX(this.getX(),this.getY(),false,world));
                return img1;
            default:
                ImageObject img2 = new ImageObject(this.getX(),this.getY(),"/alien2.png",3,(this.getX() == 0) ? false : true ,getColor(),new movingObjectX(this.getX(),this.getY(),false,world));
                img2.setColor(this.getColor());
                //img2.setMoveX(new movingObjectX(this.getX(),this.getY(),false,world));
                return img2;

        }


    }
}
