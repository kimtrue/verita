let arr = [1, 2, 3, 4, 5];
let sum = 0;
for(let i = 0; i < arr.length; i++){
    sum += arr[i];
}
console.log("합 : ", sum);


/** 콜백개념으로 바꿔보기 */
//배열과 콜백함수를 달라
function arrFor(arr, cb){
    for(let i = 0; i < arr.length; i++){
        cb(arr[i], i); //function(){} 를 for문만큼 돌린다
    }

}
sum = 0;
//위쪽에 선언된 arr 배열 들어가기.  cb =  function(){ } val. arr[i] 값이 들어온다
arrFor(arr, function(val){ sum += val; } );


//arr 배열에서 짝수번째 (0, 2, 4) 인덱스의 요소의 합을 출력
