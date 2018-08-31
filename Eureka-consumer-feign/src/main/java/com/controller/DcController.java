package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DcController {
	private Log log = LogFactory.getLog(DcController.class);
	
	@Autowired
	DcClient dcClient;
	
	@RequestMapping("/consumer")
	@ResponseBody
	public String dc() {
		return dcClient.helloOne();
		//return dcClient.dc();
	}
	
}
