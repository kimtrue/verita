/**
 * 변수의 호이스팅
 * 
 * -엔진이 스크립트를 해석하는 과정
 * -1단계 : 컴파일  
 * -2단계 : 실행
 * 
 * 컴파일 단계
 *  : 변수의 정보를 먼저 설정
 * 
 * 
 * 호이스팅 과정
 * 1. 컴파일
 *  var id;
 *  var name;
 * 
 * id = "hong"
 * consol.log(id)
 * id = "abc123"
 * consol.log(id)
 * 
 * 
 * 
 */

 var id="hong";
 console.log(id);

 //중복선언
 var id="abc123";
 console.log(id);

 var name;
 console.log(name);