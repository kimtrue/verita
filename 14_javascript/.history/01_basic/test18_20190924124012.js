/**
 * 자바스크립트 형변환 
 *  
 * Number(문자열 or true, false)
 * 문자열이 숫자형태일 경우 숫자 변환
 *  => 정확히 바뀔 수 있는 타입 숫자형태만 있을 때 바꿔준다.
 * 
 */

 console.log(true, Number(true)); //1
 console.log(false, Number(false)); //0
 
 console.log(true + 1); //묵시적 형변환 2
 console.log(true + false); //묵시적 형변환 1
 
 //문자열이 숫자형태일 경우 숫자 변환
 //=> 정확히 바뀔 수 있는 타입 숫자형태만 있을 때 바꿔준다.
 console.log("",Number("")); //숫자 0
 console.log(" ",Number(" ")); //숫자 0
 console.log("12",Number("12")); //숫자 12
 console.log("abc", Number("abc")); //NaN
 console.log("1000원", Number("1000원")); //NaN

 
 console.log("",Number("")); //숫자 0
 console.log(" ",Number(" ")); //숫자 0
 console.log("12",Number("12")); //숫자 12
 console.log("abc", Number("abc")); //NaN
 console.log("1000원", Number("1000원")); //NaN