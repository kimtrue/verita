/**
 * **콜백함수 사용하기**
 * - 매개변수 넘기기
 * 
 * 
 */

 //익명함수 사용
 function func(cb){
     console.log(typeof (cb));
     cb();
 }
 func(function () {
     console.log("myCall 호출됨");
     }
     );

/*
 function func(cb){
    console.log(typeof (cb));
    cb();
}
function myCall() {
    console.log("myCall 호출됨");

}
//  func(myCall()); // cb의 undefined가 넘어간다. 함수의 실행결과. return이 없다
func(myCall); // cb는 function
*/

