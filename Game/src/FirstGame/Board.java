 package FirstGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{
	private int bossLife=5;
	Dude p;
	Image img;
	Timer time;
	Enemy en,en2,en3,en4,en5,en6,en7,en8,en9,en10,boss,box;
	
	private int score=0;
	public boolean gameover=false;
	public boolean win=false;
	static Font ammo=new Font("SanSerif",Font.BOLD,26);
	static Font scoretext=new Font("SanSerif",Font.BOLD,35);
	static Font end=new Font("SanSerif",Font.BOLD,80);
	
	public Board(){
				
		p=new Dude();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i=new ImageIcon("Background.png");
		img=i.getImage();
		time =new Timer(10,this);
		time.start();
		
		en=new Enemy(900,350,"dragon.gif");
		en2=new Enemy(1100,350,"treemonster.gif");
		en3=new Enemy(1700,350,"dragon.gif");
		en4=new Enemy(1900,350,"dragon.gif");
		box=new Enemy(2500,350,"box.png");
		en5=new Enemy(3300,350,"treemonster.gif");
		en6=new Enemy(3500,350,"treemonster.gif");
		en7=new Enemy(4100,350,"treemonster.gif");
		en8=new Enemy(4300,350,"dragon.gif");
		en9=new Enemy(4900,350,"dragon.gif");
		en10=new Enemy(5100,350,"treemonster.gif");
		boss=new Enemy(5900,350,"wizard.gif");
		
	}

	
	public void actionPerformed(ActionEvent e) {
		checkCollisions();
		ArrayList bullets = Dude.getBullets();
		for(int w=0; w<bullets.size(); w++){
			
			Bullet m=(Bullet) bullets.get(w);
			if(m.getVisible()==true&&p.direction==false){
			m.moveleft();
			}
			else if(m.getVisible()==true&&p.direction==true){
				m.moveright();
				}
			else{
				bullets.remove(w);
			}
		}
		
		p.move();

		if(p.x>500){
			en.move(p.getdx());
			en2.move(p.getdx());
			en3.move(p.getdx());
			en4.move(p.getdx());
			en5.move(p.getdx());
			en6.move(p.getdx());
			en7.move(p.getdx());
			en8.move(p.getdx());
			en9.move(p.getdx());
			en10.move(p.getdx());
			box.move(p.getdx());
			boss.move(p.getdx());
			
		}
		
		repaint();
	}
	
	public void checkCollisions(){
		Rectangle r1=en.getBounds();
		Rectangle r2=en2.getBounds();
		Rectangle r3=en3.getBounds();
		Rectangle r4=en4.getBounds();
		Rectangle r5=en5.getBounds();
		Rectangle r6=en6.getBounds();
		Rectangle r7=en7.getBounds();
		Rectangle r8=en8.getBounds();
		Rectangle r9=en9.getBounds();
		Rectangle r10=en10.getBounds();
		Rectangle rbox=box.getBounds();
		Rectangle rboss=boss.getBounds();
		
		ArrayList bullets = Dude.getBullets();
		for(int w=0; w<bullets.size(); w++){
			Bullet m=(Bullet) bullets.get(w);
			Rectangle m1=m.getBounds();
			if(r1.intersects(m1)&&en.Alive()){
				
				m.visible=false;
				en=new Enemy(0,0,"treemonster.gif");
				en.isAlive=false;
				score++;
			}
				
			else if(r2.intersects(m1)&&en2.Alive()){
			
				m.visible=false;
				en2=new Enemy(0,0,"treemonster.gif");
				en2.isAlive=false;
				score++;
			}
			
			else if(r3.intersects(m1)&&en3.Alive()){
				
				m.visible=false;
				en3=new Enemy(0,0,"dragon.gif");
				en3.isAlive=false;
				score++;
			}
			
			else if(r4.intersects(m1)&&en4.Alive()){
				
				m.visible=false;
				en4=new Enemy(0,0,"treemonster.gif");
				en4.isAlive=false;
				score++;
			}
			
			else if(r5.intersects(m1)&&en5.Alive()){
				
				m.visible=false;
				en5=new Enemy(0,0,"treemonster.gif");
				en5.isAlive=false;
				score++;
			}
			
			else if(r6.intersects(m1)&&en6.Alive()){
				
				m.visible=false;
				en6=new Enemy(0,0,"treemonster.gif");
				en6.isAlive=false;
				score++;
			}
			
			else if(r7.intersects(m1)&&en7.Alive()){
				
				m.visible=false;
				en7=new Enemy(0,0,"treemonster.gif");
				en7.isAlive=false;
				score++;
			}
			
			else if(r8.intersects(m1)&&en8.Alive()){
				
				m.visible=false;
				en8=new Enemy(0,0,"treemonster.gif");
				en8.isAlive=false;
				score++;
			}
			else if(r9.intersects(m1)&&en9.Alive()){
				
				m.visible=false;
				en9=new Enemy(0,0,"treemonster.gif");
				en9.isAlive=false;
				score++;
			}
			else if(r10.intersects(m1)&&en10.Alive()){
				
				m.visible=false;
				en10=new Enemy(0,0,"treemonster.gif");
				en10.isAlive=false;
				score++;
			}
			else if(rboss.intersects(m1)&&boss.Alive()){
				
				bossLife=bossLife-1;
				m.visible=false;
				score++;
				if(bossLife==0){
				boss=new Enemy(0,0,"treemonster.gif");
				boss.isAlive=false;
				}
			}
			
		}
		
		Rectangle d=p.getBounds();
		
		if(d.intersects(r1)||d.intersects(r2)||d.intersects(r3)||d.intersects(r4)||d.intersects(r5)||d.intersects(r6)||d.intersects(r7)||d.intersects(r8)||d.intersects(r9)||d.intersects(r10)||d.intersects(rboss)){
			gameover=true;
			
		}
		
		if(d.intersects(rbox)){
			p.ammo=p.ammo+10;
			box=new Enemy(0,0,"treemonster.gif");
			box.isAlive=false;
		}
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
			Graphics2D g2d=(Graphics2D) g;
			if((p.getX()-150) % 2400 == 1){
				p.nx=0;
			}
			if((p.getX()-1350) % 2400 == 1){
				p.nx2=0;
			}
			
			
			g2d.drawImage(img, 1100-p.nx2, 0, null);
			if(p.getX()>=150){
				g2d.drawImage(img, 1100-p.nx, 0, null);
			}
			
			if(gameover==false){
			g2d.drawImage(p.getImage(), p.left, p.getY(), null);
			}
			
			ArrayList bullets = Dude.getBullets();
			for(int w=0; w<bullets.size(); w++){
				
				Bullet m=(Bullet) bullets.get(w);
				g2d.drawImage(m.getImage(),m.getX(),m.getY(),null);
				
			}
			String s = Integer.toString(score);
			g2d.setColor(Color.CYAN);
			g2d.setFont(ammo);
			g2d.drawString("Ammo Left: "+ p.ammo, 970, 40);
			g2d.setFont(scoretext);
			g2d.drawString(s, 600, 40);
			
			if(gameover==true){
				g2d.setColor(Color.CYAN);
				g2d.setFont(end);
				g2d.drawString("Game Over", 350, 300);
				g2d.drawImage(p.getImageDeath(), p.left, p.getY(), null);
			}
			
			if(p.x>500){
				if(en.Alive()==true){
					g2d.drawImage(en.getImage(), en.getX(),en.getY(),null);
				}
				
				if(en2.Alive()==true){
					g2d.drawImage(en2.getImage(), en2.getX(),en2.getY(),null);
				}
				if(en3.Alive()==true){
					g2d.drawImage(en3.getImage(), en3.getX(),en3.getY(),null);
				}
				if(en4.Alive()==true){
					g2d.drawImage(en4.getImage(), en4.getX(),en4.getY(),null);
				}
				if(en5.Alive()==true){
					g2d.drawImage(en5.getImage(), en5.getX(),en5.getY(),null);
				}
				if(en5.Alive()==true){
					g2d.drawImage(en5.getImage(), en5.getX(),en5.getY(),null);
				}
				if(en6.Alive()==true){
					g2d.drawImage(en6.getImage(), en6.getX(),en6.getY(),null);
				}
				if(en7.Alive()==true){
					g2d.drawImage(en7.getImage(), en7.getX(),en7.getY(),null);
				}
				if(en8.Alive()==true){
					g2d.drawImage(en8.getImage(), en8.getX(),en8.getY(),null);
				}
				if(en9.Alive()==true){
					g2d.drawImage(en9.getImage(), en9.getX(),en9.getY(),null);
				}
				if(en10.Alive()==true){
					g2d.drawImage(en10.getImage(), en10.getX(),en10.getY(),null);
				}
				if(box.Alive()==true){
					g2d.drawImage(box.getImage(), box.getX(),box.getY(),null);
				}
				if(boss.Alive()==true){
					g2d.drawImage(boss.getImage(), boss.getX(),boss.getY(),null);
				}
				if(bossLife==0){
					g2d.setFont(end);
					g2d.drawString("You Win", 350, 300);
				}
				
			}
			
	}
	
	private class AL extends KeyAdapter{
		
		public void keyReleased(KeyEvent e){
			p.keyReleased(e);
		}
		
		public void keyPressed(KeyEvent e){
			p.keyPressed(e);
				
		}
	}
	

}
