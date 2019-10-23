let $ = mlec;

function mlec(val){
    let elements = [];
    //val 이 "<" 로 시작하는 경우는 태그 생성
    switch(val.charAt(0)){
        case "<": 
             //< ,  > 빼고 자르기  document.createElement("h2");
            elements[0] = document.createElement(val.substring(1, val.length - 1));
             break;
        default: 
           for(let el of document.querySelectorAll(val)){
               elements.push(el);
            }
    }

 /*
  [div, div]
  [<h2>, </h2>]
 */
    elements.append = function (childs){
        for(let el of this){
            for(let child of childs) {
                // el.append(child)
                el.append(child.cloneNode(true));
            }
        }
        return this;
    }

    //innerHTML
    elements.html = function(html) {
        //this는 html 객체를 부른 애 . bDiv.. 

      //값이 없을때 추출시키기
      if(html !== undefined){
          for(let el of this){
              el.innerHTML = html;
            }
          return this;
        }
        return this[0].innerHTML;  

    };


    //innerText
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

    elements.val = function(text) {
     //값이 없을때 추출시키기
      if(text !== undefined){
          for(let el of this){
              el.value = text;
            }
            return this;
        }
        return this[0].value;
    };


    elements.on = function (evenetType, listener) {
        for(let el of this){
            el.addEventListener(evenetType, listener);
        }
        return this;
    };
  
        
        elements.click = function (listener) {
            return this.on("click", listener);
        };
           
        elements.mousemove = function (listener) {
            return this.on("mousemove", listener);
        };


        /*

                            //속성의 이름, 밸류값
        elements.attr = function (name, value) {
            for(let el of this){
                el.setAttribute(name, value);
            }
            return this;
        }
        */


       //객체 받기
       elements.attr = function (name, value) {
        // $("div").attr({"data-msg": "테스트","data-id": "b17"});


           if(typeof (name) === "object"){
               //반복문 안에 반복문. el = $("div) 가 몇 개있는지모르기때문
               for(let el of this){
                   for(let key in name){
                    //    name["data-msg"] -> value 가져오기
                       el.setAttribute(key, name[key])
                   }
                }
                return this;
           }

           if(value !== undefined){
           //한개의 값만 넘어왔을 때
             for(let el of this){
                 el.setAttribute(name, value);
              }
              return this;
          }
          return this[0].getAttribute(name);
        }


        //css 추가하기
        /*
        elements.css = function (name, value) {
            for(let el of this){
                el.style[name] = value;
            }
            return this;
        };
        */
       
       elements.css = function (name, value) {
           if(typeof(name) === "object"){
               for(let el of this){
                   for(let key in name){
                       el.style[key] = name[key];
                    }
                }
                return this;
            }
            //설정이 없을 때
            if(value !== undefined){
                for(let el of this){
                    el.style[name] = value;
                }
                return this;
            }
            return this[0].style[name];
        };

    return elements;
       
}