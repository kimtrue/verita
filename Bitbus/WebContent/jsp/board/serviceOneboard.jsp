<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
                <a href="<c:url value="/main.do" />">
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
    </header>

    <!-- 중단 메인 박스 -->
    <content>
        <div class="main">
            <!-- content에 소스작성 -->
            <div class="leftmenu"><img src="/img/lnb_tit.gif" alt="leftmenu이미지파일">
                <div class="slnb">
                    <ul class="lnb">
                        <li class="sta"><a href="/servicecenter.html" alt="공지사항입니다">공지사항</a></li>
                    </ul>
                </div>
            </div>
            <div class="middlecontent">
                <div class="content" id="subContent">
                    <!-- content -->
                    <h3 class="stit"><img src="<c:url value='/' />/img/h3_notice.gif" alt="공지사항" /></h3>
                    <p class="des">비트고에서 새로운 소식을 알려드립니다.</p>
                </div>
                <div>
                

                    <table class="board_view" summary="제목,첨부파일,등록일,조회수,글내용">
                        
                       <colgroup>
                           <col style="width:15%;" />
                           <col style="" />
                           <col style="width:15%;" />
                           <col style="width:15%;" />
                       </colgroup>
                       <tbody>
                           <tr>
                               <th scope="row">제  목</th>
                               <td class="left" id="subject"></td>
                               <th scope="row">등록일</th>
                               <td id="registeDt"></td>
                           </tr>
                           <tr>
                               <th scope="row">첨부파일</th>
                               <td class="left" id="files"></td>
                               <th scope="row">조회수</th>
                               <td id="nView"></td>
                           </tr>
                           <tr>
                               <td colspan="4" class="cont" id="content">
                                    <div style="position: relative;">

                                            <img src="/img/추석.jpg" 
                                            alt="추석 맞이 깜짝 이벤트" style="border:none; padding-bottom:20px; width:100%;"/>
                                            </div>
                               </td>
                            </tr>
                        </tbody>
                    </table>
                    
                </table>
				
				
                <table class="board_list2" summary="새로운 소식의 이전글, 다음글 입니다">
                <colgroup>
                    <col style="width:15%;" />
                    <col style="" />
                    <col style="width:13%;" />
                </colgroup>
                <tbody>
                  <c:if test="${qboard.preTitle ne 'pre' }">
                     <tr id="prevTr">
                        <th scope="row" class="prev">이전글</th>
                        <td><a href="serviceOneboard.do?no=${qboard.preNo}" id="prevSubject" alt="이전글입니다">${qboard.preTitle }</a></td>                        
                        <td id="prevRegisteDt"></td>
                    </tr>
                  </c:if>
                  <c:if test="${qboard.nextTitle ne 'next' }">
                    <tr id="nextTr">
                        <th scope="row" class="next">다음글</th>
                        <td><a href="serviceOneboard.do?no=${qboard.nextNo}" id="nextSubject" alt="다음글입니다">${qboard.nextTitle }</a></td>
                        <td id="nextRegisteDt"></td>
                    </tr>
                   </c:if>
                </tbody>
                </table>
            
                <div class="btn_center">
                    <a href="serviceboard.do" id="listBtn"><img src="/img/btn_list.gif" alt="목록버튼입니다" /></a>
                </div>
                </div>
            </div>
        </div>
    </content>
    
    


</body>

</html>