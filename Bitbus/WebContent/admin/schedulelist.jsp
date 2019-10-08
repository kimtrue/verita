<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Tables</title>


<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
 
<!-- 페이징 임시 style 
<style type="text/css">
#paging {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination li {
	border: 1px solid blue;
	width: 40px;
	height: 40px;
	border-radius: 10%;
	padding: 5px;
	vertical-align: middle;
	display: inline-block;
}

#paging {
	justify-item: center;
}

.size_search {
	display: inline-block;
}

#list_size {
	display: inline-block;
}

#search {
	float: right;
}
</style>
-->


</head>
<body id="page-top">
	<c:import url="sidebar.jsp" />

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- 상단의 페이지 정보-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">스케줄</a></li>
				<li class="breadcrumb-item active">스케줄 조회</li>
			</ol>
				<!-- 한번에 보여줄 페이지수 콤보박스
			<div class="size_search">
				<form action="schedulelist.do" id="list_size" class="size_search"
					 method="post">
					<span>게시글 개수 : </span> 
					<select name="listSize" onchange="submit();">
						<option id="opt1" value="5">5</option>
						<option id="opt2" selected="selected" value="10">10</option>
						<option id="opt3" value="15">15</option>
						<option id="opt4" value="20">20</option>
					</select>
				</form>
				 -->
				<!-- 버스 검색 
				<form action="schedulelist.do?listSize=${listSize}" id="serch" class="size_search"
					method="post">
					<span>검색 : </span> <select name="searchType">
						<option value="busLicense" selected="selected">버스 번호</option>
						<option value="departure">출발지</option>
						<option value="arrival">도착지</option>
						<option value="schDate">출발날짜</option>
					</select>
					<select name="keyWord" id="keyWord">
					</select>
					<button>검색</button>
				</form>
				-->
			</div>
			<br /> <br />
			<!-- 버스조회 결과 테이블 -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> 스케줄 조회
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form action="busdelete.do" name="bForm">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>노선번호</th>
										<th>버스번호</th>
										<th>출발지</th>
										<th>도착지</th>
										<th>출발시간</th>
										<th>운행시간</th>
										<th>성인요금</th>
										<th>아동요금</th>
										<th>출발날짜</th>
										<th>예약현황</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty scheduleList}">
										<tr>
											<td colspan="9">등록된 스케줄이  없습니다.</td>
										</tr>
									</c:if>
									<c:forEach var="schedule" items="${scheduleList}">
										<tr>
											<td>${schedule.lineNo}</td>
											<td>${schedule.busLicense}</td>
											<td>${schedule.departure}</td>
											<td>${schedule.arrival}</td>
											<td>${schedule.departureTime}</td>
											<td>${schedule.operatingTime}</td>
											<td>${schedule.adultPrice}</td>
											<td>${schedule.kidPrice}</td>
											<td>${schedule.schDate}</td>
											<td> / ${schedule.maxSeatCnt}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</form>
					</div>
				</div>
				<!-- 
				<div id="paging">
					
					<c:if test="${pr.count != 0}">
						<nav>
							<ul class="pagination">
								<c:if test="${pr.prev}">

									<li><a href="schedulelist.do?pageNo=${pr.beginPage - 1}&listSize=${listSize}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
									<li <c:if test="${pr.pageNo == i}">class="active"</c:if>><a
										href="schedulelist.do?pageNo=${i}&listSize=${listSize}">${i}</a></li>
								</c:forEach>
								<c:if test="${pr.next}">
									<li><a href="schedulelist.do?pageNo=${pr.endPage + 1}&listSize=${listSize}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
							</ul>
						</nav>
					</c:if>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		let searchType = document.querySelector("#searchType");
		let keyWord = document.querySelector("#keyWord");
		keyWord.addEventListener(change, () => {
			switch(searchType.value){
			case 'busLicense':
				
				break;
			case 'departure':
				break;
			case 'arrival':
				break;
			case 'schDate':
				break;
			}
		});
		
	
		let listSize = ${listSize};
		let optEle;
		switch (listSize){
			case 5:
				optEle = document.querySelector("#opt1");
				break;
			case 10:
				optEle = document.querySelector("#opt2");
				break;
			case 15:
				optEle = document.querySelector("#opt3");
				break;
			case 20:
				optEle = document.querySelector("#opt4");
			break;
			default : optEle = document.querySelector("#opt2");
		}
		optEle.selected = true;
		
		function doCheck() {
			let f = document.bForm;
			let checkRow = f.checkRow;
			if (checkRow.length) {
				for (let i = 0; i < checkRow.length; i++) {
					checkRow[i].checked = f.checkAll.checked;
				}
			}
		}
		function releaseChk(){
			let f = document.bForm;
			let checkRow = f.checkRow;
			if (checkRow.length) {
				for (let i = 0; i < checkRow.length; i++) {
					if (checkRow[i].checked == true) continue; 
					f.checkAll.checked = false;
				}
			}
		}
		function submit(){
			location.href="schedule.do?listSize=" + listSize; 
		}
	</script>
				 -->
				 </div>
					<c:import url="footer.jsp" />
</body>

</html>