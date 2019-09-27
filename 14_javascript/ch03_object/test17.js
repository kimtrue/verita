//화살표함수는 아규먼츠라는 프로퍼티가 없어서 arguments를 사용하고 싶으면 화살표함수X
function f1(...arg) {
  console.log(arg);
}
f1(1, 2, 3);


//a=1, a=2, a=3
function fn2(a, b, c){
    console.log(a,b,c);
}
let arr = [1, 2, 3];
// fn2(arr[0], arr[1], arr[2]);
fn2(...arr);