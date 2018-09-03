package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DcController {
	
	private Log log = LogFactory.getLog(DcController.class);
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping("/dc")
	@ResponseBody
	private String dc() throws InterruptedException {
		Thread.sleep(5000L);
		String services="Service1: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
