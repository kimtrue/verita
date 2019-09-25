/**
 * 함수의 매개변수
 * - 함수는 호출 시 매개변수의 영향을 받지 않는다.
 * - arguments : 함수의 내부에 선언되어있는 프로퍼티를 통해 매개 변수의 정보를 갖고 올 수 있다.
 *               함수안에서 선언없이 사용할 수 있다. 자체 변수. 
 *               유사배열 객체. 배열은 아닌데 배열처럼 사용할 수 있게 length property를 추가한 것
 *
 * - 유사배열 객체 : 객체인데, 객체 내부의 length 프로퍼티를 가지고 있는 객체               
 * 
 */



 function func1(num){
     0: 'a';
     1: 'a';
}
 function func1(num){
     console.log("func1 : ", num);
     console.log("arguments : ", arguments.length); //0, 1, 2
}

 func1(); 
 func1(10);
 //매개변수가 하나임에도 불구하고 호출이 된다 앞에서부터
 func1(10, 10);

