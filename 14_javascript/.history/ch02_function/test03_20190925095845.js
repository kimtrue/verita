/**
 * 익명함수
 * 
 * - 함수의 이름이 없다.
 * - 이름이 없는데 어떻게 호출할까??
 *    => 변수에 담아서 사용한다
 * - 함수를 변수에 담아서 사용 : 
 *    함수는 일급객체이기 때문에 가능 => 일급객체 : 기능을 가지고 있는 객체
 * 
 * 변수 = function(매개변수) {
 *            해야할 일 정의
 *            줄게 있으면 선택적 return
 *        }
 * 
 * => 이름이 없다
 * 
 * - 함수도 하나의 값이기 때문에 변수에 담을 수 있다
 *
 * - 익명함수는 호이스팅이 되지 않는다.
 * 
 * 
 * 
 */


let func1 = function(){
        console.log("이름없는 함수");
     }