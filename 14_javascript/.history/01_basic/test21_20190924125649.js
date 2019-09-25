/**
 * 배열의 반복문
 * 배열 선언
 * 
 *  범위지정사용
 *    let arr = [val1, val2, val3...];
 *    java의 arrayList와 비슷하다
 * 
 *  향상된 for문
 *  for(let i of arr) { } => index값이 없다
 *  객체의 값
 * 
 * 
 *  foreach for문 
 *  
 */
//java의 arrayList와 비슷
 let arr = [10, 20, 30, 40, 50];
 
 for(let i = 0; i < arr.length; i++) {
     console.log("i : ", arr[i]);
 }

 //향상된 포문for(int i : arr)
 for (let val of arr) {
     console.log("val : ", val);

 }