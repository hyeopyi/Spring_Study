package com.springlec.base0801.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0801.dao.IDao;

public class BListCommand implements BCommand {

	@Override
	public void excute(SqlSession sqlSession, Model model) {
		 
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
	}
	
	@Override
	public void excuteRequest(HttpServletRequest request, SqlSession sqlSession) {
		// TODO Auto-generated method stub

	}

}
