/**
 * 디폴트 파라미터 
 * ES6 부터 추가되었다
 * 
 * 
 */

 function func(num1, num2){
     /*
     값이 없다면 undefined 로 나오니까
     num1이 false면 num1에 0을 대입
     if(!num1) num1 = 0; // undefined는 true false로 
     if(!num2) num2 = 0; // undefined는 true false로 
     */
    
    //논리연산자
    num1 = num1 || 0;
    num2 = num2 || 0;
     console.log(num1 + num2);
 }

 func(); //0
 func(100); // 100
 func(100, 200); //300



                //없으면 0을 주라는 default 설정
 function func2(num1 = 0, num2 = 0){
     console.log(num1 + num2);
 }

 func2(); //0
 func2(100); // 100
 func2(100, 200); //300