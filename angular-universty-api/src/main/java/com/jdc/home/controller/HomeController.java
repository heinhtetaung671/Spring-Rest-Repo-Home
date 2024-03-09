package com.jdc.home.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	ArrayList<String> home(){
		var arr =  new ArrayList<String>();
		arr.add("Hello Welcome");
		return arr;
	}
	
}
