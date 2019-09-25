/**
 * 콜백함수
 * 
 * - 함수를 결과로 넘겨주기..
 * 
 */



 function func() {
    function cb() {
        console.log("리턴된 함수 실행");
    }
    return cb; //함수 실행이 아닌 함수 주소만 넘겨줬다
 }
 
 
 function func() {
    return function () {
        console.log("리턴된 함수 실행");
    }
    return cb; //함수 실행이 아닌 함수 주소만 넘겨줬다
 }






 /*
 function func() {
    //함수의 주소를 넘겨줬다
    // return cb(); undefined 
    return cb; //함수 실행이 아닌 함수 주소만 넘겨줬다
 }
 function cb() {
     console.log("리턴된 함수 실행");
 }
*/
 console.log(func()); // 왜 실행이 안되는건지... 모르겠다...  // 주소값나온다 
 let myCb = func();
 console.log("myCb : " , myCb); //주소값만 넘겨받음
 myCb(); //리턴된 함수 실행
 