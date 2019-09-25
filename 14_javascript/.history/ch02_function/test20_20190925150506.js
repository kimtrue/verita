/**
 * 화살표 함수를 사용하는데 해석이 어려운 경우
 * 
 */

 let fn = function() {
     return function() {
         console.log("호출됨.."); 
     };
 };

 fn()();

 //화살표 함수로 바꾸자. 
 let fn2 = () => () => { console.log("호출됨..");};

fn2()();