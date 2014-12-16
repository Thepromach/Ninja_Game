package Engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ResourceReader {

	public static BufferedImage getImage(String name){
		try {
			return ImageIO.read(new File("res/" + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static AudioInputStream getAudio(String name){
		AudioInputStream audio = null;
		try {
			audio = AudioSystem.getAudioInputStream(new File("res/" + name));
		} catch (UnsupportedAudioFileException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return audio;
		
	}
}
