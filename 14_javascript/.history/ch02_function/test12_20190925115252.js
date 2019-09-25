/**
 * **콜백함수 사용하기**
 * - 매개변수 넘기기
 * 
 * 
 */

 //cb는 myCall function이 되는 것
 function func(cb){
     console.log(typeof (cb));

 }
 function myCall() {

 }
 func(myCall()); // cb의 undefined가 넘어간다
 func(myCall); // cb는 function

