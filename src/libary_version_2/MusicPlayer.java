package libary_version_2;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

//spielt musik ab die man ihm übergibt
public class MusicPlayer extends Thread{
	private File file;
	private Clip clip;
	public float volume = 1.0f;
	FloatControl volumeControl;
	private boolean loop = false;
	
	public MusicPlayer(String musicName) {
		file = new File(musicName);
		super.start();
	}	
	
	public void run() {
		do {
			System.out.println("mp");
			playClip();
		} while(loop);
	}
	
	private void playClip() {
		try { 
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        float v = (float)(Math.log(volume) / Math.log(10.0) * 20.0);
	        volumeControl.setValue(v); 
	        
	        Thread.sleep(clip.getMicrosecondLength() / 1000);
	    } catch(Exception ex) {
	        System.out.println("Error while playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
		float v = (float)(Math.log(volume) / Math.log(10.0) * 20.0);
        try {
			volumeControl.setValue(v); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void playLoop(boolean state) {
		loop = true;
	}
	
}

