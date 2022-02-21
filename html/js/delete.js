function checkAll(allInput){
	var checked = allInput.checked;
	var inputs = document.getElementsByTagName("input");
	for(var i = 0; i < inputs.length; i++){
		if(inputs[i].name == 'delete'){
			inputs[i].checked = checked;
		}
	}
}
function checkPart(allInput){
	var checked = allInput.checked;
	var inputs = document.getElementsByTagName("input");
	for(var i = 0; i < inputs.length; i++){
		if(inputs[i].name == 'deletePart'){
			inputs[i].checked = checked;
		}
	}
}
function checkServiceMan(allInput){
	var checked = allInput.checked;
	var inputs = document.getElementsByTagName("input");
	for(var i = 0; i < inputs.length; i++){
		if(inputs[i].name == 'deleteServiceMan'){
			inputs[i].checked = checked;
		}
	}
}
function AddPart(allInput){
	var checked = allInput.checked;
	var inputs = document.getElementsByTagName("input");
	for(var i = 0; i < inputs.length; i++){
		if(inputs[i].name == 'addPart'){
			inputs[i].checked = checked;
		}
	}
}
function AddServiceMan(allInput){
	var checked = allInput.checked;
	var inputs = document.getElementsByTagName("input");
	for(var i = 0; i < inputs.length; i++){
		if(inputs[i].name == 'addServiceMan'){
			inputs[i].checked = checked;
		}
	}
}