$(document).ready(function () {
	$("#Sinput").click(function () {
		$(" #ClientRegister").hide();
		$(" #serviceManRegister").show(1);
		$(" #serviceManRegister").css("left","400px");
		$(" #serviceManRegister").css("top","652px");
		$(" #serviceManRegister").css("left","550px");
		$(" #serviceManRegister").css("top","652px");
	});
	$("#Cinput").click(function () {
		$(" #ClientRegister").show(1);
		$(" #serviceManRegister").hide();
		$(" #ClientRegister").css("left","400px");
		$(" #ClientRegister").css("top","652px");
		$(" #ClientRegister").css("left","550px");
		$(" #ClientRegister").css("top","652px");
		
		
	});
	
});
