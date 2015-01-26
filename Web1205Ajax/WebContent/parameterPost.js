var xhrObject; 

Event.observe( window, "load", function(){ 
    startMethod();
  }
);

function createXHR(){ 
	  if(window.ActiveXObject){  
	     xhrObject = new ActiveXObject("Microsoft.XMLHTTP"); 
	  }else if(window.XMLHttpRequest){ 
         xhrObject = new XMLHttpRequest(); 
	  }
}

function getParameterValues(){
	var sabun = $("sabun").value;   // <input type=Text  name=pay >  pay=폼이름.pay.value 
	var name = $("name").value; 
    var pay = $("pay").value;  
	return   "sabun=" + sabun + "&name=" + name + "&pay=" + pay ; //요청파라미터를 설정해서 리턴
}


function startMethod(){
      Event.observe( "postSend", "click", 
		  function(){
	        createXHR(); 

	        //	var url = "http://127.0.0.1:8080/ajaxTest/ParameterPost" ;
			//var url = "http://127.0.0.1:9000/ajaxOne/ParameterPost" ; 
		 	//get방식입니다 var url = "http://127.0.0.1:9000/ajaxOne/ParameterGet?" + getParameterValues() ;
			var url ="http://localhost:8080/Web0307/ParameterPost"

			var queryStr = getParameterValues();
	        xhrObject.onreadystatechange = resultProcess;  
            xhrObject.open("Post", url, "true");
			xhrObject.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	        xhrObject.send(queryStr);
	  });
}

function resultProcess(){
	  if(xhrObject.readyState == 4){ 
	    if(xhrObject.status == 200){ 
		  $("resultDisplay").innerHTML = xhrObject.responseText; 
		}
	  }
}







