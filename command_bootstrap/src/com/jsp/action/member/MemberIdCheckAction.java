package com.jsp.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberIdCheckAction implements Action {
	private MemberService memberService;
	public void setSearchMemberService(MemberService memberSearvice) {
		this.memberService = memberSearvice;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		String resultStr = "";
		
		String id = request.getParameter("id");
		
		try {
			MemberVO member = memberService.getMember(id);
			if(member != null) {
				resultStr = "DUPLICATED";
			}
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(resultStr);
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}
