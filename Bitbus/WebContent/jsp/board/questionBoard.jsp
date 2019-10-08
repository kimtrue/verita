<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<%@ include file="/jsp/include/cssBoardScript.jsp" %>


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
	<content>
	<div class="main">
		<!-- content에 소스작성 -->
		<div class="leftmenu">
			<img src="<c:url value='/' />/img/lnb_tit.gif" alt="leftmenu이미지파일">
			<div class="slnb">
				<ul class="lnb">
					<li class="sta"><a href="questionboard.do" alt="고객센터입니다">고객센터</a></li>
					<li class="sta"><a href="serviceboard.do" alt="공지사항입니다">공지사항</a></li>
				</ul>
			</div>
		</div>
		<div class="middlecontent">
			<div class="content" id="subContent">
				<!-- content -->
				<h3 class="stit" style="color: cornflowerblue">고객센터</h3>
				<p class="des">고객센터 게시판입니다.</p>
			</div>
			<div>


				<table class="board_list" summary="번호,제목,첨부,등록일,조회수">

					<colgroup>
						<col style="width: 7%;" />
						<col style="" />
						<col style="width: 15%;" />
						<col style="width: 8%;" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">등록일</th>
							<th scope="col">조회</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${list}">
						<tr>
							<td>${board.boardNo }</td>
							<td class="subject"><a href="questionOneBoard.do?no=${board.boardNo}"
								alt="${board.title }">${board.title }</a></td>
							<td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" /></td>
							<td>${board.viewCnt }</td>
						</tr>
						</c:forEach>
						<c:if test="${empty list}">
						<tr>
							<td colspan='4'>입력된 게시물이 없습니다.</td>
						</tr>
						</c:if>


					</tbody>

				</table>
					<div>
					<c:if test="${pr.count != 0}">
						<nav style="text-align: center">
							<ul class="pagination">
								<c:if test="${pr.prev}">
									<li><a href="questionboard.do?pageNo=${pr.beginPage - 1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
									<li
										<c:if test="${pr.pageNo == i}">class="active"
    							</c:if>>
										<a href="questionboard.do?pageNo=${i}">${i}</a>
									</li>
								</c:forEach>
								<c:if test="${pr.next}">
									<li><a href="questionboard.do?pageNo=${pr.endPage + 1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
							</ul>
						</nav>
					</c:if>

				</div>
				
		
		
				<div>
					<form action="questionboard.do" method="post">
					<fieldset>
						<legend>고객센터 검색하기</legend>
						<div class="terminal_search">
							<select
								style="width: 110px; height: 27px; border: 1px solid #d4d4d4; color: #000; font-weight: bold; font-size: 12px; font-family: Gulim;"
								id="select" class="searchSelect" name="searchType"
								alt="검색조건선택입니다" title="검색 조건 선택">
								<option value="1" selected="selected">전체</option>
								<option value="2">제목</option>
								<option value="3">내용</option>
								<option value="1">제목 + 내용</option>
							</select> <input type="text" style="width: 50%;" name="keyWord"
								class="txts" placeholder="검색 키워드를 입력해 주세요."
								 alt="검색 키워드를 입력해 주세요."
								title="검색 키워드를 입력해 주세요." /> <button><img
								src="<c:url value='/' />/img/bts_search.gif" alt="검색버튼입니다"
								class="bts" /></button>
						</div>
					</fieldset>
					</form>
				</div>


			</div>
		</div>
	</div>
	</content>
      <footer>
            <div class="footer">
                <span class="flogo"><img src="<c:url value="/img/logo(white).png" />" alt="cashbee"></span>
                <div class="fotn">
                    <p class="address">비트캠프 서울시 서초구 강남대로 459 (서초동, 백암빌딩)｜ 사업자등록번호 : 214-85-24928
                            (주)비트컴퓨터 서초지점 대표이사 : 조현정 / 문의 : 02-3486-9600 / 팩스 : 02-6007-1245
                            통신판매업 신고번호 : 제 서초-00098호 / 개인정보보호관리책임자 : 최종진
                            Copyright (c) 비트캠프 All rights reserved.
                    </p>
                </div>
            </div>
        </footer>



</body>

</html>