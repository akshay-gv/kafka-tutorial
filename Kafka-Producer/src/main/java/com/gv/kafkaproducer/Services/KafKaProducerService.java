package com.gv.kafkaproducer.Services;

import com.gv.kafkaproducer.Common.AppConstants;
import com.gv.kafkaproducer.Model.Details;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafKaProducerService 
{
	private static final Logger logger = 
			LoggerFactory.getLogger(KafKaProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void produceData(Details detail)
	{
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME, detail);
		logger.info(String.format("Message sent -> %s", detail.toString()));
	}
}
