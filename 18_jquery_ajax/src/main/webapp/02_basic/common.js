$(document)
.ajaxStart(() => {
	$("body").waitMe({
		effect:'bounce',
		text:'처리중',
		bg:'rgba(255,255,255,0.7)',
		color:'#000'
	});
})
.ajaxStop(() => {$("body").waitMe("hide");});