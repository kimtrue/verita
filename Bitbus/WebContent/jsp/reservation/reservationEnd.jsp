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
    <%@ include file="/jsp/include/cssReservationPayment.jsp" %>
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
                <a href="index.html">
                    <img src="<c:url value='/' />/img/logo(white).png" alt="임의로고">
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

    <content>
        <div id="subContent">
            <h2 class="title"><img src="<c:url value='/' />/img/title.gif" alt="승차권예매 예매가능한 좌석정보와 운행정보, 간편한 결제방식으로 인터넷 승차권 예매를 하실 수 있습니다."></h2>
            <p class="step"><img src="<c:url value='/' />/img/step03.gif" alt="승차권 예매 1단계:예매정보 2단계:확인/결제 3단계:예매완료 단계 중 3단계:예매완료 입니다."></p>
            
            <p class="message"><img src="<c:url value='/' />/img/mess_01.gif" alt="예매가 완료되었습니다."></p>
            <p class="messages">
            예매 완료 후 터미널 창구 또는 무인기에서 승차권을 반드시 발권 받으시기 바랍니다.<br>예매 확인 내역 및 결제 내역은 승차권으로 대신 사용할 수 없습니다.
            
                 
                    <br><br><u>'인천'(타사터미널) 발권시 실물 카드가 반드시 필요 합니다.</u>
                  
            
            
            
            </p>
            
            <h4 class="stit"><img src="<c:url value='/' />/img/h4_reserve.gif" alt="예매정보 입니다."></h4>
             
            <table class="board_list" summary="예매하신 승차권의 출발지, 도착지, 출발일자, 출발시각, 등급, 좌석, 금액, 홈티켓 발권 정보입니다.">
            <colgroup>
                <col style="width:18%;">
                <col style="width:18%;">
                <col style="width:12%;">
                <col style="width:10%;">
                <col style="width:12%;">
                <col style="width:10%;">
                <col style="width:10%;">
                <col style="width:10%;">
            </colgroup>
            <thead>
                <tr>
                    <th scope="col">출발지</th>
                    <th scope="col">도착지</th>
                    <th scope="col">출발일자</th>
                    <th scope="col">출발시각</th>
                    <th scope="col">등급</th>
                    <th scope="col">좌석</th>
                    <th scope="col">금액</th>
                    <!-- <th scope="col">홈티켓 발권</th> -->
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="hidden" name="departure">${departure}</td>
                    <td><input type="hidden" name="arrival">${arrival}</td>
                    <td><input type="hidden" name="schDate">${schDate}</td>
                    <td><input type="hidden" name="departureTime">${departureTime}</td>
                    <td><input type="hidden" name="busGrade">${busGrade}</td>
                    <td><input type="hidden" name="seatNo">
										<% for(int i = 0; i < seatNo.length; i++) {
											out.print(seatNo[i]); } %><br>
										
                            
                        
                    
                    </td>
                    <!-- 성인 금액과 아동금액을 합쳐서 payment라고 명함. -->
                    <td id="singleFee"><strong><input type="hidden" name="payment">${payment}</strong></td>
                    <!-- 원금액 -->
                    
                    
                </tr>
                
            </tbody>
            </table>

            <h4 class="stit"><img src="<c:url value='/' />/img/h4_payment.gif" alt="결제정보 입니다."></h4>
            <table class="type2" summary="승차권의 총 인원/요금, 승인일자, 총 매수, 총 결제금액, 카드구분, 승인번호의 결제정보입니다.">
            <colgroup>
                <col style="width:15%;">
                <col style="width:35%;">
                <col style="width:15%;">
                <col style="width:35%;">
            </colgroup>
            <tbody>
                
                <tr>
                    <th scope="row">인원</th>
                    <td>1 명 <span id="totPeople"></span></td>
                    <th scope="row">승인일</th>
                    <td>2019년 09월 15일 (일)</td>
                </tr>
                <tr>
                    <th scope="row">매수</th>
                    <td><strong>1</strong> 매</td>
                    <th scope="row">결제금액</th>
                    <td id="tot_fee"><strong>7,300 원</strong></td>
                    
                </tr>
                
            </tbody>
            </table>
            
            <div class="note etc2">
                <strong class="tt"><img src="<c:url value='/' />/img/note.gif" alt="유의사항"></strong>
                <ul>
                    <li>인터넷 예매를 이용한 승차권의 발권 및 환불은 해당 승차권의 출발지 터미널에서만 가능합니다.</li>
                    <li>승차권 예매와 관련한 문의사항은 콜센터(1234-5678)로 문의해주시기 바랍니다.</li>
                </ul>
            </div>

            <div class="btn_center">
                <a href="<c:url value='/'/>/reservation/reservationSendEmail.do" title="예매조회/변경/취소로 이동">
                    <img src="<c:url value='/' />/img/btn_reserve_check.gif" alt="예매 조회/변경/취소 페이지로 이동하는 버튼 입니다."></a>
                
            
            </div>

            <div id="agebox" style="display: none;" tabindex="0">
                <div class="agebox" style="display: none;">
                    <strong class="laytit etc"><font style="font-size:26px; color:#910808;">예매한 승차권 발권 시 확인 사항</font></strong>
                    <div class="agetxt" style="margin-top:10px;">
                        <div id="age1" style="padding-left:4px;">
                            <p style="font-size:11px;">
                             - 예매한 카드 소지하여 창구 또는 무인기에서 발권 받으세요.<br>
                             - 예매한 카드 미소지시 입력하신 핸드폰 번호를 창구에 알려주세요.<br>
                             - 위 2가지 사항 없이 예매된 내역만으로는 확인이 불가능하오니<br><span style="color:white;">- </span>꼭 확인 후 터미널 방문하시기 바랍니다.<br>
                             - 차량 출발 10분전까지 터미널에 도착하여 발권 받으시기 바랍니다.<br>
                             - 일부 터미널에서 중고생 승객은 발권시 신분확인 관계로 무인 발권기 이용이<br><span style="color:white;">- </span>불가하여, 창구에서 학생증(청소년증)을 예약하신 카드와 제시하셔야 합니다.<br>
                             <span style="color:white;">- </span>(학생증[청소년증] 미소지 시 중고생 할인이 불가하오니 유의하시기 바랍니다.)<br>
                            </p>			
                        </div>
                    </div>
                    
                    <a href="#" class="ageclose"><img src="/newweb/kr/images/popup/close.gif" alt="닫기 버튼 입니다."></a>
                <a href="javascript:void(0);" class="linkAppend"></a></div>
            </div>
        </div>


        <footer>하단</footer>

</body>
</html>

</body>
</html>