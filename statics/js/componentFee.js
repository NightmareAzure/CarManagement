$(document).ready(function () {
	$("#usedFee").click(function () {
		$("#toUse").hide();
		$("#used").show(1);
		
	});
	$("#toUseFee").click(function () {
		$("#used").hide();
		$("#toUse").show(1);
		
	});
	
});