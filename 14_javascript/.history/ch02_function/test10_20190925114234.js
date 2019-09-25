/**
 * 내부 함수
 * 
 * - 함수 안에 선언된 함수
 * - 내부함수의 호출은 자신이 선언된 함수에서만 가능
 * 
 */

 function outerFn(){
     console.log("outerFn");
     function innerFn() { //내부함수
        console.log("innerFn");
       }
     innerFn();
 }
  outerFn();