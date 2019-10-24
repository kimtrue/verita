let $ = mlec;

function mlec(val){
    if(typeof(val) === "function"){
        window.onload = val;

        return;
    }


    let elements = [];
    //객체타입인지 알아야 한다 
    //instanceof = true val이 누구의 자식인지 알 수 있다
    //만약 val 이 HTMLElement의 자식이면
    if (val instanceof HTMLElement){
        elements[0] = val;
    } else {
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

    }


elements.prop = function (name, value) {
    if(value !== undefined){
        for(let el of this){
            el[name] = value;
        }
        return this;
    }
    return this[0][name];
};   

    

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
    };

    
    //지우기
    elements.remove = function () {
        for(let el of this){
            el.remove();
        }
    };

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




      elements.addClass = function (name) {
          for(let el of this){
              el.classList.add(name);
          }
          return this;
        };
        elements.removeClass = function (name) {
            for(let el of this){
                    el.classList.remove(name);
            }
            return this;
          
      };
      elements.toggleClass = function (name) {
        for(let el of this){
            el.classList.toggle(name);
         }
        return this;
  
      };

       
    return elements;
       
}


//Ajax 파트 추가
$.ajax = function (options) {
//	console.dir(options)
	
	let xhr = new XMLHttpRequest();
	  xhr.onreadystatechange = function () {
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				let result = xhr.responseText;
//				  JSON.parse(xhr.responseText)
//				  $("#result").html(xhr.responseText);
				if(options.dataType === "json")result = JSON.parse(result);
				
				options.success(result);
				
			}
		}
	};
	//options.type 이 존재하면 있는 값을 사용하고 없으면 GET을 사용하라
	//앞에서 type을 주지 않으면 GET으로 넘기겠다
	let method = options.type ? options.type : "GET";
	//오타가 날 경우도  GET으로 넘기자
	if(method !== "GET" && method !== "POST") method = "GET";
	
	//options.data가 있다면 = 파라미터가 존재
	/*
	 * 넘겨줄 때 data 즉, 파라미터가 여러개라면(객체) 일 때 
	 */
	let params = "";
	if(options.data){
		if(typeof (options.data) === "string"){
			params = options.data;
		} else { //객체라면
			//{no: 1, msg: 'hi'} no=1&msg=hi
			for (let key in options.data){
				if(params !== "") params += "&";
				params += key + "=" + options.data[key];
			}
		}
	}
	
	
	
	
	  let url = options.url;
	  							//파라미터의 값이 존재할 때
		if (method === "GET" && params !== "") {
			url += "?" + params;
		}
			xhr.open(method, url, true);
			
		if 	(method === "POST"){
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
		}
		
		xhr.send(method ==="POST" ? params : null);
			
};
		
		
		

	
	