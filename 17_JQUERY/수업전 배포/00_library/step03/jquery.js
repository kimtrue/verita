let $ = mlec;

function mlec(val){
    let elements = [];
    for(let el of document.querySelectorAll(val)){
        elements.push(el);
    }

    elements.text = function(text) {
     //값이 없을때 추출시키기
      if(text !== undefined){
          for(let el of this){
              el.innerText = text;
            }
            return this;
        }
        //text 매개변수가 없는 경우 result 를 넘겨준다
        let result = "";
        for(let el of this){
            result += el.innerText + "\n";
        }
        return result;
    };
    return elements;
}