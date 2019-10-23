//플러그인 추가하기: $.기능
$.arr = function (obj, comm) {
    //결과를 반환할
    let result;
    if(comm === "max"){
        result = obj[0];
        for(let val of obj){
            if(result < val) result = val;
        }
    } else if(comm === "min"){
        result = obj[0];
        for(let val of obj){
            if(result > val) result = val;
        }

    }
    return result;    
};