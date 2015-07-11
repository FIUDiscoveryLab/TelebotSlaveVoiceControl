package discoverylab.telebot.slave.voice.test;

import TelebotDDSCore.Source.Java.Generated.master.voice.TMasterToSlaveVoice;
import TelebotDDSCore.Source.Java.Generated.master.voice.TOPIC_MASTER_TO_SLAVE_VOICE;
import discoverylab.telebot.slave.voice.TelebotSlaveVoice;
import discoverylab.telebot.slave.voice.listeners.TSlaveVoiceListener;

public class TelebotSlaveVoiceTest {
	public static void main(String arg[]){
		TelebotSlaveVoice telebotSlaveVoice = new TelebotSlaveVoice();
		
		TSlaveVoiceListener listener = new TSlaveVoiceListener();
		
		if(telebotSlaveVoice.initiateTransmissionProtocol(
				TOPIC_MASTER_TO_SLAVE_VOICE.VALUE, 
				TMasterToSlaveVoice.class, listener)){
			
		}
		else {
			
		}
	}
}