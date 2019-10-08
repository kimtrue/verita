let html = ` <tr>
  				 <td colspan="9">
  				 <div class="paper">
 				  <!--윗단 주의사항-->
					<div class="paperdiv">
    				 <div>
    		   			 <h2> 좌석배치도</h2>
   			     	 </div>
     			 	<div class="noty">
                 	 <ul>
                    	 <li>좌석 1,2번은 교통약자 (장애인, 임산부, 노약자) 좌석입니다. </li>
                     	<li>교통약자를 위해 배려해주세요.</li>
                     	<li>선택하신 좌석은 실제 좌석과 상이 할 수 있습니다.</li>
                 	 </ul>
                	</div>

               <div class="hidden" >
               <INPUT TYPE="button" VALUE="△"  OnClick="doOpen()">  
             
               </div>
              </div>
                 <div class="seatbox"> 
                 <div class="seatline">
    				 <ul>
      				   <li>
     			        <h3>출입문</h3>
    				   </li>
       				  <li class="blank"></li>
   				      <li>앞</li>
         			  <li>　</li>
         			  <li><h4>운</h4></li>
         		      <li><h4>전</h4></li>
        			  <li><h4>자</h4></li>
                    </ul>
  				 </div>
  				 <!-- 체크박스 -->
  				 <div class="rpseat"></div>
  				 <div class="seatnoty">
                     <ul>
                         <li>
                            <img src="<c:url value="/img/선택불가.png" />" alt="이미 예매된 좌석">
                            <label for="choice">이미 예매된 좌석</label>
                         </li>
                         <li>
                            <img src="<c:url value="/img/선택가능.png" />" alt="예매 가능 좌석">
                            <label for="choice">예매 가능한 좌석</label>
                         </li>
                     </ul>
                     <hr width="200px" color="#cdcdcd">
                     <ul>
                         <li>
                             <p id="chkCnt">0개</p>
                         </li>
                     </ul>
                  </div>               
                  </div>
                  <!--밑단 유의사항-->
                  <div class="paperdiv">
                  <div>
                    <h2>유의사항</h2>
                    <br>
                  </div>
                  <div class="noty">
                      
                    <ul>
                        <li>예매가능 좌석이 "<strong class="point1">0</strong>" 인 경우 예매가 불가합니다.</li>
                        <li>예매(또는 취소)단계에서 회선장애나 기타 통신장애 발생 시 예매(취소)여부를 조회를 통해 반드시 직접 확인하셔야 하며, <br>확인하시지 않으신 경우에 부도위약금이 청구될 수 있으니 유의하시기 바랍니다.</li>
                        <li>소요시간은 도로 및 버스회사의 사정에 따라 변경될 수 있습니다.</li>
                        <li>미 예매 상태이며 예매시 선택하셨던 좌석은 최소 <strong class="point1">20</strong>분간은 선택 할 수 없습니다.</li>
                        <li>예매을 하실려면 다른 좌석으로 선택 또는 최소 <strong class="point1">20</strong>분 후에 좌석을 선택하시면 됩니다.</li>
                    </ul>
                  </div>
                  </div>
               
                  </div>
                      </td>
                           
                 </tr>
                  `
	
	let rsvList = document.querySelector("#rsvlist");
    let openseat = document.querySelector(".openseat");
    openseat.addEventListener("click", () => {
    	rsvList.innerHTML += html;
    	console.log(rsvList.innerHTML);
    	ss();
    });
    
    function ss() {
    	let grade =  document.querySelector(".grade");
    	if(grade.innerText === "우등") {
  	    	reseat(7,5,2,6,"upperbus","width: 70px");
   		} else {
   			reseat(8,6,3,7,"formerbus", "width: 58px");
   		   }
    };


// 좌석 for문 함수
     function reseat(a,b,c,d,cl,wid){ 
         let reSeatEle = document.querySelector(".rpseat");
     	let html = "";
       	let sCnt = 1;
         for(let j = 1; j < a; j++){
         	html += `<div class="seatline" style="`+wid+`" ><ul>`;
         	for(let i = 1; i < b; i++){
         		if(i == c && j != d) {
         			html += `<li class="blank"></li>`;
         		} else {
         			console.log(sCnt);
         			html += `<li><input type="checkbox" id=`+sCnt+` name="chk" value=`+sCnt+` class="`+cl+`" onclick="check(this,check_q1(this),2);">`
         			        +`<label for=`+ sCnt +`>`+sCnt+`</label></li>`;
         			    sCnt += 1;         			
          		}
         	}
         	
         html += `</ul></div>`; 
         }
         reSeatEle.innerHTML = html;  
         seatchk();
     }



      //체크박스의 카운트를 하기위한 함수 호출
     function seatchk() {
     	let box = document.getElementsByName("chk");
     	for (let i = 0; i < box.length; i++){
     		box[i].addEventListener("change",checkboxCount);
     	}
     	
     }   

     let d = 0;
     let chkcount = 0;
      function checkboxCount(){
    	let box = document.getElementsByName("chk");
        let c = document.querySelector("#chkCnt");
        c.innerText = 0;
        for(let i=0 ; i < box.length; i++) {
        	if(box[i].checked == true) {
        		c.innerText = parseInt(c.innerText)+1+"개";
        	}
        	else {
        		c.innerText = 0+"개";
        	}
        }
        		
      }
      
      
      function check_q1(chk_obj) {
    	  if(chk_obj.checked == true) {
    		  chkcount++;
    	  } else {
    		  chkcount--;
    	  	}
    	  if(chkcount <= 2) {
    		  return true;
    	  } else {
    		  chkcount--;
    		  return false;
    	  	}
      }
      
      function check(obj,condition, n) {
    	  console.log(condition);
    	  if(condition == false){
          obj.checked = false;
          alert(n + "개를 초과 선택 불가합니다");
    	  }
      }
      	
	
	
	
	
	
	
	