package FirstGame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Dude {
int x,dx,y,nx2,nx,left;
Image player,death;

int ammo=20;
boolean direction;

ImageIcon i=new ImageIcon("walking.gif");
ImageIcon i1=new ImageIcon("walking_reverse.gif");
ImageIcon i2=new ImageIcon("gravestone.png");

static ArrayList bullets;

public Dude(){
	player=i.getImage();
	death=i2.getImage();
	left=350;
	x=75;
	y=300;
	nx2=1100;
	nx=0;
	bullets=new ArrayList();
}

public Rectangle getBounds(){
	return new Rectangle(left,y,120,200);
}

public static ArrayList getBullets(){
	return bullets;
	
}

public void fire(){
	if(ammo>0){
		ammo--;
		Bullet z= new Bullet((left+70),(y+20));
		bullets.add(z);
	}
}

public void move(){
	if(dx!=-2){
		if(left+dx<=350){
			left=left+dx;
		}
		else{
			x=x+dx;
			nx2=nx2+dx;
			nx=nx+dx;
		}
		
	}
	
	else{
		if(left+dx>0){
			left=left+dx;
		}
	}
	
}

public int getX(){
	return x;
}

public int getY(){
	return y;
}

public int getnX2(){
	return nx2;
}

public int getdx(){
	return dx;
}

public Image getImage(){
	return player;
}

public Image getImageDeath(){
	return death;
}

public boolean getDirection(){
	return direction;
}

public void keyPressed(KeyEvent e){
	int key=e.getKeyCode();
	
	if(key==KeyEvent.VK_LEFT){
		dx=-2;
		player=i1.getImage();
		direction=false;
		
	}
	
	if(key==KeyEvent.VK_RIGHT){
		dx=2;
		player=i.getImage();
		direction=true;
	}
	
	if(key==KeyEvent.VK_UP){
		if(y==300){
			y=y-150;	
			}
		
	}
	
	if(key==KeyEvent.VK_SPACE){
		fire();
	}
	
}

public void keyReleased(KeyEvent e){
	int key=e.getKeyCode();
	
	if(key==KeyEvent.VK_LEFT){
		dx=0;
		
	}
	
	if(key==KeyEvent.VK_RIGHT){
		dx=0;
	}
	
	if(key==KeyEvent.VK_UP){
		y=y+150;
	}

}


}
