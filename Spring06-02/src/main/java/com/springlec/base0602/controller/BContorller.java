package com.springlec.base0602.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;


@Controller
public class BContorller {
	
	BCommand command = null;
	private BCommand listCommand = null;
	private BCommand modifyCommand = null;
	private BCommand deleteCommand = null;
	private BCommand writeCommand = null;
	private BCommand viewCommand = null;
	
	
	@Autowired
	public void auto(BCommand list) {
		this.listCommand = list;
	}
	
	@Autowired
	public void autoModify(BCommand modify) {
		this.modifyCommand = modify;
	}
	
	@Autowired
	public void autoDelete(BCommand delete) {
		this.deleteCommand = delete;
	}
	
	@Autowired
	public void autoWrite(BCommand write) {
		this.writeCommand = write;
	}
	
	@Autowired
	public void autoView(BCommand content_view) {
		this.viewCommand = content_view;
	}
	

	
	@RequestMapping("/list")
	public String list(Model model) {
//		System.out.println("list()");
//		command = new BListCommand();
//		command.excute(model);
		listCommand.excute(model);
		return "list";
	
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("write controller");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		//System.out.println("write controller");
		model.addAttribute("request", request);
		//command = new BWriteCommand();
		//command.excute(model);
		writeCommand.excute(model);
		return "redirect:list";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		//command = new BContentViewCommand();
		//command.excute(model);
		viewCommand.excute(model);
		return "content_view";
	}

	@RequestMapping("/modify")
	public String content_modify(HttpServletRequest request, Model model) {
		//System.out.println("modify!!!");
		model.addAttribute("request", request);
		//command = new BContentModifyCommand();
		//command.excute(model);
		modifyCommand.excute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		//System.out.println("delete!!!");
		model.addAttribute("request", request);
		//command = new BContentDeleteCommand();
		//command.excute(model);
		deleteCommand.excute(model);
		return "redirect:list";
	}
}
