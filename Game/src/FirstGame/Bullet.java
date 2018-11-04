package FirstGame;

import java.awt.*;

import javax.swing.*;

public class Bullet {

	static int x,y;
	Image bullet;
	
	
	boolean visible = true;
	
	public Bullet(int startX,int startY){
		x=startX;
		y=startY;
		visible=true;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,128,128);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Image getImage(){
		return bullet;
	}

	public boolean getVisible(){
		return visible;
	}
	
	public void moveright(){
		ImageIcon right= new ImageIcon("bullet.png");
		bullet=right.getImage();
		x= x+8;
		if(x>1000){
			visible=false;
			
		}
		if(x<50){
			visible=false;
		}
	}
	
	public void moveleft(){
		ImageIcon left= new ImageIcon("bulletleft.png");
		bullet=left.getImage();
		x= x-8;
		if(x>1000){
			visible=false;
		}
		if(x<50){
			visible=false;
		}
	}
	
}
