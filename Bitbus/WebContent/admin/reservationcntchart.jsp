<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<style type="text/css">
/* #container {
	min-width: 320px;
	max-width: 600px;
	margin: 0 auto;
} */
</style>
</head>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>



<body id="page-top">
	<c:import url="sidebar.jsp" />
	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- 상단의 페이지 정보-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">통계</a></li>
				<li class="breadcrumb-item active">기간별 예약수</li>
			</ol>
			<div id="container"></div>
		</div>
	</div>
	<div class="card-footer small text-muted"></div>


	<c:import url="footer.jsp"></c:import>
</body>
<script type="text/javascript">
let yearList = ${yearList};
let monthList = ${monthList};
let currYear = (String)(new Date().getFullYear()).substring(2);
	Highcharts
			.chart(
					'container',
					{
						chart : {
							type : 'column'
						},
						title : {
							text : '기간별 예약수'
						},
						subtitle : {
							text : '연별 예약수'
						},
						xAxis : {
							type : 'category'
						},
						yAxis : {
							title : {
								text : '예약 건수'
							}

						},
						legend : {
							enabled : false
						},
						plotOptions : {
							series : {
								borderWidth : 0,
								dataLabels : {
									enabled : true,
									format : '{point.y:f}'
								}
							}
						},

						tooltip : {
							headerFormat : '<span style="font-size:11px">{series.name}</span><br>',
							pointFormat : '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:f}</b>건<br/>'
						},

						series : [
							
								{name : "연별 예약수",
								colorByPoint : true,
								data : [ 
									{
									name : currYear + '년도 예약수',
									y : yearList[0],
									drilldown : currYear
									}
							/*		
							for (let i = 17; i <= parseInt(currYear); i++){
									{
									name : i + "년도 예약수",
									y : yearList[i-17]
									drilldown : "Chrome"
										}
								}
							*/
							]
						} ],
						drilldown : {
							series : [
									{
										name : currYear,
										id : currYear,
										data : [
											["10월", monthList[0]] 
											 ]
									},
									
						
									/*
									{
										name : currYear,
										id : currYear,
										data : [
											for (let i = 1; i <= 12; i++){
												[i + "월", monthList[i-1]]
											}
											 ]
									},
									*/
									{
										name : "Firefox",
										id : "Firefox",
										data : [ [ "v58.0", 1.02 ],
												[ "v57.0", 7.36 ],
												[ "v56.0", 0.35 ],
												[ "v55.0", 0.11 ],
												[ "v54.0", 0.1 ],
												[ "v52.0", 0.95 ],
												[ "v51.0", 0.15 ],
												[ "v50.0", 0.1 ],
												[ "v48.0", 0.31 ],
												[ "v47.0", 0.12 ] ]
									},
									{
										name : "Internet Explorer",
										id : "Internet Explorer",
										data : [ [ "v11.0", 6.2 ],
												[ "v10.0", 0.29 ],
												[ "v9.0", 0.27 ],
												[ "v8.0", 0.47 ] ]
									},
									{
										name : "Safari",
										id : "Safari",
										data : [ [ "v11.0", 3.39 ],
												[ "v10.1", 0.96 ],
												[ "v10.0", 0.36 ],
												[ "v9.1", 0.54 ],
												[ "v9.0", 0.13 ],
												[ "v5.1", 0.2 ] ]
									},
									{
										name : "Edge",
										id : "Edge",
										data : [ [ "v16", 2.6 ],
												[ "v15", 0.92 ],
												[ "v14", 0.4 ], [ "v13", 0.1 ] ]
									},
									{
										name : "Opera",
										id : "Opera",
										data : [ [ "v50.0", 0.96 ],
												[ "v49.0", 0.82 ],
												[ "v12.1", 0.14 ] ]
									} ]
						}
					});

</script>
</html>