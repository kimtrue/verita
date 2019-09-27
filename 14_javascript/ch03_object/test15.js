/**
 * 스프레드를 연산자
 * 
 * 
 * -배열을 복사해보자
 */

 let arr1 = [1, 2, 3];
 //4, 5 추가해보자
 let arr2 = [...arr1, 4, 5];
//  console.log(arr1, arr2); 

 //concat 원본배열을 건들이지 않으면서 새로운 배열을 만들어준다
 let arr3 = arr1.concat(4, 5);
//  console.log(arr1, arr3);
 
 let arr4 = [arr1, arr1];
 console.log(arr4); //[ [ 1, 2, 3 ], [ 1, 2, 3 ] ]

 let arr5 = [...arr1, ...arr1];
 console.log(arr5);//[ 1, 2, 3, 1, 2, 3 ]
 