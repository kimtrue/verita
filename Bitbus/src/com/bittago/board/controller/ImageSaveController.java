package com.bittago.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/admin/image.do")
public class ImageSaveController extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		String path = "/img/upload/board" + sdf.format(new Date());
		String fname="";
		String local = req.getSession().getServletContext().getRealPath("/");
				
	File file = new File(local + path);
	if (file.exists() == false)file.mkdirs();
	
	
	// 메모리와 임시저장에 대한 옵션을 설정
	DiskFileItemFactory disk = new DiskFileItemFactory();
	disk.setRepository(new File(local + "/img/temp"));
	disk.setSizeThreshold(1024 * 1024);
		
	// 사용자가 보내준 request의 정보를 파싱 처리하는 클래스(cos.jar에서 MultipartRequest의 역할) 
	ServletFileUpload upload = new ServletFileUpload(disk);
	
	
	try {
		List<FileItem> lists = upload.parseRequest(req);
	
		for (FileItem item : lists) {
			// input 태그의 name 속성의 값을 반환
			System.out.println(item.getFieldName());
			// type이 file 인지 아니면 일반 폼 타입인지 확인
			if (item.isFormField()) { // 타입이 파일 아닌 경우 true
				// input 속성에 입력한 값을 반환
				System.out.println(item.getString());
				
			} else { // 타입이 파일인 경우
				// 원본파일명, 파일의 크기
				String name = item.getName();
				long size = item.getSize();
				String contentType = item.getContentType();
				System.out.println("파일명 : " + name);
				System.out.println("파일크기 : " + size);
				System.out.println("파일타입 : " + contentType);
				
				// 실제 저정하는 파일의 이름(직접 - UUID 활용)
				String ext = "";
				int index = name.lastIndexOf(".");
				if (index != -1) ext = name.substring(index);
				File f = new File(file, UUID.randomUUID().toString() + ext);
				item.write(f);
				fname = f.getName();
				
				
				if (contentType.startsWith("image/")) {
				// 썸네일 이미지 생성하기
				Thumbnails.of(f)
					.size(300, 200)
					.outputFormat("jpg")
					.toFile(new File(f.getParent(), "thumb_" + f.getName()));
				}
				
			}
			
		}

	
		String uploadPath = req.getContextPath() + path+"/" + fname;
		System.out.println(uploadPath);
		res.setContentType("image/pjpeg");
		PrintWriter pw = res.getWriter();
		pw.write(uploadPath);
		pw.flush();
		pw.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	

	
	}
	
	
}
