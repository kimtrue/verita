<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String[] seatNo = request.getParameterValues("seatNo");

%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<%@ include file="/jsp/include/cssReservationEndReservation.jsp"%>

<title>BITAIR</title>
</head>

<body>
<!-- header -->
	<header>
		<div class="bluecolor">
			<ul class="login">
				<li><a href="#">로그아웃</a></li>
				<li><a href="#">로그인</a></li>
			</ul>
		</div>
		<div class="gnb">
			<!-- 로고영역 -->
			<!-- 임의로 넣어논 로고 -->
			<div id="logo">
				<a href="reserv.html"> <img src="<c:url value='/' />/img/logo(white).png" alt="임의로고">
				</a>
			</div>

			<!-- 메뉴 영역 -->
			<ul class="nav">
				<li><a href="#">예약관리</a></li>
				<li><a href="#">서비스</a></li>
				<li><a href="#">이벤트/정보</a></li>
				<li><a href="#">마이페이지</a></li>
				<li><a href="#">고객센터</a></li>
			</ul>
		</div>
		</div>
	</header>


	
	<!-- 중단 메인 박스 -->
	<content> <!-- content에 소스작성 -->
	<div class="reservck">
		<div class="container br1" id="busReservationContent">
			<div class="location">
				<div id="reservationContent">
					<h2 class="title">
						<img src="<c:url value='/' />/img/title.gif"
							alt="승차권예매 예매가능한 좌석정보와 운행정보, 간편한 결제방식으로 인터넷 승차권 예매를 하실 수 있습니다.">
					</h2>
					<p class="step">
						<img src="<c:url value='/' />img/step02.gif"
							alt="승차권 예매 1단계:예매정보 2단계:확인/결제 3단계:예매완료 단계 중 2단계:확인/결제 입니다.">
					</p>



					<h4 class="stit">
						<img src="<c:url value='/' />/img/h4_reserve.gif" alt="예매정보 입니다.">
					</h4>
				<form method="post" action="<c:url value="/reservation/reservationEnd.do" />">
					<div class="reserbox">
						<div id="singleTicket" style="width: 100%;">
							<p class="area">
								<img src="<c:url value='/' />/img/ico_goDate.gif" alt="가는날"> <img
									src="<c:url value='/' />/img/ico_from.png" alt="출발지"> 출발지 <img
									src="<c:url value='/' />/img/ico_to.png" alt="도착지"> 도착지
							</p>
							<table class="type1"
								summary="가시는날 승차권의 출발일자, 출발시간, 등급, 좌석, 인원, 금액 정보입니다.">

								<colgroup>
									<col style="width: 14%;">
									<col style="width: 25%;">
									<col style="width: 23%;">
									<!-- <col style="width:"> -->
								</colgroup>
								<tbody>
									<tr>
										<th scope="row" class="left">출발일</th>
										<td id="sdate">
										<input type="hidden" name="departure" value="${departure}">
										${departure}
										</td>
										<th scope="row" class="left">등급</th>
										<td><span id="busGrade">
										<input type="hidden" name="busGrade" value="${busGrade}">
										${busGrade}</span></td>
									</tr>
									<tr>
										<th scope="row" class="left">출발시간</th>
										<td id="stime">
										<input type="hidden" name="departureTime" value="${departureTime}">
										${departureTime}</td>
										<th scope="row" class="left">좌석번호</th>
										<td id="singleSeat">
										<input type="hidden" name="seatNo" value="${seatNo}">
										<c:forEach var="seatNo" items="${seatNo}" >
										${seatNo}번
										</c:forEach>
										</td>
									</tr>
									<tr>
										<th scope="row" class="left">금액</th>
										<td id="stotFee">
										<input type="hidden" name="payment" value="${adultPrice + kidPrice}">
										<strong>${adultPrice + kidPrice}</strong> 원</td>
										<th scope="row" class="left">인원</th>
										<td><input type="hidden" name="adulsCnt" value="${adulsCnt}">
										어른 : ${adulsCnt}명, 
										<input type="hidden" name="kidsCnt" value="${kidsCnt}">
										어린이 : ${kidsCnt}명</td>
									</tr>
									<tr>
										<th scope="row" class="left">예상 소요시간</th>
										<td colspan="3"><td>
										<input type="hidden" name="operatingTime">
										${operatingTime}</td>
									</tr>
									<tr>
										<th scope="row" class="left">노선</th>
										<td colspan="3">${departure} -> ${arrival}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div id="doubleTicket" style="display: none;">
							<p class="area">
								<img src="#" alt="오는날"> <img src="#" alt="출발지">
								<input type="hidden" name="departure" value="${departure}">
										${departure} <img
									src="#" alt="도착지">
									<input type="hidden" name="arrival" value="${arrival}">
										${arrival}
							</p>
							<table class="type1"
								summary="오시는날 승차권의 출발일자, 출발시간, 등급, 좌석, 인원, 금액 정보입니다.">
								<caption>예매정보</caption>
								<colgroup>
									<col style="width: 14%;">
									<col style="width: 25%;">
									<col style="width: 23%;">
									<!-- <col style="width:;"> -->
								</colgroup>
								<tbody>
									<tr>
										<th scope="row" class="left">출발일</th>
										<td id="edate"></td>
										<th scope="row" class="left">등급</th>
										<td>/ <span id="doublebusGrade"></span></td>
									</tr>
									<tr>
										<th scope="row" class="left">출발시간</th>
										<td id="etime"></td>
										<th scope="row" class="left">좌석번호</th>
										<td id="doubleSeat"></td>
									</tr>
									<tr>
										<th scope="row" class="left">금액</th>
										<td id="stotFee"><strong>7,300</strong> 원</td>
										<th scope="row" class="left">인원</th>
										<td>1 명</td>
									</tr>
									<tr>
										<th scope="row" class="left">거리</th>
										<td></td>
										<th scope="row" class="left">예상 소요시간</th>
										<td>분</td>
									</tr>
									<tr>
										<th scope="row" class="left">상세노선</th>
										<td colspan="3"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

					<h4 class="stit">
						<img src="<c:url value='/' />/img/h4_payment.gif">
					</h4>
					<div class="paybox">
						<div class="sbox">
							<table summary="승차권 결제의 인원, 매수, 총 결제금액 정보입니다.">
								<tbody>
									<tr>
										<th scope="row"><img src="<c:url value='/' />/img/th_no.gif" alt="인원"></th>
										<td> <strong>${adulsCnt + kidsCnt}</strong> 명<br>



										</td>
									</tr>
									<tr>
										<th scope="row"><img src="<c:url value='/' />/img/th_no2.gif" alt="매수"></th>
										<td>총 <strong>${seatCnt}</strong> 매
										</td>
									</tr>
								</tbody>
								<tfoot>
									<div class="bussum">
										<tr>
											<th scope="row">총 결제금액</th>
											<td id="totFees">${adultPrice + kidPrice} 원</td>
										</tr>
									</div>
								</tfoot>
							</table>
						</div>
						<button>등록</button>
</form>
						<!-- 2015-11-24 -->
						<div class="stxt">
							<form id="frmCardApp" name="frmCardApp" method="post">
								<input type="hidden" id="tokenId" name="tokenId" value="">
								<input type="hidden" class="language" name="language" value="kr">
								<!-- Cashbee parameter 설정 시작 -->
								<input type="hidden" name="step" value="CBSTEP_READY"> <input
									type="hidden" name="startTime" value="0620"> <input
									type="hidden" name="startTime2" value="">
								<!-- Cashbee parameter 설정 종료 -->
								<!-- 예약 변경시 취소 관련 설정 시작 -->
								<input type="hidden" class="chCardNo" name="chCardNo" value="">
								<input type="hidden" id="auOriNo" name="auOriNo" value="">
								<input type="hidden" id="auOriDate" name="auOriDate" value="">
								<input type="hidden" id="chAppAmt" name="chAppAmt" value="">
								<input type="hidden" id="nexAppAmt" name="nexAppAmt">
								<input type="hidden" id="canGubun" name="canGubun" value="1">
								<input type="hidden" id="orgReserveNo" name="orgReserveNo" value="">
								<input type="hidden" id="chgTokenId" name="chgTokenId" value="">
								<input type="hidden" id="chOrgReserveNo" name="chOrgReserveNo" value="">
								<input type="hidden" id="chReserveNo" name="chReserveNo" value="">
								<input type="hidden" id="cStartDate1" name="cStartDate1" value="">
								<input type="hidden" id="cancelType" name="cancelType">
								<input type="hidden" id="chSterCode" name="chSterCode" value="">
								<input type="hidden" id="cFee1" name="cFee1">
								<input type="hidden" class="chCardNo" name="chCardNo" value="">
								<!-- 예약 변경시 취소 관련 설정 종료 -->
								<!-- 예약 관련 설정 시작 -->
								<input type="hidden" id="appAmt" name="appAmt" value="7300">
								<input type="hidden" class="reserveNo" name="reserveNo" value="19090836732449302">
								<input type="hidden" class="reserveNo2" name="reserveNo2" value="">
								<input type="hidden" class="sterCode" name="sterCode" value="9302">
								<input type="hidden" id="sterCode2" name="sterCode2" value="">
								<input type="hidden" class="seatNos" name="seatNos" value="16">
								<input type="hidden" id="seatNos2" name="seatNos2" value="">
								<input type="hidden" name="MSTR" class="MSTR" value="16!1!0!0!0!7300!0!5100!3700!0620!20190908!939302301702!20190909!0620!9302!1022!133809!910719!AAIafYY8TmkxFmFn6VsJGveD!1!7300!1100001!@!!19090836732449302">
								<!-- 가맹점 return 값, DBPATH로 전달-->
								<input type="hidden" name="MSTR2" class="MSTR2"	value="!@!!19090836732449302">
								<!-- 가맹점 return 값, REDIRPATH로 전달-->
								<input type="hidden" name="RETSTR1" class="RETSTR1" value="">
								<!-- 가맹점 return 값, DBPATH로 전달 왕복발권시 사용-->
								<input type="hidden" name="RETSTR2" class="RETSTR2" value="">
								<!-- 가맹점 return 값, REDIRPATH로 전달 왕복발권시 사용-->
								<input type="hidden" class="oriReserveNo" name="oriReserveNo" value="">
								<input type="hidden" class="slvl" name="slvl" value="1">
								<!-- 출발차량 등급 -->
								<input type="hidden" class="elvl" name="elvl" value="">
								<!-- 왕복시 출발차량등급 -->
								<!-- 예약 관련 설정 종료 -->
								<input type="hidden" class="routeCode" name="routeCode" value="939302301702"> 
								<input type="hidden" class="totCnt" name="totCnt" value="1">

								<!-- 페이코관련 -->

								<input type="hidden" id="startRouteData" class="startRouteData"	name="startRouteData" value="인천→가남(09/09 06:20)">
								<input type="hidden" id="order_url" class="order_url" name="order_url" value="">
								<input type="hidden" id="order_sellerOrderReferenceKey" class="order_sellerOrderReferenceKey" name="order_sellerOrderReferenceKey" value="">
								<input type="hidden" id="order_transpBizrId" class="order_transpBizrId" name="order_transpBizrId" value="1100001">


								<ul class="card_chk">
									<li>카드구분</li>

									<li><input type="radio" id="cardTypes1" name="cardType"	value="0" checked="" style="display: block; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px;">
									</li>
									<li><label for="cardTypes1" class="">신용카드 및
											체크카드(개인)</label> &nbsp;&nbsp;</li>
									<li><input type="radio" id="cardTypes2" name="cardType" value="1" style="display: block; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px;">
									</li>
									<li><label for="cardTypes2" class="">신용카드 및
											체크카드(법인)</label> &nbsp;&nbsp;</li>

								</ul>

								<div class="payco_div" id="payco_table" style="display: none;">
									<span style="color: black;">PAYCO 페이코</span><br>
									<span style="color: black;">- PAYCO는 온/오프라인 쇼핑은 물론 송금, 멤버십	적립까지 가능한 통합 서비스입니다.</span><br>
									<span style="color: black;">- 휴대폰과 카드 명의자가 동일해야 결제 가능하며, 결제금액 제한은 없습니다.</span><br>
									<span style="color: black;">&nbsp;&nbsp;지원카드 : 모든 국내 신용/체크카드</span><br>
									<span>페이코 결제, 변경, 취소는 웹사이트에서만 가능합니다.</span>
								</div>

								<!-- <h5 class="htit">신용카드 및 체크카드 (개인)</h5> -->
								<table id="card_table" class="member etc2"
									summary="승차권 결제의 카드번호, 유효기간, 카드 비밀번호, 생년월일의 신용카드(개인,법인)정보입니다.">
									<colgroup>
										<col style="width: 18%;">
										<col style="">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row"><label for="card_no">카드번호</label></th>
											<td><input type="text" id="cardNo1" name="cardNo1" size="6" maxlength="4" class="txt" style="width: 70px;" alt="카드번호 첫번째 4자리 숫자를 입력해 주세요." title="카드번호 앞자리"> -
												<input type="password" id="cardNo2" name="cardNo2" size="6" maxlength="4" class="txt" style="width: 70px;" alt="카드번호 두번째 4자리 숫자를 입력해 주세요." title="카드번호 두번째자리">	- 
												<input type="password" id="cardNo3" name="cardNo3" size="6" maxlength="4" class="txt" style="width: 70px;" alt="카드번호 세번째 4자리 숫자를 입력해 주세요." title="카드번호 세번째자리"> -
												<input type="text" id="cardNo4" name="cardNo4" size="6"	maxlength="4" class="txt" style="width: 70px;" alt="카드번호 네번째 4자리 숫자를 입력해 주세요." title="카드번호 끝자리"></td>
										</tr>
										<tr>
											<th scope="row"><label for="days">유효기간</label></th>
											<td class="seletw">
											<select style="width: 60px; height: 27px; border: 1px solid #d4d4d4; color: #000; font-weight: bold; font-size: 12px; font-family: Gulim;" id="validMonth" name="validMonth"
												alt="카드 유효기간 중 월을 선택해 주세요." title="카드 유효기간 중 월을 선택해 주세요.">
													<option value="">월</option>
													<option value="01">01</option>
													<option value="02">02</option>
													<option value="03">03</option>
													<option value="04">04</option>
													<option value="05">05</option>
													<option value="06">06</option>
													<option value="07">07</option>
													<option value="08">08</option>
													<option value="09">09</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
											</select> 월 &nbsp; 
											<select	style="width: 80px; height: 27px; border: 1px solid #d4d4d4; color: #000; font-weight: bold; font-size: 12px; font-family: Gulim;" id="validYear" name="validYear" alt="카드 유효기간 중 년도를 선택해 주세요." title="카드 유효기간 중 년도를 선택해 주세요.">
													<option value="">년</option>
													<option value="19">2019</option>
													<option value="20">2020</option>
													<option value="21">2021</option>
													<option value="22">2022</option>
													<option value="23">2023</option>
													<option value="24">2024</option>
													<option value="25">2025</option>
													<option value="26">2026</option>
													<option value="27">2027</option>
													<option value="28">2028</option>
													<option value="29">2029</option>
											</select> 년</td>
										</tr>
										<tr name="creditcard">
											<th scope="row"><label for="card_pw">카드 비밀번호</label></th>
											<td><input type="password" id="cardPwd" name="cardPwd" size="5" maxlength="2" class="txt" style="width: 40px;" alt="카드 비밀번호 앞 두자리를 입력해 주세요." title="카드 비밀번호 앞 두자리를 입력해 주세요."> **</td>
										</tr>
										<tr name="creditcard" id="cardType0">
											<th scope="row"><label for="birth">생년월일</label></th>
											<td><input type="password" id="birthdate1" name="birthdate1" size="12" maxlength="6" class="txt" style="width: 100px;" alt="카드 소유자의 생년월일을 6자리를 입력해 주세요." title="카드 소유자의 생년월일을 6자리를 입력해 주세요.">
											<span class="stxt">(카드 소유자의 생년월일 6자리)</span></td>
										</tr>
										<tr name="creditcard" id="cardType1" style="display: none;">
											<th scope="row"><label for="corp">사업자 등록번호</label></th>
											<td><input type="text" id="corpNo1" name="corpNo1"
												size="5" maxlength="3" class="txt" style="width: 50px;"
												alt="사업자 등록번호 앞번호 3자리를 입력해 주세요."
												title="사업자 등록번호 앞번호 3자리를 입력해 주세요."> - <input
												type="text" id="corpNo2" name="corpNo2" size="4"
												maxlength="2" class="txt" style="width: 30px;"
												alt="사업자 등록번호 중간번호 2자리를 입력해 주세요."
												title="사업자 등록번호 중간번호 2자리를 입력해 주세요."> - <input
												type="text" id="corpNo3" name="corpNo3" size="7"
												maxlength="5" class="txt" style="width: 70px;"
												alt="사업자 등록번호 끝번호 5자리를 입력해 주세요."
												title="사업자 등록번호 끝번호 5자리를 입력해 주세요."></td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
						<!-- //2015-11-24 -->
					</div>

					<div class="btn_center">
						<!-- reservationEnd를 부릅니다. -->
						<a href="<c:url value="/reservation/reservationEnd.do" />" id="pay_btn"><img
							src="<c:url value='/' />/img/btn_pay.gif" alt="결제하기"></a>
					</div>
					
					<p>&nbsp;</p>
					<p>&nbsp;</p>

					<iframe title="빈프레임" id="cardSendForm" name="cardSendForm"
						style="width: 0px; height: 0px;" frameborder="0" scrolling="yes"></iframe>

					<div id="cashbeeNoti" style="display: none;">
						<strong class="note2"><img src="<c:url value='/' />/img/note_cashbee.gif"
							alt="모바일 캐시비 결제 안내 상세보기"></strong>
						<div class="box1">
							<div class="btm">
								<div class="top cashbees">
									<ul class="list01">
										<li>신개념 선불카드 충전 수단 모바일 캐시비는 NFC 기반의 스마트폰을 이용한 모바일 결제 수단으로
											쉽고 빠르게 결제 할 수 있습니다.</li>
										<li>모바일 캐시비는 일부 NFC 기반의 스마트폰에서만 이용이 가능합니다.</li>
										<li>모바일 캐시비 서비스의 자세한 안내는 캐시비 홈페이지(<a
											href="http://www.cashbee.co.kr" target="_blank"
											style="color: #666;"><strong>http://www.cashbee.co.kr</strong></a>)를
											참고하세요.
										</li>
									</ul>
									<div class="pic">
										<img src="<c:url value='/' />/img/note_cashbee_img.gif" alt="">
									</div>
									<ol class="invisible">
										<li>모바일캐시비 다운로드</li>
										<li>결제금선택</li>
										<li>결제정보입력</li>
										<li>SMS확인후 결제승인 완료</li>
										<li>캐시비차감</li>
										<li>결제완료</li>
									</ol>
								</div>
							</div>
						</div>
					</div>

					<div class="note etc2">
						<strong class="tt"><img src="<c:url value='/' />/img/note.gif"
							alt="유의사항 입니다."></strong>
						<ul>
							<li>터미널에서 승차권 발권 시 예매하신 카드번호를 숙지(또는 소지)하셔야 합니다.</li>
							<li>카드사 장애, 카드 분실 등 특별한 경우를 제외하고, 카드로 예매 후 발권 시 현금 또는 기타
								신용카드로는 발권이 절대 불가능합니다.</li>
							<li>예매한 카드를 분실하거나 재발급 시에는 이전 카드로 예매하신 사항을 취소하시고, 신규 카드로 다시
								예매하셔야 합니다. <br> (터미널 창구에서는 변경 전 카드의 번호를 알 수 없으므로, 승차권을 발권할
								수 없으며, 이 경우 부도위약금이 발생하게 됩니다.)
							</li>
							<li>출발시간 이전에 발권 및 취소가 가능하며, 출발시간 이후 취소 시 부도위약금이 발생하고, 예매하신
								카드로는 동일 노선의 카드 발권이 불가능하오니, <br> 현금이나 다른 카드를 사용하시기 바랍니다.
							</li>
							<li>소요시간은 도로 및 버스회사의 사정에 따라 변경될 수 있습니다.</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- 스타일 시트에 -->
	</div>
	</content>
	<footer style="clear:both;padding-bottom: 265px;">
	
	</footer>
	

</body>
</html>