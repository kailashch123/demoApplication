package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.inf.ValidateInterface;

@RestController
@RequestMapping("/validate")
public class ValidateUserController {
	
	@Autowired
	ValidateInterface validateInterface;

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody final User user) {
		return validateInterface.login(user);
		
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody final User user) {
		
		String response =  validateInterface.create(user);
		
		if(response != null) {
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/update")
	public ResponseEntity<String> update(@RequestBody final User user) {
		
		String response = validateInterface.update(user);

		if(response != null) {
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@RequestBody final User user) {
		String response =  validateInterface.delete(user);
		
		if(response != null) {
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

}
