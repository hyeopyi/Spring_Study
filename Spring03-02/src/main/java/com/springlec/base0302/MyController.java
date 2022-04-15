package com.springlec.base0302;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/content")
	public String cotnet(Model model) {
		model.addAttribute("id", 1);
		return "content";
	}
	


}
