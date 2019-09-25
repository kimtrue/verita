/**
 * 콜백함수
 * 
 * - 함수를 결과로 넘겨주기..
 * 
 */

 function func() {
    //함수의 주소를 넘겨줬다
    //return cb(); undefined 
    return cb;
 }
 function cb() {
     console.log("리턴된 함수 실행");
 }
 let myCb = func();
 console.log("myCb : " , myCb);