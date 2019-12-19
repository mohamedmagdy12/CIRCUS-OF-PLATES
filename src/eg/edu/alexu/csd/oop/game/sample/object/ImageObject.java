package eg.edu.alexu.csd.oop.game.sample.object;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//import com.sun.org.apache.xpath.internal.operations.Or;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;


public class ImageObject implements GameObject,protoType {
	private boolean Contrable;
	private World world;
	public ImageObject(int x, int y, String s, int i, boolean b, int i1, World world,moveX moveX) {
		this(x,y,s,i,b,i1);
		this.world =world;
		this.moveX = moveX;
	}


	public boolean isContrable() {
		return Contrable;
	}

	public void setContrable(boolean contrable) {
		Contrable = contrable;
	}

	private  moving moveshape;
	private moveX moveX;
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	public int x;
	//private boolean Contrable = false;

	/*public void setContrable(boolean contrable) {
		Contrable = contrable;
	}
*/

	public void setMoveX(moveX moveX) {
		this.moveX = moveX;
	}

	public int getColor() {
		return color;
	}
	public void setColor(int color){
		this.color = color;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int y;
	private boolean visible;
	private int type;
	private boolean left;
	private boolean inuse = false;
	private int color;


	public boolean isInuse() {
		return inuse;
	}

	public void setInuse(boolean inuse) {
		this.inuse = inuse;
	}

	public boolean isLeft() {
        return left;
    }

    public ImageObject(int posX, int posY, String path){
		this(posX, posY, path, 0,false,0);
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public ImageObject(int posX,int posY,int color,int width,int height,boolean visible){

		this.x=posX;
		this.y = posY;
		this.color = color;
		this.visible = visible;
	}

	public moving getMoveshape() {
		return moveshape;
	}
	public ImageObject(int posX, int posY, String path, int type, boolean left, int color,moveX moveX){
		this(posX,posY,path,type,left,color);
		this.moveX = moveX;
	}
	public ImageObject(int posX, int posY, String path, int type, boolean left, int color){
	    this.left = left;
		this.x = posX;
		this.y = posY;
		this.type = type;
		this.visible = true;

        this.moveshape = new moving(this);
		// create a bunch of buffered images and place into an array, to be displayed sequentially
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
 if(type == 1) {
	 BufferedImage before = spriteImages[0];
	 int w = before.getWidth();
	 int h = before.getHeight();
	 BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	 AffineTransform at = new AffineTransform();
	 at.scale(.1, .1);
	 AffineTransformOp scaleOp =
			 new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
	 after = scaleOp.filter(before, after);
	 spriteImages[0] = after;

 }
        if(type == 2) {
            BufferedImage before = spriteImages[0];
            int w = before.getWidth();
            int h = before.getHeight();
            BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            AffineTransform at = new AffineTransform();
            at.scale(.6, .6);
            AffineTransformOp scaleOp =
                    new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            after = scaleOp.filter(before, after);
            spriteImages[0] = after;

        }
	}



	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int mX)
	{
	  moveX.setcontro(isContrable());
      int x = moveX.moveX(mX);
      this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override

	public void setY(int mY) {
		moveX.setcontro(isContrable());
		this.y = moveX.moveY(mY);
	}



	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return spriteImages[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public protoType makeCopy() throws CloneNotSupportedException {
		//System.out.println("clone is available");
		ImageObject imageObject = (ImageObject) super.clone();
		return imageObject;
	}


	public ImageObject draw() {
		return this.draw();
	}
}
