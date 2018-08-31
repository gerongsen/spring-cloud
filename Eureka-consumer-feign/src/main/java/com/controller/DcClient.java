package com.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client")
public interface DcClient {
	
	@RequestMapping("/dc")
	String dc();
	
	@RequestMapping("/hello/who1")
	String helloOne();
}
