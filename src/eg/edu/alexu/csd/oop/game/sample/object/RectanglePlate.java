package eg.edu.alexu.csd.oop.game.sample.object;

public class RectanglePlate extends ImageObject {

    public RectanglePlate(int posX, int posY, int color, int width, int height, boolean visible) {
        super(posX, posY, color, width, height, visible);
    }

    public ImageObject draw(){
        // 0 blue, 1 red, 2 pink
        boolean[] leftORRight = {true,false};

        switch (this.getColor()){
            case 0:
                ImageObject img0 = new ImageObject(this.getX(),this.getY(),"/alien1.png",3,(this.getX() == 0) ? false : true ,0);
                return img0;
            case 1:
                ImageObject img1 = new ImageObject(this.getX(),this.getY(),"/alien4.png",3,(this.getX() == 0) ? false : true ,1);
                return img1;
            default:
                ImageObject img2 = new ImageObject(this.getX(),this.getY(),"/alien3.png",3,(this.getX() == 0) ? false : true ,2);
                return img2;
        }
    }
}
