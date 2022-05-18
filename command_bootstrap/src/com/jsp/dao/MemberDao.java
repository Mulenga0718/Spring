package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.MemberVO;

public interface MemberDao {

	
		List<MemberVO> selectMemberList(SqlSession session) throws Exception;
		List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws Exception;
		
		int selectMemberListCount(SqlSession session) throws Exception;
		
		
		public MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
		public void insertMember(SqlSession session, MemberVO member) throws SQLException;
		public void updateMember(SqlSession session, MemberVO member) throws SQLException;
		public void deleteMember(SqlSession session, String id) throws SQLException;
		public void enabledMember(SqlSession session, String id, int enabled) throws SQLException;
}
