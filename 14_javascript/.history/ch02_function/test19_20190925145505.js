/**
 * 화살표 함수
 *  : 실행문장과 리턴
 * 
 */

let func1 = function(num) {
    return num * num;
};

console.log(func1(3));

// 화살표 함수
//return 문을 생략할 수 있다. 
// func1 = (num) => {num * num;};
// func1 = (num) => return num * num;  이것은 에러
//return 을 사용하고 싶으면 {return num * num}이라고 표현해야한다
// console.log(func1(3));

//블럭을 빼준다
func1 = (num) => num * num;
console.log(func1(3));