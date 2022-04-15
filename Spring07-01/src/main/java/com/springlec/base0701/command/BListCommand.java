package com.springlec.base0701.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0701.dao.BDao;
import com.springlec.base0701.dto.BDto;

public class BListCommand implements BCommand {
	
	private BDao dao = null;
	@Autowired
	public void setDao(BDao dao) {
		this.dao = dao;
	}

	@Override
	public void excute(Model model) {
	
		//BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
		
		
	}

}
