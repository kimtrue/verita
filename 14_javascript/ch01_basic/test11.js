/**
 * 변수의 범위
 * 
 * -var로 선언된 변수 :
 *   글로벌 변수(전체에서 사용하는 변수)
 *   선언된 블록에 제한을 받지 않는다
 * 
 */

 var msg = "1";
 if(msg == "1") {
     var msg = "2";
     console.log(msg);
 }
 console.log(msg);
 {
     var msg2 = "3";
 }
 console.log(msg2);


 /**
  * 호이스팅 
  * <1단계>
  * var msg;
  * var msg2;
  * 
  * <2단계>
  * msg = "1"
  * if (msg == "1") {
  *   msg = "2"
  *   console.log(msg); 2
  * }
  * console.log(msg) 2
  * 
  * {
  *  msg2 = "3";
  * }
  * console.log(msg2); 3
  * 
  * 
  */