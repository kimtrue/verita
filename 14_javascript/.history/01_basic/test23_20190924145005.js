/**
 * 배열에 데이터 추가하기, 삭제하기
 * 
 * 
 * 
 */

 let arr = [10, 20, 30];
 
 //마지막에 배열에 데이터 추가하기
//  arr[3] = 40; //하드코딩
 arr[arr.length] = 40;
console.log(arr);

arr.push(50);
console.log(arr);

//arr의 주소를 arr2에게 줬다
let arr2 = arr;
console.log(arr2);

// 같이 값이 넣어졌다
arr2.push(60); 
console.log(arr2);
console.log(arr);

//데이터 삭제하기
arr.splice