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
	var sabun = $("sabun").value;   // <input type=Text  name=pay >  pay=���̸�.pay.value 
	var name = $("name").value; 
    var pay = $("pay").value;  
	return   "sabun=" + sabun + "&name=" + name + "&pay=" + pay ; //��û�Ķ���͸� �����ؼ� ����
	//a href=regDetail.jsp?idx=LEE&juso=LA
}

function startMethod(){ //���ϸ��� �νĵ�  // prototype.js
      Event.observe( "getSend", "click",
		  function(){  //function  getSend( ) {  }
	        createXHR(); 

			//var url = "http://127.0.0.1:8080/ajaxTest/ParameterGet?" + getParameterValues() ; 
			//var url = "http://127.0.0.1:9000/ajaxOne/ParameterGet?" + getParameterValues() ; 
			var url ="http://localhost:8080/Web0307/ParameterGet?" +  getParameterValues() ;
				
	        xhrObject.onreadystatechange = resultProcess;  
            xhrObject.open("Get", url, "true");
	        xhrObject.send(null);
	  });
}

function resultProcess(){
	  if(xhrObject.readyState == 4){ 
	    if(xhrObject.status == 200){ 
		  $("resultDisplay").innerHTML = xhrObject.responseText; 
		} //if end
	  } //if end
} //end