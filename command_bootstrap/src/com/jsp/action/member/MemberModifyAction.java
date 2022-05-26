package com.jsp.action.member;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadesolver;
import com.jsp.controller.GetUploadPath;
import com.jsp.controller.MultipartHttpServletRequestPaser;
import com.jsp.dto.MemberVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.MemberService;

public class MemberModifyAction implements Action{
	private static final int MEMORY_THRESHOLD = 1024 *500;
	private static final int MAX_FILE_SIZE = 1024 *1024;
	private static final int MAX_REQUEST_SIZE = 1024 *1024 *2 ;
	private MemberService memberService;
	public void setSearchMemberService(MemberService memberSearvice) {
		this.memberService = memberSearvice;
	}
	
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/modify_success";
	
		try {
			// 1. request 변환 
			MultipartHttpServletRequestPaser multi =
					new MultipartHttpServletRequestPaser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
			
			// 2. 저장할 경로 
			String uploadPath 
			= GetUploadPath.getUploadPath("member.picture.upload");
			
			// 3. 업로드된 이미지 저장
			String pictureName;
			String check = multi.getParameter("uploadPicture");
			String id = multi.getParameter("id");

			if(check.equals("1")) {
				
			FileItem[] items = multi.getFileItems("picture");
			List<File> uploadFiles = FileUploadesolver.fileUpload(items, uploadPath);
			
			pictureName = uploadFiles.get(0).getName();
			
			// 4. 이전 이미지 삭제
			
			String oldPicture = memberService.getMember(id).getPicture();
			
			File oldFile = new File(uploadPath+File.separator+ oldPicture);
			if(oldFile.exists()) {
				oldFile.delete();
			}	
			}else {
				pictureName = memberService.getMember(id).getPicture();
				
				
			}
			MemberVO member = new MemberVO();
			String pwd = multi.getParameter("pwd");
			String name = multi.getParameter("name");
			String authority = multi.getParameter("authority");
			String email = multi.getParameter("email");
			String phone = multi.getParameter("phone");
			String picture = pictureName;
			member.setAuthority(authority);
			member.setEmail(email);
			member.setId(id);
			member.setName(name);
			member.setPwd(pwd);
			member.setPhone(phone);
			member.setPicture(picture);
			
			memberService.modify(member);
			request.setAttribute("id", id);
			
		}catch (NotMultipartFormDataException e) {

			response.sendError(response.SC_BAD_REQUEST); // 400
			 url = "/member/modify_fail";
		}catch (Exception e) {
			e.printStackTrace();
			url = "/member/modify_fail";
			response.sendError(response.SC_INTERNAL_SERVER_ERROR); // 500
		}
		return url;
		
	}

}
