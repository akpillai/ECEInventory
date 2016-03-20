package com.virginiatech.ece.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Component
public class LoginController {

	@Value("${page.login}")
	private String login;

	@RequestMapping("/")
	public String defaultPage() {
		return login;

	}

}
