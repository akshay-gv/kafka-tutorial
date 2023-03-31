package com.gv.kafkaproducer.Controller;

import com.gv.kafkaproducer.Model.Details;
import com.gv.kafkaproducer.Services.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.gv.kafkaproducer.Model.Details.Cache;

@RestController
public class KafkaProducerController {
	private final KafKaProducerService producerService;

	@Autowired
	public KafkaProducerController(KafKaProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping("/data")
	String insert(@RequestBody Details object)
	{
		Details detail = new Details(object.name, object.email, object.subject, object.message);

		// caching the data
		Cache.add(detail);

		// TODO: 3/14/23  kafka connection
		this.producerService.produceData(detail);

		return "Data Inserted to kafka";
	}

}