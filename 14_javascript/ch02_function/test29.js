function doAction(){
    let ele = document.querySelector("#count");
    let sum = 0;

    ele.innerHTML = ele.innerHTML || 0;
    ele.innerHTML = parseInt(ele.innerHTML)+1;
}
function doClick(){
   result.innerText = Number(result.innerText) +1;
}

function doStart(){
    let result = document.querySelector("#result");
    setTimeout(function() {
        document.querySelector("#view").innerText = `${result.innerText}회 클릭하였습니다`;
    }, 3000);
    
}

