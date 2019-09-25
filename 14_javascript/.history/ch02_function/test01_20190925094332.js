/**
 * 함수, 메서드(객체에 포함되어 있을 때)
 *  
 * - 자바스크립트는 객체를 부르지 않고 사용 가능하다
 * 
 * - 반환타입이 없다. 
 * 
 *  function 함수이름(매개변수){
 *    실행코드
 * }
 * 
 * 함수를 부를 때 :
 *  함수이름(값...)
 * 
 * 함수선언 방식에 대해 살펴보자
 */

 //파라미터, 반환타입 없는 경우
 function func1() {
     console.log("func1");
 }

 func1();

 //파라미터가 없고 반환값이 없는 경우
// 자바와 차이점 : 함수이름앞에 반환값에 대한 타입을 명시하지 않는다
function func2() {
    console.log("func2");
    return "반환-2";
}
//반환한(return) 한 것을 받고 싶으면 변수선언
let result = func2();
console.log(result);


//파라미터가 있고 반환값이 없는 경우
function func3(val){

}