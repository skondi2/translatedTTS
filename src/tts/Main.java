package tts;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import marytts.modules.synthesis.Voice;
import tts.TextToSpeech;

public class Main {

	// Necessary
	TextToSpeech			textToSpeech	= new TextToSpeech();

	// Logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// Variables
	private String result;

	// Threads
	Thread	speechThread;
	Thread	resourcesThread;

	// LiveRecognizer
	private LiveSpeechRecognizer recognizer;




	/**
	 * Java Main Application Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// // Be sure that the user can't start this application by not giving
		// the
		// // correct entry string
		// if (args.length == 1 && "SPEECH".equalsIgnoreCase(args[0]))
		//new Main();
		TextToSpeech textToSpeech = new TextToSpeech();
		Voice.getAvailableVoices().stream().forEach(System.out::println);

		textToSpeech.setVoice("dfki-poppy-hsmm"); // female voice
		String text = "Hello World";
		textToSpeech.speak(text, 1.5f, false, true);
		// else
		// Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Give me
		// the correct entry string..");

	}

}