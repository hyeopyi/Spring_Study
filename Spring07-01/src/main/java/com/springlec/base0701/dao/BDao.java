package com.springlec.base0701.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BDao {

	JdbcTemplate template;
	
//	@Autowired
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	
//	}
//	
//	public BDao() {
//		setTemplate(template);
//	}
	
	public BDao() {
		
		this.template = Constant.template;
	}
	
	
	
	public ArrayList<BDto> list() {
	
		String qeury = "select bid, bName, bTitle, bContent, bDate from mvc_board";
		return (ArrayList<BDto>) template.query(qeury, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
		


	
	
	public void write(final String bName, final String bTitle, final String bContent) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?, ?, ?, now())";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				return pstmt;
			}
		});
		
	}
	
	public BDto contentView(String sbId) {
		String query = "select * from mvc_board where bId = " + sbId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}

	
	
	public void modify(final int bId, final String bName, final String bTitle, final String bContent) {
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, bId);
				
			}
		});
		
	}

	
	public void delete(final String bId) {

		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "delete from mvc_board where bId =" + bId;
				PreparedStatement pstmt = con.prepareStatement(query);				
				return pstmt;
			}
		});
		
	}
//		System.out.println("delete call");
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//
//	
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "delete from mvc_board where bId =" + bId;
//			System.out.println("query " + query);
//			preparedStatement = connection.prepareStatement(query);	
//			preparedStatement.executeUpdate();
//			
//
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {  // 이상이 있거나 없거나 모두 온다 
//			try {
//			
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//	} // delete
	
	
	
	
	
} // end
