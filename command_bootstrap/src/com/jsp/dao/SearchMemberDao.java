package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.MemberVO;

public interface SearchMemberDao extends MemberDao {

	List<MemberVO> selectSearchMemberList(SqlSession session, SearchCriteria cri) throws Exception;
	
	int selectSearchMemberListCount(SqlSession session, SearchCriteria cri) throws Exception;
}
