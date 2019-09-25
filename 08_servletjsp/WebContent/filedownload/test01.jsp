<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 다운로드</h2>
	<div>
	   <a href="download.do?name=jj01.jpg&path=/board/2019/09/19/10">jj01.jpg(원본파일명) 보기</a>
	</div>
	<div>
	   <a href="download.do?name=jj01.jpg&path=/board/2019/09/19/10&dname=jj01.jpg">jj01.jpg(원본파일명) 다운로드</a>
	</div>
	<div>
	   <a href="download.do?name=jj01.jpg&path=/board/2019/09/19/10&dname=짱절미.jpg">짱절미.jpg(원본파일명) 다운로드</a>
	</div>
	<div>
	  <!-- <img src="c:/java/upload/logo2.jpg"/> 클라이언트가 구동했을 때 실행되는데 클라이언트의 씨>자바>업로드가 없기 때문에 구동X (작업자)서버상에 있는 경로를 주면 접근이 불가능하다-->
	   <img src="download.do?name=jj01.jpg&path=/board/2019/09/19/10" />
 
</body>
</html>