/**
 * ES6 추가
 * Destructuring : 비구조할당
 *
 * - 객체나 배열에 입력된 값을 변수에 할당하는 간편 방식 제공 
 */
//배열을 먼저 살펴보자

let arr1 = [1, 2, 3];
//a에 1을 넣고싶다.
let a = arr1[0];
let b = arr1[1];
let c = arr1[2];
console.log(a, b, c);

let arr2 = [10, 20, 30];
//a1 에 10, b1에 20 c1 에 30

let [a1, b1, c1] = arr2;
console.log(a1, b1, c1);

// let [a1, b1, c1] 중복선언한다는 뜻

//크기가 맞지 않아도 변수가 대입된다
[a1, b1, c1] = [100, 200];
console.log(a1, b1, c1); //100, 200, undefined

[a1, b1, c1] = [1000, 2000, 3000];
console.log(a1, b1); //1000, 2000


//없을때는 0을 넣으라는 초기값(디폴트값) 설정 
[a1, b1, c1 = 0] = [10000, 20000];
console.log(a1, b1, c1); //1000, 2000

 