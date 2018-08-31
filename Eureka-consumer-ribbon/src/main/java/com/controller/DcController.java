package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class DcController {
	private Log log = LogFactory.getLog(DcController.class);
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/consumer")
	@ResponseBody
	public String dc() {
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://eureka-client/dc", String.class);
	    String body = responseEntity.getBody();
	    HttpStatus statusCode = responseEntity.getStatusCode();
	    int statusCodeValue = responseEntity.getStatusCodeValue();
	    HttpHeaders headers = responseEntity.getHeaders();
	    StringBuffer result = new StringBuffer();
	    result.append("responseEntity.getBody()：").append(body).append("<hr>")
	            .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
	            .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
	            .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
	    return result.toString();
	}
	
}
