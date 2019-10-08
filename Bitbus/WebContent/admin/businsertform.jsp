<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin - Tables</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
	<style>
		input {
		border: none;
		border-right: 0px; 
		border-top: 0px; 
		boder-left: 0px; 
		boder-bottom: 0px;
		}
	</style>
</head>

<body id="page-top">
	<c:import url="sidebar.jsp"/>
    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- 상단의 페이지 정보-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">버스</a>
          </li>
          <li class="breadcrumb-item active">버스 추가</li>
        </ol>

        <!-- 추가할 버스 조건 선택 -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            버스 조회</div>
          <div class="card-body">
            <div class="table-responsive">
            <form name="iForm" action="businsert.do">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                  	<th><button>추가</button></th>
                    <th>버스 번호</th>
                    <th>버스 등급</th>
                    <th>좌석수</th>
                    <th>터미널 선택</th>
                    <th>터미널 선택</th>
                  </tr>
                </thead>
                <tbody>
                <tr>
                <td></td>
                  	<td><input type="text" name="busLicense"></td>
                  	<td>
                  		<select name="busGrade" onclick="seatCnt();">
                  			<option value="일반">일반</option>
                  			<option value="우등">우등</option>
                  		</select>
                  	</td> 
                  	<td id="seatCnt"></td>
                  	<td>
                  		<select>
                  			<c:forEach var="terminal" items="${terminalList}">
                  				<option value="${terminal.terminalNo}">${terminal.terminalName}</option>
                  			</c:forEach>
                  		</select>
                  	</td>
                  	<td>
                  		<select>
                  			<c:forEach var="terminal" items="${terminalList}">
                  				<option value="${terminal.terminalNo}">${terminal.terminalName}</option>
                  			</c:forEach>
                  		</select>
                  	</td>
                  	</tr>
               </tbody>
              </table>
              <button>추가</button>
       		  </form>
            </div>
          </div>
          <div class="card-footer small text-muted"></div>
        </div>


      </div>
    </div>
	<c:import url="footer.jsp"></c:import>
<script type="text/javascript">
	function seatCnt(){
	let optEle = document.querySelector("#seatCnt");
	let text = optEle.innerHTML;
	if (document.iForm.busGrade.value == "일반"){
		text = "28";
	} else {
		text = "19";
	}
	optEle.append(text);		
	}
</script>
</body>

</html>