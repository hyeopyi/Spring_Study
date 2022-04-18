package com.springlec.base0801.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BCommand {
	
	void excute(SqlSession sqlSession, Model model);
	void excuteRequest(HttpServletRequest request, SqlSession sqlSession);

}
