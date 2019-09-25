/**
 * callback 함수
 * 
 *  - 함수도 값이다
 *  - 누군가한테 값을 주거나  받을 수 있다
 * 
 */


 function func() {
     console.log("func 호출됨");
 }
//  let f1 = func(); // 실행문. return 이 없어서 undefined
 let f1 = func; //f1의 type은 function
 let f2 = f1;//f2의 type은 function
 