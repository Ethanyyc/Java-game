package FirstGame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener{
	JPanel panel=new JPanel();
	JFrame frame=new JFrame();
	ImageIcon tick=new ImageIcon("tick.png");
	JButton x=new JButton("start");
	
	public Frame(){
	
		frame.setSize(1200,640);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.add(x);
		frame.add(panel);
		

	}
	
	
	public static void main(String[] args) {
		Frame gui=new Frame();

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==x){
			System.out.println("haha");
			frame.setVisible(false);
			Start x=new Start();
		}
		
	}



}
