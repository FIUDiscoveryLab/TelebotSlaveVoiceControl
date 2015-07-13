package discoverylab.telebot.slave.voice.listeners;

import com.rti.dds.infrastructure.RETCODE_NO_DATA;
import com.rti.dds.infrastructure.ResourceLimitsQosPolicy;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.InstanceStateKind;
import com.rti.dds.subscription.SampleInfo;
import com.rti.dds.subscription.SampleInfoSeq;
import com.rti.dds.subscription.SampleStateKind;
import com.rti.dds.subscription.ViewStateKind;

import TelebotDDSCore.Source.Java.Generated.master.voice.TMasterToSlaveVoice;
import TelebotDDSCore.Source.Java.Generated.master.voice.TMasterToSlaveVoiceDataReader;
import TelebotDDSCore.Source.Java.Generated.master.voice.TMasterToSlaveVoiceSeq;
import discoverylab.telebot.slave.core.readers.CoreDataReaderAdapter;
import jssc.SerialPortException;

public class TSlaveVoiceListener extends CoreDataReaderAdapter {
	public void on_data_available(DataReader reader) {
		TMasterToSlaveVoiceDataReader tMasterVoiceReader = (TMasterToSlaveVoiceDataReader) reader;
		TMasterToSlaveVoiceSeq dataSeq = new TMasterToSlaveVoiceSeq();
		SampleInfoSeq infoSeq = new SampleInfoSeq();
		try {
			tMasterVoiceReader.read(
					dataSeq, 
					infoSeq,
					ResourceLimitsQosPolicy.LENGTH_UNLIMITED,
                    SampleStateKind.ANY_SAMPLE_STATE,
                    ViewStateKind.ANY_VIEW_STATE,
                    InstanceStateKind.ANY_INSTANCE_STATE);
			
			for(int i = 0; i < dataSeq.size(); i++) {
				SampleInfo info = (SampleInfo) infoSeq.get(i);
				
				if(info.valid_data) {					
					TMasterToSlaveVoice command = (TMasterToSlaveVoice)dataSeq.get(i);
					String commandStr = command.voiceCommand;
					
					switch(commandStr){
						case "HL":
							break;
						case "NM":
							break;
					}
					System.out.println("DDS DATA: " + commandStr);
//					getSerialPort().writeString(commandStr);
				}
			}
		} catch (RETCODE_NO_DATA noData) {
            // No data to process
        } 
//		catch (SerialPortException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		finally {
			tMasterVoiceReader.return_loan(dataSeq, infoSeq);
        }
	} 
}
