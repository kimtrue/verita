<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% Date date = new Date(); 
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	calendar.add(Calendar.DATE,30);
	Date maxj = calendar.getTime();%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<head>
<%@ include file="/jsp/include/cssReservationScript.jsp"%>
<title>BITTAGO</title>
</head>
<body>
	<!-- header -->
	<header>
		<div id="menu">
			<div class="logo">
				<a href="index.html"><img src="/img/logo(white).png"></a>
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

	<!-- 중단 메인 박스 -->
	<content>
	
	<div class="sss">
		<div id=box2>
		<div id=allbox>
		
			<div id=box1>
			<div id=selectbox>
				
					<div>편도</div>
				
					<div>왕복</div>
				
			</div>
			</div>
			
			<table class="choice">
			
			<c:set var = "now" value = "<%=new java.util.Date()%>" />
			<c:set var="max" value="<%=maxj%>" />
		<%-- 	<fmt:parseDate var="max" value="30" pattern="yyyy-MM-dd" />
			<c:out value="${max}" />
			<c:out value="${param.dNo}" /> --%>
			
			
				<tr>
				
					<td style="width: 600px; border-right: 1px solid black; padding-right: 12px; text-align: justify">



						<div id=box>
							<div id=departurebox>출발지</div>
							<div id=departuredatebox>> 가는 일시</div>

							<div class=wrapper>
								<div class="departureboxshape">${dName}</div>


								<div class="page-wrapper">
<!-- 									  <a class="btn trigger" href="javascript:;"><img src="img/bts_search.gif"></a> -->
									<a href="<c:url value="/reservation/reservationChoice.do"/>"><img src="img/bts_search.gif"></a>
								</div>
								<div class="modal-wrapper">
									<div class="modal2">
										<div class="head">
											<a class="btn-close trigger" href="javascript:;"></a>
										</div>
										<div class="content">

											<div id=terminalbox>
												<h1>터미널 검색</h1>
												<hr />
												<h2>출발지 주요 터미널</h2>
												<nav id="primary_nav_wrap">
													<ul class="terminal">
														<li id=101>강릉</li>
														<li id=102>부산</li>
														<li id=103>군산</li>
														<li id=104>서울남부</li>
														<li id=105>서울동부</li>
														<li id=106>인천</li>
														<li id=107>대구</li>
														<li id=108>대전</li>
														<li id=109>고양</li>
														<li id=110>순천</li>
														<li id=111>보령</li>
														<li id=112>광명</li>
														<li id=113>영광</li>
														<li id=114>해남</li>
														<li id=115>의정부</li>
														<li id=116>시흥</li>
														<li id=117>연천</li>
														<li id=118>철원</li>
														<li id=119>화천</li>
														<li id=120>태백</li>
													</ul>
												</nav>
											</div>
											<table>
												<tr style="vertical-align: top">
													<td
														style="width: 400px; padding-right: 12px; text-align: justify">
														<h3>> 출발지</h3> <input type="text" style="height: 30px;" />
														<div
															style="overflow: auto; width: 330px; height: 150px; padding: 10px; border: 1px solid black;">
															<!-- 출발지 전부출력 출발지 선택시 도착지 출력 -->
															<c:forEach var="dept" items="${list}">
																<a href="reservation.do?no=${dept.terminalNo}">${dept.terminalName}</a>
																<br>
															</c:forEach>
														</div>
													</td>
													<td
														style="width: 400px; padding-right: 12px; text-align: justify">
														<h3>> 도착지</h3> <input type="text" style="height: 30px;" />
														<div
															style="overflow: auto; width: 330px; height: 150px; padding: 10px; border: 1px solid black;">
															<c:forEach var="terminal" items="${arrivalList}">
                            									${terminal.terminalName}
                            									<br>
															</c:forEach>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
							<div id=departuredate>
								<input type="date"
								min="<fmt:formatDate pattern ="yyyy-MM-dd" value = "${now}" />"
								max="<fmt:formatDate pattern ="yyyy-MM-dd" value = "${max}" />"
								name="userdate1">
							</div>
							<select id=busgrade1>
								<option>버스등급</option>
								<option>일반</option>
								<option>우등</option>
							</select>
							<div id=arrivalbox1>도착지</div>
							<div id=arrivalbox2>> 오는 일시</div>
							<!-- 터미널 검색이 안됨-->
							<div class=wrapper2>
								<div class="arrivalboxshape">${aName}</div>
								<div class="page-wrapper">
									<a class="btn trigger" href="javascript:;"><img
										src="img/bts_search.gif"></a>
								</div>
								<div class="modal-wrapper">
									<div class="modal2">
										<div class="head">
											<a class="btn-close trigger" href="javascript:;"></a>
										</div>
										<div class="content">

											<div id=terminalbox>
												<h1>터미널 검색</h1>
												<hr />
												<h2>출발지 주요 터미널</h2>
												<nav id="primary_nav_wrap">
													<ul class="terminal">
														<li id=101>강릉</li>
														<li id=102>부산</li>
														<li id=103>군산</li>
														<li id=104>서울남부</li>
														<li id=105>서울동부</li>
														<li id=106>인천</li>
														<li id=107>대구</li>
														<li id=108>대전</li>
														<li id=109>고양</li>
														<li id=110>순천</li>
														<li id=111>보령</li>
														<li id=112>광명</li>
														<li id=113>영광</li>
														<li id=114>해남</li>
														<li id=115>의정부</li>
														<li id=116>시흥</li>
														<li id=117>연천</li>
														<li id=118>철원</li>
														<li id=119>화천</li>
														<li id=120>태백</li>
													</ul>
												</nav>
											</div>
											<table>
												<tr style="vertical-align: top">
													<td
														style="width: 400px; padding-right: 12px; text-align: justify">
														<h3>> 출발지</h3> <input type="text" style="height: 30px;" />
														<div
															style="overflow: auto; width: 330px; height: 150px; padding: 10px; border: 1px solid black;">
															<!-- 출발지 전부출력 출발지 선택시 도착지 출력 -->
															<c:forEach var="dept" items="${list}">
																<a href="reservation.do?no=${dept.terminalNo}">${dept.terminalName}</a>
																<br>
															</c:forEach>
														</div>
													</td>
													<td
														style="width: 400px; padding-right: 12px; text-align: justify">
														<h3>> 도착지</h3> <input type="text" style="height: 30px;" />
														<div
															style="overflow: auto; width: 330px; height: 150px; padding: 10px; border: 1px solid black;">
															<c:forEach var="terminal" items="${arrivalList}">
                            									${terminal.terminalName}
                            									<br>
															</c:forEach>
														</div>
													</td>
												</tr>
											</table>
										</div>

									</div>
								</div>


							</div>
							<div id=arrivaldate>
								<input type="date" min="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${now}" />" name="userdate2">
							</div>
							
							<select id=busgrade2>
								<option>버스등급</option>
								<option>일반</option>
								<option>우등</option>
							</select>

						</div>
						<!--#box 끝--> 
						
					</td>
					<td style="padding-left: 10px">
						<table id=agetype>
							<tr>
								<td style="border-right: 1px solid black; padding-right: 12px;">
									성인</td>
								<td style="padding-left: 10px">유아</td>
							</tr>
						</table>
						<div id=agetypechoice>
							<select id=agetype1>
								<option>0</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select> 
							<select id=agetype2>
								<option>0</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
						<div id=viewbutton>
							<button type="button" id="changview">조회하기</button>
						</div>
					</td>
			</table>

</div>
        <div class="busList" > 
            <div class="gofrom">
                <div class="singleTrans">                      
                    <div>
                      <a id="start">고양종합</a>
                    </div>
                    <div>
                      <a id="arrow">→</a>
                    </div>
                    <div>
                      <a id="arrival">강촌</a>
                    </div>
                     
                </div>
           </div> 
        <div class="allpaper">   
        <div class="startday">
            <a> yyyy-MM-dd </a>
         </div>
         <table>
             <thead>
                 <tr>
                     <th>출발시간</th>
                     <th>출발지</th>
                     <th>도착지</th>
                     <th>버스회사</th>
                     <th>버스등급</th>
                     <th>총 좌석</th>
                     <th>예매가능</th>
                     <th>정보</th>
                     <th>좌석선택</th>
                     </tr>
            </thead>

 
         <tbody id="rsvlist">
                  <tr>
                     <td>7 : 00</td>
                     <td>고양종합</td>
                     <td>강촌</td>
                     <td>강원고속</td>
                     <td class="grade">우등</td>
                     <td>19</td>
                     <td><strong></strong></td>
                     <td><a href="#" class="demodal" id="de1"><img src="<c:url value="/img/상세보기.png" />"></a></td>
                     <td><a href="#" class="openseat"><img src="<c:url value="/img/좌석선택.png" />"></a></td>
                 </tr>
                 
             </tbody>    
        </table>
       </div>
        </div> 

        <!-- 상세보기 팝업 -->
        <div id="myModal" class="modal" style="display:none;"></div>
       

        
    </div>
			<div id=textbox1>
				인터넷 예매시 유의사항
			</div>
			<div id=textbox2>취소 수수료 및 안내</div>
		</div>

	</content>


   <script>
   let cEle = document.querySelector("#changview");
   cEle.addEventListener("click", () => {
	    let divEle = document.querySelector(".busList");	   
	    divEle.style.display = "block";
	     
   });   
</script>

<script src="<c:url value='/js/rsvcheckbox.js' />"></script>
<script src="<c:url value='/js/rsvmodalpop.js' />"></script>
 							
<script src="https://code.jquery.com/jquery-1.11.0.min.js">
</script> 
						
<script type="text/javascript" src="<c:url value="/js/popUp.js" />" ></script> 
						 
							




	<!-- footer -->
	<footer>
		<div class="customer">
			<div class="footer_logo">
				<a href="index.html"> <img src="img/logo(black).png" alt="임의로고">
				</a>
			</div>

			<ul>
				<li><a href="#">회사소개</a></li>
				<li><a href="#">투자정보</a></li>
				<li><a href="#">채용안내</a></li>
				<li><a href="#">여객운송약관</a></li>
				<li><a href="#">홈페이지이용약관</a></li>
			</ul>
			<!-- <p>copyright 2019 BitAIR All right reserved.</p> -->
		</div>
	</footer>
</body>
</html>