function percentagecheck(){
	var y=document.getElementById("perc").value;
	
	console.log("hai"+y);
	if(y<15){
		alert("Your medicine quantity is very low");
		return false;
	}
	else{
		return true;
	}
}