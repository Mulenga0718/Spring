package com.jsp.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.dao.SearchMemberDao;
import com.jsp.dao.SearchMemberDaoImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;

public class SearchMemberServiceImpl extends MemberServiceImpl {
	
	private SqlSessionFactory sqlSessionFactory;
	private SearchMemberDao memberDao;
	 
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setMemberDao(SearchMemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override 
	public Map<String,Object> getMemberListForPage(Criteria cri) throws Exception{
	    
		return null;
	}
}
