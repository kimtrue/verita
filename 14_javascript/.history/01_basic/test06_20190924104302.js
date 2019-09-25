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
 var id="hong";
 console.log(id);