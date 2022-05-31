package com.jsp.action.common;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.action.Action;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;

public class SubMenuAction implements Action{
	private MenuService menuService;
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		String mCode = request.getParameter("mCode");
		try {
			List<MenuVO> subMenu = menuService.getSubMenuList(mCode);
			
			//
			ObjectMapper mapper = new ObjectMapper();
		
			
			//
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(mapper.writeValueAsString(subMenu));
			
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
