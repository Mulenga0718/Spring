package com.jsp.action.pds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.NoticeModifyCommand;
import com.jsp.command.PdsModifyCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.NoticeVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

public class PdsModifyAction implements Action {
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url ="redirect:/pds/detail.do?pno="+request.getParameter("pno");

		PdsModifyCommand pdsReq = XSSHttpRequestParameterAdapter.execute(request, PdsModifyCommand.class, true);
		
		//smartEditor parameter 제외 
		PdsVO pds = pdsReq.toPdsVO();
		
		pds.setContent((String)request.getParameter("content"));
		pdsService.modify(pds);
		
		return url;
	}

}
