/**
 * 객체의 정보 확인
 * 
 */

 let member = {
     id: "jay",
     email: "jay@a.com"
 };

 let member2 = member;
 member2.name = "이";

 console.log(member);
 console.log(member2);
 //공간이 2개 만들어진게 아니라 같은 공간을 사용하고 있다


 //객체의 내용 확인. key값만
 for(let k in member){
     console.log("key: " , k, ", value : ", member[k]);
 }
 //member[k] 에 해당하는 밸류값 출력해준다

 //다양한 데이터를 집어 넣을 수 있다.
 let obj = {
     name: "이",
     age : 21,
     addr : ['서울시', '강남구', 110],
     work : function() { return "work";}
 };

 //work 부르기
 console.log(obj.work());