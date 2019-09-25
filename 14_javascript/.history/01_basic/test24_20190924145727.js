/**
 * 간단한 조건 표현식 : 논리 연산자
 *  
 *  && : 참&&실행할 문장참일때 
 *       참일 경우 할 일을 준다.
 * 
 *  || : 앞의 조건이 거짓일 때 뒤의 실행문이 처리된다
 * 
 */


 let num = 9;
//  if(num % 2 == 0){
//      console.log("짝수이다")
//  }
( num % 2 == 0) && console.log("짝수이다");
console.log(num);

(num % 2 == 0) || console.log("홀수이다");

let msg; // undefined  => false
msg = msg || ''

