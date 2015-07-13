package discoverylab.telebot.slave.voice.test;

import java.util.Locale;
import java.util.Scanner;

import com.sun.speech.freetts.Age;
import com.sun.speech.freetts.Gender;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import TelebotDDSCore.Source.Java.Generated.master.voice.TMasterToSlaveVoice;
import TelebotDDSCore.Source.Java.Generated.master.voice.TOPIC_MASTER_TO_SLAVE_VOICE;
import discoverylab.telebot.slave.voice.TelebotSlaveVoice;
import discoverylab.telebot.slave.voice.listeners.TSlaveVoiceListener;

public class TelebotSlaveVoiceTest {
	private static final String VOICENAME_kevin = "kevin";
	
	public static void main(String arg[]){
		TelebotSlaveVoice telebotSlaveVoice = new TelebotSlaveVoice();
		
		TSlaveVoiceListener listener = new TSlaveVoiceListener();
		
		if(telebotSlaveVoice.initiateTransmissionProtocol(
				TOPIC_MASTER_TO_SLAVE_VOICE.VALUE, 
				TMasterToSlaveVoice.class, listener)){
			
		}
		else {
			
		}
		
		Voice voice;
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice("kevin16");
//		Voice kora = new Voice("kora", Gender.FEMALE, Age.YOUNGER_ADULT, "Kora AI", Locale.ENGLISH, null);
		
		voice.allocate();
		voice.speak("Good evening master Irvin");
		voice.speak("How may I be of service?");
		
		Voice[] voices = voiceManager.getVoices();
		
		for(Voice voiceSample: voices){
			System.out.println(voiceSample.getName());
		}
		
/*		while(true) {
			String words = new Scanner(System.in).nextLine();
			
			switch (words.toLowerCase()){
				case "hello":
					voice.speak("Hello!");
					break;
				case "what is your name?":
					voice.speak("My name is Hutch");
					break;
				case "what is your purpose?":
					voice.speak("To serve and protect");
					break;
				default:
					voice.speak("Searching for an answer");
					break;
			}
		}*/
	}
}