/**
 * 객체 이해하기
 * 
 * 객체 생성 시 값의 초기화 및 프로퍼티 삭제
 * 
 */


 let member = {
     //id에 hong 을 주겠다 json과 비슷
     "id" : "jay",
     "email" : "jay@a.com"
 };
 
 console.log(member);
 
 //프로퍼티 추가
 member.name = "정재현";
 console.log(member);
 
 
 //프로퍼티 삭제
 delete member.name;
 console.log(member);