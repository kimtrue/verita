<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
		<div id="menu">
			<div class="logo">
				<a href="index.html"><img src="<c:url value="/img/logo(white).png" />"></a>
			</div>
			<div id="nav">
				<ul class="login">
					<li><a href="#"><em>회원가입</em></a></li>
					<li><a href="#"><em>로그인</em></a></li>
				</ul>
				<ul class="gnb">
					<li><a href="/Reservation.html"><em>예매</em></a></li>
					<li><a href="#"><em>예약조회</em></a></li>
					<li><a href="/servicecenter.html"><em>공지사항</em></a></li>
					<li><a href="#"><em>고객센터</em></a></li>
				</ul>
			</div>
		</div>
	</header>
	
<!-- <header> -->
<!--         <div id="menu"> -->
<!--             <div class="logo"> -->
<%--                 <a href="<c:url value="/main.do" />"><img src="<c:url value='/' />/img/logo(black).png"></a> --%>
<!--             </div> -->
<!--             <div id="nav"> -->
<!--                 <ul class="login"> -->
<!--                     <li><a href="#"><em>회원가입</em></a></li> -->
<!--                     <li><a href="#"><em>로그인</em></a></li> -->
<!--                 </ul> -->
<!--                 <ul class="gnb"> -->
<!--                     <li><a href="/Reservation.html"><em>예매</em></a></li> -->
<!--                     <li><a href="#"><em>예약조회</em></a></li> -->
<!--                     <li><a href="serviceboard.do"><em>공지사항</em></a></li> -->
<!--                     <li><a href="questionboard.do"><em>고객센터</em></a></li> -->
<!--                 </ul> -->
<!--             </div> -->
<!--         </div> -->
<!--     </header> -->
	
</body>
</html>