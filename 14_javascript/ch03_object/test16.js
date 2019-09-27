/**
 * ES6 부터 추가된 연산자
 * 
 * rest 연산자
 * 객체나 배열의 값을 손쉽게 받는다.
 * 
 */

 let member = {
     id: "a",
     name: "b",
     age: 28
 };

 //뒤에 어떤 객체가 있는지 모를때 어딘가에 담고싶다..
 //id를 받는데 나머지를 user가 다 받아준다 
 //user를 찍으면 id를 제외한 값이 객체형태로 나온다
 let {id, ...user} = member;
console.log(id, user);

let arr1 = [1, 2, 3, 4, 5]
let [a, b, ...c] = arr1; // a = 1, b = 2  c = [3, 4, 5]
console.log(a, b, c);
