package com.springlec.base0801.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0801.dao.IDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void excute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excuteRequest(HttpServletRequest request, SqlSession sqlSession) {
		// TODO Auto-generated method stub
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("mId"));
	}

}
