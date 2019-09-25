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
 let arr = [10, 20];
 
 for(let i = 0; i < arr.length; i++) {
     console.log("i : ", arr[i]);
 }

 //향상된 포문for(int i : arr)
 for (let val of arr) {
     console.log("val : ", val);

 }


 //forEach
 //arr.forEach(배열을 갖고 해야할 일을 준다.) 
 //callbackfn 펑션, 
 //function() => 배열의 길이만큼 돈다 
 //function(val) console.log(val) 값을 차례대로 찍는다
 //arr.forEach(function(val, i)) 인덱스와 값을 준다
 //arr.forEach(function(val, i, array) 인덱스, 값, 배열을 준다
 arr.forEach(function(val, i, array){
     console.log(i ,val, array);
 });
 let sum = 0;
 arr.forEach(function(val){
     sum += val;
     console.log(sum);
 });

 let sum = 0;
 arr.forEach(function(val){
     if(val % 2 == 0){
         console.log(val);
     }
 });

 //index가 홀수번째 인 것을 찍고 싶을 때
 arr.forEach(function(val, i){
    if(val % 2 == 0){
        console.log(val);
    }
});

 