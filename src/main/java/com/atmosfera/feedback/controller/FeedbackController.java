package com.atmosfera.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atmosfera.feedback.service.FeedbackService;

@CrossOrigin
@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	

	@PostMapping("/feedback/{phoneNumber}")
	public void call(@PathVariable("phoneNumber") String phoneNumber, @RequestBody String clientName) {

		feedbackService.callback(phoneNumber, clientName);
	}
	
	
}
