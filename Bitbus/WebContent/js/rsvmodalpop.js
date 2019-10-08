    //모달창 안에 넣을 내용
     let list =  `<div class="modal-content">
                      <span class="close">&times;</span>                                                               
                      <div class="yoguem">
                            <div> 
                               <h1>요금조회</h1>
                               <hr />
                            </div>
                            <div class="modalT1">
                                <table>
                                    <tr>
                                        <th>구분</th>
                                        <th>성인</th>
                                        <th>아동</th>
                                    </tr>
                                    <tr>
                                        <td>일반</td>
                                        <td>13,800 원</td>
                                        <td>6,900원</td>
                                    </tr>
                    
                             </table>
                            </div>
                            <div class="modalT2">
                                <table>
                                    <tr>
                                        <th>거리</th>
                                        <th>예상 소요시간</th>
                                        <th>상세노선</th>
                                    </tr>
                                    <tr>
                                        <td>201 km</td>
                                        <td>160 분</td>
                                        <td>고양 -> 강촌</td>
                                    </tr>
                    
                             </table>
                            </div>
                            <div class="noty">
                                <ul>
                                    <li>만 6세 이상 ~ 만 13세 미만(초등학생 아동) : 50% 할인 (일부 터미널 제외)</li>
                                    <li>만 6세 미만의 아동 : 무임(단 만 6세 이하의 아동이라도 좌석을 요구할 경우 50% 할인요금의 승차권 구입후 승차)</li>
                                    <li>소요시간은 도로 및 버스회사의 사정에 따라 변경될 수 있습니다.</li>
                                </ul>
                    
                            </div>
                    
                      </div>
                    </div>           
    `


     // 내용 넣을 모달div 갖고오기
     let modalpop = document.querySelector("#myModal");
     modalpop.innerHTML += list;
  
    //jsp 상세보기 눌렀을 때 처리. 
    let btn1 = document.querySelector("#de1");
//    let btn2 = document.querySelector("#de2");
    btn1.addEventListener("click", () => {modalpop.style.display = 'block';});
//    btn2.addEventListener("click", () => {modalpop.style.display = 'block';});
        
    //모달창 닫기
    let span = document.getElementsByClassName("close")[0];   
    span.addEventListener("click", () => {modalpop.style.display = 'none';});
    
    
    
    
