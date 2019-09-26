/**
 * 객체는 연관된 데이터를 묶어서 관리한다.
 * 
 */

let member = {
    id: "mark",
    name: "이마크",
    setId: function(id){ 
        this.id = id;
    },
    getId:function () {
        return this.id;
    }
}

console.log(member.id, member.getId());