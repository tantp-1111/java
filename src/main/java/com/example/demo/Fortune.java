package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Fortune {
   
	@RequestMapping("/fortune")
	public String start() {
		double fn = Math.random(); //0.0~1.0の乱数
		if (fn >=0.7 ) {
			return "greatfortune.html";
		} else if (fn >=0.4 ) {
			return "middlefortune.html";
		} else if (fn >=0.1 ) {
			return "smallfortune.html";
		} else {
			return "misfortune.html";
		}
	}
	
	@Controller
	public class FortuneController {
	    @GetMapping("/")
	    public String index() {
	        return "index"; // .htmlは不要
	    }
	}
}
