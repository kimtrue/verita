<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	
		body {
		  font-family: "Montserrat", sans-serif;
		}
		
		.container {
			width: 900px;
			margin: 10% 5%;
			align-content: center;
		}
		
		a {
		  display: inline-block;
		  text-decoration: none;
		}
		
		input {
		  outline: none !important;
		}
		
		h1 {
		  text-align: center;
		  text-transform: uppercase;
		  margin-bottom: 40px;
		  font-weight: 700;
		}
		.form-peice a.logo {
			text-transform: uppercase;
		  	color: black;
			font-size: 30px;
			font-weight: 700;
			margin-top: 20px;
			margin-left: 50px;
			text-decoration: none;
			line-height: 1em;
		}
		
		.form-peice .heading p {
		  font-size: 15px;
		  font-weight: 300;
		  text-transform: uppercase;
		  letter-spacing: 2px;
		  white-space: 4px;
		  font-family: "Raleway", sans-serif;
		}
		.form {
		  position: relative;
		}
		.form form {
		  padding: 0 40px;
		  margin: 0;
		  width: 50%;
		  position: absolute;
		  top: 50%;
		  left: 75%;
		  transform: translate(-50%, -50%);
		}
		.form-peice .heading {
		  position: absolute;
		  top: 40%;
		  left: 25%; 
		  transform: translate(-50%, -50%);
		  text-align: center;
		}
		
		.form-peice .heading h2 {
		  font-size: 70px;
		  font-weight: 700;
		  text-transform: uppercase;
		  margin-bottom: 0;
		}
		
		.form .form-peice {
		  	background: #fff;
		 	height: 480px;
		  	margin-top: 30px;
		  	box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.2);
		  	color: #bbbbbb;
		  	padding: 30px 0 60px;
		  	transition: all 0.9s cubic-bezier(1, -0.375, 0.285, 0.995);
		  	position: absolute;
		  	top: 0;
		  	left: 50%;
		  	width: 130%;
		  	overflow: hidden;
		}
		
		
		.form form .form-group {
		
		  margin-bottom: 10px;
		  position: relative;
		}
		.switch {
		  margin-right: 20px;
		}
		
		.form form .CTA {
		  margin-top: 30px;
		}
		.form form .CTA input {
		  font-size: 12px;
		  text-transform: uppercase;
		  padding: 5px 30px;
		  background: #f95959;
		  color: #fff;
		  border-radius: 30px;
		  margin-right: 20px;
		  border: none;
		  font-family: "Montserrat", sans-serif;
		}
		
		.form form label {
		  font-size: 13px;
		  font-weight: 400;
		  text-transform: uppercase;
		  font-family: "Montserrat", sans-serif;
		  transform: translateY(40px);
		  transition: all 0.4s;
		  cursor: text;
		  z-index: -1;
		}
		
		.form form input:not([type=submit]) {
		  background: none;
		  outline: none;
		  border: none;
		  display: block;
		  padding: 10px 0;
		  width: 70%;
		  border-bottom: 1px solid #eee;
		  color: #444;
		  font-size: 13px;
		  font-family: "Montserrat", sans-serif;
		  z-index: 1;
		}
		
		.form form .CTA a.switch {
		  font-size: 13px;
		  font-weight: 400;
		  font-family: "Montserrat", sans-serif;
		  color: #bbbbbb;
		  text-decoration: underline;
		}
		.naver {
			margin-top: 30px;
		}

	</style>
</head>

<body>

	<div class="container">
		<div class="form">
			
			<div class="form-peice">
				<div>
					<a href="/" class="logo">BitTago</a>
				</div>
				<div class="heading">
					<h2>Sign In</h2>
					<p>Your Right Choice</p>
				</div>
				<form class="signin-form" action="signin.do" method="post">
					<div class="form-group">
						<label for="email">Email</label> 
						<input type="email" name="email" id="email">
					</div>
					<div class="form-group">
						<label for="password">Password</label> 
						<input type="password" name="password" id="password">
					</div>
					<div class="CTA">
						<input type="submit" value="Sign In"> 
						<a href="signupform" class="switch">I'm New</a>
						<a href="findform" class="switch">Forgot your email and password?</a>
					</div>
					<!-- 네이버아이디로로그인 버튼 노출 영역 -->
				  	 <%
					    String clientId = "5D90Fbse1Xo_YGUh2VTO";//애플리케이션 클라이언트 아이디값";
					    String redirectURI = URLEncoder.encode("http://localhost:8000", "UTF-8");
					    SecureRandom random = new SecureRandom();
					    String state = new BigInteger(130, random).toString();
					    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
					    apiURL += "&client_id=" + clientId;
					    apiURL += "&redirect_uri=" + redirectURI;
					    apiURL += "&state=" + state;
						session.setAttribute("state", state);
					%>
					<div class="form-group naver">
						<a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_w_in.PNG"/></a>
					</div>
					
				</form>
			</div>
			</div>
	</div>
</body>
</html>