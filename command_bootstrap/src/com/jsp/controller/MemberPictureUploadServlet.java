package com.jsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.jsp.exception.NotMultipartFormDataException;

/**
 * Servlet implementation class MemberPictureUploadServlet
 */
@WebServlet("/member/picture")
public class MemberPictureUploadServlet extends HttpServlet {
    
	private static final int MEMORY_THRESHOLD = 1024 *500;
	private static final int MAX_FILE_SIZE = 1024 *1024;
	private static final int MAX_REQUEST_SIZE = 1024 *1024 *2 ;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			// 1. request 변환 
			MultipartHttpServletRequestPaser multi =
					new MultipartHttpServletRequestPaser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
			
			// 2. 저장할 경로 
			String uploadPath 
			= GetUploadPath.getUploadPath("member.picture.upload");
			
			// 3. 업로드된 이미지 저장
			FileItem[] items = multi.getFileItems("pictureFile");
			FileUploadesolver.fileUpload(items, uploadPath);
			// 4. 이전 이미지 삭제
			
			// 5. 저장한 파일명 보내기 
			
			
		}catch (NotMultipartFormDataException e) {

			response.sendError(response.SC_BAD_REQUEST); // 400
		}catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR); // 500
		}

		}
	}
