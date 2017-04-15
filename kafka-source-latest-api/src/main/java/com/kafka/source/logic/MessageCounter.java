package com.kafka.source.logic;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@ImportResource("classpath:/config/kafka-source-context.xml")
public class MessageCounter {
	private static Logger logger = Logger.getLogger(MessageCounter.class);
	
	@Autowired
	MessageChannel input_to_control_bus;

	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	
	@ServiceActivator
	public void countingAndStop(){
		logger.info("counting messages:"+atomicInteger.incrementAndGet());
		
		int atomicIntegerCurrentValue = atomicInteger.get() ;
		
		if(atomicInteger.get() == 10){
			logger.info("Stoped Since:"+atomicIntegerCurrentValue);
			input_to_control_bus.send(new GenericMessage<String>("@kafkaInboundChannelAdapterTesting.stop()"));
		}
	}
}
