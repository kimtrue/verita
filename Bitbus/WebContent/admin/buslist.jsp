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

<!-- 페이징 링크 -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/resources/css/layout.css"> --%>
<!-- <link rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/resources/css/basic.css"> --%>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<!-- 페이징 임시 style -->
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

</head>
<body id="page-top">
	<c:import url="sidebar.jsp" />

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- 상단의 페이지 정보-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">버스</a></li>
				<li class="breadcrumb-item active">버스 조회</li>
			</ol>
				<!-- 한번에 보여줄 페이지수 콤보박스 -->
			<div class="size_search">
				<form action="buslist.do" id="list_size" class="size_search"
					 method="post">
					<span>게시글 개수 : </span> 
					<select name="listSize" onchange="submit(this.value);">
						<option id="opt1" value="5">5</option>
						<option id="opt2" selected="selected" value="10">10</option>
						<option id="opt3" value="15">15</option>
						<option id="opt4" value="20">20</option>
					</select>
				</form>
				<!-- 버스 검색 -->
				<form action="buslist.do" id="serch" class="size_search"
					method="post">
					<span>검색 : </span> <select name="serchType">
						<option value="busLicense">버스 번호</option>
						<option value="busGrade">버스 등급</option>
					</select>
				</form>
			</div>
			<br /> <br />
			<!-- 버스조회 결과 테이블 -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> 버스 조회
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form action="busdelete.do" name="bForm">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>번호</th>
										<th><input type="checkbox" name="checkAll"
											id="th_checkAll" onclick="doCheck();">선택</th>
										<th>버스 번호</th>
										<th>버스 등급</th>
										<th>좌석수</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty busList}">
										<tr>
											<td colspan="4">등록된 버스가 없습니다.</td>
										</tr>
									</c:if>
									<c:forEach var="bus" items="${busList}">
										<tr>
											<td>1</td>
											<td><input type="checkbox" name="checkRow"
												onclick="releaseChk();" value="${bus.busNo}"></td>
											<td>${bus.busLicense}</td>
											<td>${bus.busGrade}</td>
											<td>${bus.maxSeatCnt}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<button>삭제</button>
						</form>
					</div>
				</div>
				<div></div>
				<div id="paging">
					<!-- 페이징 -->
					<c:if test="${pr.count != 0}">
						<nav>
							<ul class="pagination">
								<c:if test="${pr.prev}">

									<li><a href="buslist.do?pageNo=${pr.beginPage - 1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
									<li <c:if test="${pr.pageNo == i}">class="active"</c:if>><a
										href="buslist.do?pageNo=${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${pr.next}">
									<li><a href="buslist.do?pageNo=${pr.endPage + 1}"
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
		<c:import url="footer.jsp" />

	</div>
	<script type="text/javascript">

		let listCnt = ${listCnt};
		console.log(listCnt);
		let optEle;
		switch (listCnt){
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
		function submit(value){
			location.href="buslist.do?listSize=" + listCnt; 
		}
	</script>

</body>

</html>