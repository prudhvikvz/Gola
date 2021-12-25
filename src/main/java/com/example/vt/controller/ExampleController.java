package com.example.vt.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.vt.Model.Email;

@RestController
@RequestMapping("/home")
public class ExampleController {

	@RequestMapping(value = "template", method = RequestMethod.GET, produces = { "application/xml", "application/json" })
	public ResponseEntity<Email> template() throws Exception {
		VelocityEngine ve = new VelocityEngine();
		ve.init(); 
		Email email = new Email();
		email.setSubject("Test Mail");
		email.setText("Checking Velocity with Spring Boot");		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", email.getSubject());
//		model.put("body", email.getText());
//		ClassLoader classLoader = getClass().getClassLoader();
//        URL resource = classLoader.getResource("templates/email.vm");
//        Template t = ve.getTemplate("email.vm");
		String text = VelocityEngineUtils.mergeTemplateIntoString(ve, "templates/email.vm", "UTF-8", model);
		
		System.out.println(text);


		return new ResponseEntity<Email>(email, HttpStatus.OK);
	}

}