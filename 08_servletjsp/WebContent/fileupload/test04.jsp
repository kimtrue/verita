<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>파일 업로드 예제</h2>
   <div>
   <%--
            파일 업로드 규칙
     1. 파일을 업로드하려면 post 방식(get방식으로 하면 url에 붙어가는데 한계가 있다)
     2. enctype="multipart/form-data" 를 선언해줘야 한다  
        => 서버로 파일의 내용을 보내기 위해서 필수
      
    --%>
       <form method="post" action="test04.do" enctype="multipart/form-data">
         <div><input type="text" name="msg" /></div>
         <div><input type="file" name="attach1" /></div>
         <div><input type="file" name="attach2" /></div>
         <div><button>전송</button></div>
       </form>
   </div>

</body>
</html>