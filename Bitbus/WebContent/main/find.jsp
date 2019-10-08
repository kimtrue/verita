<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
		  margin-top: 20px;
		  margin-bottom: 20px;
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
		
	</style>
</head>
<body>

	<div class="container">
		<div class="form">
			
	<div class="find form-peice switch">
	<div>
					<a href="/" class="logo">BitTago</a>
				</div>
				<div class="heading">
					<h2>Fild Email</h2>
					<p>Your Right Choice</p>
				</div>
					<form class="find-form" action="/findEmail.do" method="post">
						<div class="form-group">
							<label for="findEmailName">Name</label> 
							<input type="text" name="findEmailName" id="findEmailName"><span class="error"></span>
						</div>
						<div class="form-group">
							<label for="findEmailphone">Phone</label> 
							<input type="text" name="findEmailphone" id="findEmailphone"><span class="error"></span>
						</div>
						<div class="CTA">
							<input type="submit" value="find email">
							<a href="/signupform" class="switch">I'm New</a>
							<a href="/signinform" class="switch">I have an account</a>
						</div>
					</form>
					</div>
					</div>
					</div>
</body>
</html>