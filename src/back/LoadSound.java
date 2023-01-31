package back;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class LoadSound {
	public AudioInputStream LoadSound(String name) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		
		return AudioSystem.getAudioInputStream(
				getClass().getClassLoader().getResource("resources/" + name));
	}
}
