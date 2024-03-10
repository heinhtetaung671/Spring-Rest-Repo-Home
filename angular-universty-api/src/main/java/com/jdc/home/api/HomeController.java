package com.jdc.home.api;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	ArrayList<String> home(){
		var arr =  new ArrayList<String>();
		arr.add("Hello Welcome");
		return arr;
	}
	
}
