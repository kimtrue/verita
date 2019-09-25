/**
 * 
 * ES6 - 화살표 함수 (자바의 람다와 유사)
 * 
 * - 함수를 심플하게 정의 할 수 있다.
 * 
 * <형태>
 * function(매개변수) {실행할 내용;}
 * (매개변수) => {실행할 내용;}
 * 
 * 
 */

 let func1 = function(){
     console.log("익명함수1");
};

func1();

//function이 삭제됨
func1 = () => {
    console.log("화살표 함수");
};
func1();

let func2 = function (num) {
    console.log("익명함수2 : ", num);
};

func2(1);

//매개변수가 하나인 경우 : 매개변수의 소괄호 생략 가능함
func2 = num => {
   console.log("화살표함수2 : ", num)
}
func2(3);
// func2 = (num) => {
//    console.log("화살표함수2 : ", num)
// }
// func2(5);


//매개변수가 여러개인것
let func3 = function (num1, num2) {
    console.log("익명함수3 : " , num1, num2);
};

func3(10, 20);


func3 = (num1, num2) => {
    console.log("화살표함수3 : ", num1, num2);
};