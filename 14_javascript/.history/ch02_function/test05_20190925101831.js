/**
 * 함수의 매개변수
 * - 함수는 호출 시 매개변수의 영향을 받지 않는다.
 * - arguments : 함수의 내부에 선언되어있는 프로퍼티를 통해 매개 변수의 정보를 갖고 올 수 있다.
 *               함수안에서 선언없이 사용할 수 있다
 */

 function func1(num){
     console.log("func1 : ", num);
}

 func1(); 
 func1(10);
 func1(10, 10);