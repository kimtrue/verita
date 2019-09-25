/**
 * 배열
 * 생성하는 방법 :
 *  - []
 *  - Array()
 */


 let arr1 = []; //크기가 0인 배열
 let arr2 = new Array(); //크기가 0인 배열

 console.log("arr1.length : ", arr1.length);
 console.log("arr2.length : ", arr2.length);
 //index가 0번째 찍기
 console.log(arr1[0], arr2[0]); //undefined
 
 //자바스크립트의 배열의 크기는 마지막 인덱스 번호(가장 큰 번호) + 1 이다.
 //동적으로 값 넣어주기
 arr1[0] = 10;
 arr1[1] = 20;
 arr1[3] = 30;
 console.log("arr1.length : ", arr1.length); //4

 arr1["id"]