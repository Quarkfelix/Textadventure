package libary_version_2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer extends Thread{
	private ArrayList<File> musicFiles = new ArrayList<File>();
	private boolean loop = false;
	private float volume = (float) 0.0;
	
//constructor------------------------------------------------------------------------------------------------------------
	public MusicPlayer(String url) {
		musicFiles.add(new File(url));
	}	
	
	public MusicPlayer(String[] urls) {
		for (int i = 0; i < urls.length; i++) {
			musicFiles.add(new File(urls[i]));
		}
	}	
	
//run Method------------------------------------------------------------------------------------------------------------
	public void run() {
		while (true) {
			while (loop) {
				for (File file : musicFiles) {
					play(file);
				}
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
//methods---------------------------------------------------------------------------------------------------------------
	private void play(File file) {
		AudioInputStream audioInputStream;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
			FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volumeControl.setValue(volume);
			
			Thread.sleep(clip.getMicrosecondLength() / 1000);
			
			
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//getter-and-setter------------------------------------------------------------------------------------------------------
	public void setLoop(boolean state) {
		loop = state;
	}
	
	//value between 0 and 1
	public void setVolume(float numb) {
		volume = (float)(Math.log(numb) / Math.log(10.0) * 20.0);
	}
	
	
	
}





























//private File file;
//private Clip clip;
//public float volume = 1.0f;
//FloatControl volumeControl;
//private boolean loop = false;
//public boolean finished = true;
//private ArrayList<File> musicFiles = new ArrayList<File>();
//
//public MusicPlayer(String url) {
//	musicFiles.add(new File(url));
//	super.start();
//}	
//
////für mehrere songs bei erstellung
//public MusicPlayer(String[] urls) {
//	for (int i = 0; i < urls.length; i++) {
//		musicFiles.add(new File(urls[i]));
//	}
//	super.start();
//}	
//
//public void run() {
//	System.out.println("Music Player started in own Thread");
//	do {
//		if (finished) {
//			playClip();
//		}
//	} while(loop);
//}
//
//private void playClip() {
//	try { 
//		for (int i = 0; i < musicFiles.size(); i++) {
//			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFiles.get(i).getAbsoluteFile());
//			clip = AudioSystem.getClip();
//			clip.open(audioInputStream);
//			clip.start();
//			volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//			float v = (float)(Math.log(volume) / Math.log(10.0) * 20.0);
//			volumeControl.setValue(v); 
//			Thread.sleep(clip.getMicrosecondLength() / 1000);
//			finished = true;
//		}
//    } catch(Exception ex) {
//    	System.out.println("Error while playing sound.");
//    	finished = true;
//        ex.printStackTrace();
//    }
//	
//}
//
//public void setVolume(float volume) {
//	this.volume = volume;
//	float v = (float)(Math.log(volume) / Math.log(10.0) * 20.0);
//    try {
//		volumeControl.setValue(v); 
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//}
//
//public void addQue(String url) {
//	musicFiles.add(new File(url));
//}
//
//public void playLoop(boolean state) {
//	loop = true;
//	run();
//}
//
//
//public long getCliplength() {
//	return clip.getMicrosecondLength()/1000;
//}