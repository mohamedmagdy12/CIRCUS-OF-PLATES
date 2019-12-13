package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;

public class Plate implements GameObject {

    private int x,y,color,width,height;
    boolean visible;

    public Plate(int posX,int posY,int color,int width,int height,boolean visible){
        
        this.setX(posX);
        this.setY(posY);
        this.color = color;
        this.width = width;
        this.height = height;
        this.visible = visible;
    }


    public void setColor(int color){
        this.color = color;
    }

    public int getColor(){
        return color;
    }


    public ImageObject draw() {
        return this.draw();
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int i) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int i) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return new BufferedImage[0];
    }

    public void setLeft(boolean b) {
        this.setLeft(b);
    }
}
