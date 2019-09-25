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


function filter(){
    
}

