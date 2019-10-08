<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

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
      .btnservice{
        background-color: #0b5098;
        color: white;
        padding: 10px 40px;
      }
      .btnservicelist{
        background-color: #0b5098;
        color: white;
        padding: 5px 70px;
        margin-top: 50px;
      }
      	table th{
		text-align:center;
	}
  </style>
</head>

<body id="page-top">

   <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index.jsp">BITTAGO</a>
<!-- 상단네비게이션바 & 사이드바-->
    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
    </form>
  </nav>

  <div id="wrapper">

     <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>버스</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <a class="dropdown-item" href="businsertform.do">버스 추가</a>
          <a class="dropdown-item" href="buslist.do">버스 조회</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>노선</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <a class="dropdown-item" href="lineinsert.do">노선 추가</a>
          <a class="dropdown-item" href="linelist.do">노선 조회</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>스케줄</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <a class="dropdown-item" href="schduleinsert.do">스케줄 추가</a>
          <a class="dropdown-item" href="schdulelist.do">스케줄 조회</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>예약</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <a class="dropdown-item" href="reservationlist.do">예약 조회</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-table"></i>
          <span>공지사항</span></a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <a class="dropdown-item" href="writeboard.do">공지사항 추가</a>
          <a class="dropdown-item" href="listboard.do">공지사항 조회</a>      
      </li>
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>통계</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user-circle fa-fw"></i>
          <span>로그아웃</span></a>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">Tables</li>
        </ol>

        <!-- DataTables Example -->
        
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Data Table Example</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <colgroup>
                  <col style="width:5%;" />
                  <col style="width:20%;" />
                  <col style="width:5%;" />
                  <col style="width:20%;" />
              </colgroup>
              <tbody>
                <tr>
                  <th> 글번호</th>
                  <td>${list.boardNo}</td>
                  <th> 조회수</th>
                  <td>${list.viewCnt}</td>
                </tr>
                <tr>
                  <th> 제목</th>
                  <td>${list.title}</td>
                  <th> 등록일</th>
                  <td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" /></td>
                </tr>
                <tr>
                  <th colspan="4">내용</th>
                </tr>
                <tr>
                  <td colspan="4">${list.content}</td>
                </tr>
                <tr>
                  <th>첨부파일</th>
                  <td colspan="3">
                    <div><a href="downloadfile.do?path=${file.path}&orgName=${file.orgName}">${file.orgName}</a></div>                  
                  </td>
                </tr>
              </tbody>
              </table>
              
            </div>
          </div>
         
        </div>

        <div class="downinput" style="text-align: left;padding-bottom:30px;">
            <input type="button" class="btnservice" onclick="location.href='updateboard.do?no=${list.boardNo}'" value="수정" />
            <input type="button" class="btnservice" onclick="location.href='deleteboard.do?no=${list.boardNo}'" value="삭제" />
        </div>



        <footer class="sticky-footer">
            <div class="container my-auto">
              <div class="copyright text-center my-auto">
                <span>Copyright © Your Website 2019</span>
              </div>
            </div>
          </footer>
          
        </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="js/demo/datatables-demo.js"></script>
</body>

</html>
  