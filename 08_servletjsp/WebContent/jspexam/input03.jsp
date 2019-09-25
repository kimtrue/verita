<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div>
    <form action="output03.jsp">
     <div mar>
      	 <h1>입사지원서</h1>
     </div>
     <div>
         <p>아래 항목을 입력해 주세요</p>
     </div>
     <div>
       <p><strong>개인 정보:</strong></p>
       <div>
          <label>이름</label>
          <input style="text" name="name">
       </div>
       <div>
          <label>핸드폰</label>
          <input style="text" name="phone">
       </div>
       <div>
          <label>이메일 주소</label>
          <input style="text" name="email">
       </div>
       <div>
         <p><strong>학과를 선택해 주세요</strong></p>
         <div>
           <lable><input type="radio" name="major" value="컴퓨터공학과">컴퓨터공학과</lable>
           <lable><input type="radio" name="major" value="전자과">전자과</lable>
           <lable><input type="radio" name="major" value="수학과">수학과</lable>
           <lable><input type="radio" name="major" value="산업공학과">산업공학과</lable>          
         </div>
         <div>
          <p><strong>이수 과목은 무엇입니까?</strong></p>
         </div>
         <div>
           <lable><input type="checkbox" name="class" value="EJB">EJB</lable>
           <lable><input type="checkbox" name="class" value="Spring">Spring</lable>          
           <lable><input type="checkbox" name="class" value="UML">UML</lable>
         </div>          
         <div>
           <lable><input type="checkbox" name="class" value="JDBC">JDBC</lable>          
           <lable><input type="checkbox" name="class" value="서블릿">서블릿</lable>          
           <lable><input type="checkbox" name="class" value="JDBC">JDBC</lable>          
         </div>
          
          
       </div>
       
       
     </div>
     
     <button>전송</button>
    
    </form>
   
   
   </div>

</body>
</html>