package com.netlearning.client.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientController {

	@Value("${gitboy}")
	private String gitboyName;

	@RequestMapping("/testUser")
	public String testUser() {
		return gitboyName;
	}

}