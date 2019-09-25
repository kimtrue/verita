let data = [3, 9, 27, 80, 43];

//data배열에서 특정조건(30보다 작은) 을 만족하는 데이터를 새로운 배열을 생성해서 담고싶다.
//새로운 배열을 하나 만든다
let newData = [] ;
for(let i = 0; i < data.length; i++){
    if(data[i] < 30) {
        newData.push(data[i]);
    }
}
console.log(newData);

//data배열에서 특정조건(짝수) 을 만족하는 데이터를 새로운 배열을 생성해서 담고싶다.
let newData2 = [] ;
for(let i = 0; i < data.length; i++){
    if(data[i] % 2 == 0) {
        newData2.push(data[i]);
    }
}
//
console.log(newData2);



//같은 로직인데 조건만 다르다면 callBack으로 바꿔보자..
function filter(arr, cb) { //새로운 배열을 만들어서 넘겨주는 작업
    let data = [];
    //배열을 돌면서
    for(let i = 0; i < arr.length ; i++){
        //i번째 받아온 데이터를 data에 .push를 할지 부르는 쪽에서 해줘야한다
        //조건에 대한 것은 cb에 있다 결정을 cb
        // 콜백에 arr[i] 를 줬다
        //콜백의 arr[i]가 true 면..
        if(cb(arr[i])) {
            data.push(arr[i])
        }
        // data.push(arr[i]);
    }
    return data;
}


let result = filter(data, function(val) {
 //data배열에서 30보다 작은 것만 갖고싶다
//  console.log(val);
    if(val < 30) return true;
    return false;
    //콜백함수가 true false를 준다.
});

console.log("result : ", result);

result = data.filter(function (val) {
    //데이터 배열의 요소가 짝수일 때
    if(val % 2 == 0) return true;
    //짝수가 아니면 false
    return false;

} );

console.log("짝수 : ", result);