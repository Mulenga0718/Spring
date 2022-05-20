package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.SearchMemberServiceImpl;

/**
 * Servlet implementation class MemberIDCheckServlet
 */
@WebServlet("/member/idCheck")
public class MemberIDCheckServlet extends HttpServlet {
	MemberService service = new SearchMemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		
		String resultStr = "";
		
		String id = request.getParameter("id");
		
		try {
			MemberVO member = service.getMember(id);
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
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
