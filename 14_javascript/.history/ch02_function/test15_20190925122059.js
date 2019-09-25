let arr = [1, 2, 3, 4, 5];
let sum = 0;
for(let i = 0; i < arr.length; i++){
    sum += arr[i];
}
console.log("합 : ", sum);


/** 콜백개념으로 바꿔보기 */
//배열과 콜백함수를 달라
function arrFor(arr, cb){

}
//위쪽에 선언된 arr 배열 들어가기.  cb =  function(){ }
arrFor(arr, function(){ });