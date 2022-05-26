package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.MakeFileName;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberModifyFormAction implements Action{
	private MemberService memberService;
	public void setSearchMemberService(MemberService memberSearvice) {
		this.memberService = memberSearvice;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/modify";
		String id = request.getParameter("id");
		
		memberService.getMember(id);
		
		try {
			MemberVO member = memberService.getMember(id);
			String fileName = MakeFileName.parseFileNameFromUUID(member.getPicture(), "\\$\\$");
			member.setPicture(fileName);
			System.out.println(fileName);
			request.setAttribute("member",member);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return url;
	}

}
