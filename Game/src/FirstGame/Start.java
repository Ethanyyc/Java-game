package FirstGame;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Start {
	
	public Start(){
		JFrame frame=new JFrame("Game");
		frame.setTitle("BEST GAME EVER ");
		frame.add(new Board());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 640);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		BackgroundMusic();
		
	}
	
	public static void BackgroundMusic(){
		File music=new File("BGM.wav");
		try{
		Clip sound=AudioSystem.getClip();
		sound.open(AudioSystem.getAudioInputStream(music));
		sound.start();
		sound.loop(Clip.LOOP_CONTINUOUSLY);
		}catch(Exception error){}
		
	}
}
