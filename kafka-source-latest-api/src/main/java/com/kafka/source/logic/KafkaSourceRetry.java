package com.kafka.source.logic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@ImportResource("classpath:/config/kafka-source-context.xml")
public class KafkaSourceRetry {
	
	private static Logger logger = Logger.getLogger(KafkaSourceRetry.class);
	
	@Autowired
	MessageChannel input_to_control_bus;
	
	@Scheduled(cron="*/50 * * * * *")
	void startAdapter(){
		//CODE COMMENTED OUT TO MAKE SURE THE ADAPTER IS NOT BEING STARTED
		//EVEN IF I UNCOMMENT THE CODE, THE 50 secs defined related to the cron are not respected.
		//That is, I send a message to the topic, and it is inmediately consumed
		logger.info("Starting my channel right now!");

		input_to_control_bus.send(new GenericMessage<String>("@kafkaInboundChannelAdapterTesting.start()"));
	}
}
