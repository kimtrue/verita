/**
 * 클로저
 * 
 * - 함수내의 지역변수를 함수 외부에서 사용할 수 있게 기술
 * - 생명주기가 종료된 함수의 변수를 참조하는 기술
 * 
 * 콜백함수가 넘어 왔는데 콜백함수를 참조해서 ..
 * 
 */

 //msg outer함수 안에서 선언되었다.
 //지역변수 msg를 참고하고 있다
function outer(val){
     let msg = "당신의 메세지 : " + val;
     return function(){ return msg; };
}
//      val = 안녕좋은아침이야
let fn = outer("안녕 좋은 아침이야");
console.log(fn());