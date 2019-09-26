const singers = [
    '런쥔', '제노', '해찬', '재민', '천러', '지성', '마크', '루카스', '재현', '쿤'
];

let count = 10;

//배열에서 사람 한명뽑는

//setInterval(기능 , 시간)   기능을 시간동안 계속해주기
//setInterval을 통해 1초동안 계속 호출을 해주는데 , 
let id = setInterval ( () => { 
    if(count == 0){
        console.log(singers[parseInt(Math.random() * singers.length)]);
        clearInterval(id);
        return;
    } 
    console.log(count--);

}, 1000);

