/**
 * **콜백함수 사용하기**
 * - 매개변수 넘기기
 * 
 * 
 */

 //cb는 myCall function이 되는 것
 function func(cb){
     console.log(typeof (cb));
     return cb = 1;

 }
 function myCall() {

 }
 func(myCall()); // cb의 undefined가 넘어간다. 함수의 실행결과. return이 없다
 func(myCall); // cb는 function

