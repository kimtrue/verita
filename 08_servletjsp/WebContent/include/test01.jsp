<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%--  페이지를 갖고와서 포함시키기. file =  같은 디렉토리에 있어서 --%>
     <%--
        sample의 html 형식들의 내용을 지워줬다
        include방식을 사용하면 부른 sample의 내용이 test01.jsp body안에 포함되기 때문에
        
        --문제점
        test01.jsp (10줄)
        @sample01.jsp(1000)
        @topmenu.jsp (2000)
        
        => 눈에는 보이지 않지만 test01이 10줄인 것 같지만 3010줄이 된다. 
          include한 것도 포함되니까   자바 파일이 너무 커진다. 소스를 그냥 갖고와서 집어넣기 때문에
        
        - 지시자 인클루드 방식
         : 소스코드를 가져와서 합치는 방식  
         
                   파라미터를 줄 수 없다. 
                   자바 io 방식 소스코드를 읽는 애니까..
                   
                   
               ※ 변수를 같이 사용가능           
       test01.jsp 에서 int i = 10; 을 선언
       sample.jsp에서 System.out.print(i); 를 했을때 . 사용이 가능할까?
              가능하다. 단 시점은 소스가 다 합쳐지고 나서 .  
        <%@ include %> 보다 위에서 사용 할 수는 없다.

      --%>
     <h2>test01.jsp</h2>
     <hr />
     <%@ include file="sample.jsp" %>
     <%= msg %>
     <hr />
      

</body>
</html>