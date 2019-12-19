package eg.edu.alexu.csd.oop.game.sample.object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public class BarObject implements GameObject,protoType {
	public static final int SPRITE_HEIGHT = 5;
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int x;
	private int y;
	private moveX moveX;
	private int width;
	private boolean visible;
	private boolean horizontalOnly;
	private int left;

	public BarObject(int x, int y, int width,boolean horizontalOnly,Color color, int left) {
		this(x,y,width,horizontalOnly,color);
		this.left = left;
	}

	public BarObject(int posX, int posY, int width, boolean horizontalOnly, Color color){
		this.x = posX;
		this.y = posY;
		this.width = width;
		this.horizontalOnly = horizontalOnly;
		this.visible = true;
		// create a bunch of buffered images and place into an array, to be displayed sequentially
		spriteImages[0] = new BufferedImage(width, SPRITE_HEIGHT,	BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = spriteImages[0].createGraphics();
		g2.setColor(color);
		g2.setBackground(color);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(20));
	    g2.drawLine(0, 0, getWidth(),0 );
		g2.dispose();
	}

	public BarObject(int i, int i1, int i2, boolean b, Color orange, int i3, barmovex barmovex) {
		this(i,i1,i2,b,orange,i3);
		this.moveX = barmovex;
	}

	@Override
	public int getX() {
		return x;
	}



	@Override
	public void setX(int mX) {
		this.x  = moveX.moveX(mX);
		/*
		if(left == 1 && this.getX()  <= 125 && mX < 125){
          this.x = 125;
		}else if(left == 0 && this.getX()  >= 630  && mX > 630){
			this.x = 630;
		}else{
			this.x = mX;
		}
		*/

	}



	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
		if(horizontalOnly)
			return;
		this.y = mY;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return width;
	}

	@Override
	public int getHeight() {
		return SPRITE_HEIGHT;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}

	@Override
	public protoType makeCopy() throws CloneNotSupportedException {
		BarObject bar = (BarObject) super.clone();
		return bar;
	}
}
