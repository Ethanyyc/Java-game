package FirstGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {
	
	Image enemy;
	int x, y;
	boolean isAlive=true;
	
	public Enemy(int startx, int starty,String location){
		x=startx;
		y=starty;
		ImageIcon tm=new ImageIcon(location);
		enemy=tm.getImage();
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	public Image getImage(){
		return enemy;
	}

	public boolean Alive(){
		return isAlive;
	}
	 
	public void move(int dx){
		x=x-2;
	 }
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,92,100);
	}
}
