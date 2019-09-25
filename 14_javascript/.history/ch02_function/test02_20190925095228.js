/**
 * 함수의 종류
 * < 선언적 함수 >
 * 
 * - 함수의 이름이 존재하는 것 (함수의 이름이 없을 수 있다)
 * - 컴파일 시점(호이스팅)에 함수의 정보가 등록(함수의 호이스팅)
 * - 선언된 위치에 상관없이 사용할 수 있다
 * - 함수가 별도의 return을 사용하지 않은 경우 기본적으로 반환되는 값은 : undefined
 * 
 */
//func1 > 함수의 이름. 선언적 함수
 function func1(num1, num2) {
    return num1 + num2; 
 }

 //선언적 함수 부르기
 let result = func1(10, 20);
 console.log(result);

 //선언전에 정보를 사용 할 수 있다
 //권장하지 않는다...
 result = func2();
 console.log(result);

 //호이스팅 과정에서 위로 올라간다
 function func2() {
     return "선언전에 사용";
}


 function func2() {
     return "선언전에 사용";
}