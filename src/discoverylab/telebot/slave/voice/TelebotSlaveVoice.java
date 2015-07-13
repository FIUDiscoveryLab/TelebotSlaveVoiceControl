package discoverylab.telebot.slave.voice;

import discoverylab.telebot.slave.core.CoreSlaveComponent;
import jssc.SerialPort;

public class TelebotSlaveVoice extends CoreSlaveComponent {

	public TelebotSlaveVoice(){
	}
	
	public TelebotSlaveVoice(SerialPort serialPort) {
		super(serialPort);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean calibrate() {
		// TODO Auto-generated method stub
		return false;
	}
}