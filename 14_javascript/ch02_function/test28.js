function doAction(){
    // alert("클릭");
    //클릭을 누르면 id가 result 인 
    // let msg = document.querySelector("#result");
    // msg.innerHTML = "클릭";
    
    //클릭을 누를 때 class가 food인 
    let pEle = document.querySelectorAll(".food");
    
    let ele = document.querySelector("#result");
    // msg.innerHTML = "클릭"; 한개만 주는 것
     

    //반복돌면서 엘리먼트 하나씩 나오게하기
    let msg = "전체 : " + pEle.length + "개<br />";
    for(let i = 0; i < pEle.length ; i++){
             msg += pEle[i].innerHTML + " "; 
    }
    ele.innerHTML = msg;

}

function doClear(){
    // alert("지우기");
    let msg = document.querySelector("#result");
    msg.innerHTML = "";
}