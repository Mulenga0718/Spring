package com.jsp.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.dao.SearchMemberDao;
import com.jsp.dao.SearchMemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;

public class SearchMemberServiceImpl extends MemberServiceImpl {
	
	private SqlSessionFactory sqlSessionFactory;
	private SearchMemberDao memberDAO;
	 
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setMemberDAO(SearchMemberDao memberDAO) {
		super.setMemberDAO(memberDAO);
		this.memberDAO = memberDAO;
	}

	@Override 
	public Map<String,Object> getMemberListForPage(Criteria cri) throws Exception{
	    
		return null;
	}
}
