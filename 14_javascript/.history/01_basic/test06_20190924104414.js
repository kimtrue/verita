/**
 * 변수
 * - 변수의 중복 선언이 가능함
 * - 이전에 선언한 변수를 덮어쓴다.
 * 
 * String name = "a";
 * String name = "b"; 
 *  => java는 에러났다. 변수명이 같아서.. 
 * 
 */

 var id="hong";
 console.log(id);

 var id="abc123";
 console.log(id);

 //undefined : 변수에 아무 값도 없어서 타입을 알지 못하는 경우
var name;