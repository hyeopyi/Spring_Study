package com.springlec.base0601.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0601.command.BCommand;
import com.springlec.base0601.command.BContentDeleteCommand;
import com.springlec.base0601.command.BContentModifyCommand;
import com.springlec.base0601.command.BContentViewCommand;
import com.springlec.base0601.command.BListCommand;
import com.springlec.base0601.command.BWriteCommand;

@Controller
public class BContorller {
	
	BCommand command = null;

	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.excute(model);
		return "list";
	
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("write controller");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write controller");
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.excute(model);
		return "redirect:list";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BContentViewCommand();
		command.excute(model);
		return "content_view";
	}

	@RequestMapping("/modify")
	public String content_modify(HttpServletRequest request, Model model) {
		System.out.println("modify!!!");
		model.addAttribute("request", request);
		command = new BContentModifyCommand();
		command.excute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete!!!");
		model.addAttribute("request", request);
		command = new BContentDeleteCommand();
		command.excute(model);
		return "redirect:list";
	}
}
