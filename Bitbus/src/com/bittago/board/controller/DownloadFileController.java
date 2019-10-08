package com.bittago.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/downloadfile.do")
public class DownloadFileController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		String orgName = req.getParameter("orgName");
		String apath = req.getParameter("path").replace("/Bitbus", "");
		String path = req.getSession().getServletContext().getRealPath("/") + apath;
		
		// 파일의 읽기 위한 파일 객체 생성
		File f = new File(path);
			
		// 전송하는 내용의 대한 설정
		if (orgName == null) {
			res.setHeader("Content-Type", "image/jpg");
		// 다운로드 할 경우
		} else {
			// 브라우저에게 문서의 타입을 모르니 다운로드 해라..
			res.setHeader("Content-Type", "application/octet-stream");	// application/octet-stream -> 타입을 알수없음, 다운로드
			// 다운로드할 이름을 지정
			// 한글일 경우의 이름 처리하자..
			orgName = new String(orgName.getBytes("utf-8"), "8859_1");
			res.setHeader("Content-Disposition", "attchment;filename=" + orgName);
		}
		
		// 파일의 내용을 읽어서 브라우저로 전송하기
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		OutputStream out = res.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		while(true) {
			int ch = bis.read();
			if (ch == -1) break;
			
			bos.write(ch);
		}
		
			bis.close(); fis.close();
			bos.close(); out.close();
		
	}

	
}
