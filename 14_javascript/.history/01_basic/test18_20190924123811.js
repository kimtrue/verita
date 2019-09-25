/**
 * 자바스크립트 형변환 
 *  
 * 
 * 
 * 
 */

 console.log(true, Number(true)); //1
 console.log(false, Number(false)); //0
 
 console.log(true + 1); //묵시적 형변환 2
 console.log(true + false); //묵시적 형변환 1
 
 //문자열이 숫자형태일 경우 숫자 변환
 console.log("",Number("")); //숫자 0
 console.log(" ",Number(" ")); //숫자 0
 console.log("12",Number(" ")); //숫자 0