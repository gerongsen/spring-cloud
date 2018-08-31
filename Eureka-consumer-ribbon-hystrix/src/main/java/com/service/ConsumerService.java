package com.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerService {
	
	private Log log = LogFactory.getLog(ConsumerService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback")
	public String consumer() {
		log.info("-----------------------");
		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}
	
	public String fallback() {
		log.info("~~~~~~~~~~~~~~~~~~~~~~");
		return "不好意思啦，服务挂了";
	}
}
