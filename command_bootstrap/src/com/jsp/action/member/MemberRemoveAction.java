package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberRemoveAction implements Action {
	private MemberService memberService;
	public void setSearchMemberService(MemberService memberSearvice) {
		this.memberService = memberSearvice;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/delete_success";
		String id = request.getParameter("id");
		MemberVO member = memberService.getMember(id);
		try {
			
			memberService.remove(id);
			
			
		} catch (Exception e) {
			 url = "/member/delete_fail";
		}
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser != null && member.getId().equals(loginUser.getId())) {
			session.invalidate();
		}
		request.setAttribute("member", member);
		
		
		return url;
	}
}
