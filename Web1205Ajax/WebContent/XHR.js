function createRequest2(){
	var request;
	try{
	request = new XMLHttpRequest();
	}catch (e) {
		// TODO: handle exception
		try{
		request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (e) {
			// TODO: handle exception
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return request;
	
}