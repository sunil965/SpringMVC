package com.bridgeit.restdemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgeit.restdemo.model.Message;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping("/")
	public String welcome(){
		return "Welcome to Restful Controller Example";
	}
	
	@RequestMapping("hello/{player}")
	public Message message(@PathVariable String player){
		Message message = new Message(player, "Hello"+player);
		return message;
	}
}
