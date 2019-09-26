/**
 * 클로저2
 * 
 * 하나의 함수에 하나를 위한 메모리 생성.
 * id1 호출
 * id2 호출 했을 시, id1을 위한 컨텍스트 하나 생성, id2를 위한 컨텍스트 하나 생성 
 * 
 * 
 */

 function nextId(){
     let id = 1;
     return function(){ return id++; };
 }

 let id1 = nextId();
 console.log(id1());//1
 console.log(id1());//2
 console.log(id1());//3

 let id2 = nextId();
 console.log(id2());//1
 console.log(id2());//2
 console.log(id2());//3