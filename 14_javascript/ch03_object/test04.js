/**
 * this 는 자바스크립트에서 다양하게 해석
 * 
 * you don't know js
 * 
 * 객체에서의 함수 this는 호출한 객체
 * 
 */

//  "use strict";
 let m1 = {name: "정재현"};
 let m2 = {name: "markLee"};

 function msg(){
     console.log(this.name);
 }
// msg();

//msg 를 추가했다
//함수에 대한 참조 주소값을 넣었다
m1.msg = msg;
m2.msg = msg;

//m1 실행
//이 때 this는 m1
m1.msg();
m2.msg();


