var xhrObject; //XMLHttpRequest

function createXHR(){ //XMLHttpRequest�
	  if(window.ActiveXObject){ 
	     xhrObject = new ActiveXObject("Microsoft.XMLHTTP"); 
	  }else if(window.XMLHttpRequest){ 
         xhrObject = new XMLHttpRequest(); 
	  }
} //end

function startMethod(){
	  createXHR(); 
	  xhrObject.onreadystatechange = resultProcess; 
      xhrObject.open("GET", "xhrTest.xml", "true"); 
	  xhrObject.send(null); 
} //end

function resultProcess(){
	  if(xhrObject.readyState == 4){ 
	    if(xhrObject.status == 200){ 
		  document.write("<h1>server content : "  + xhrObject.responseText +"</h1>" );  
		} //if end
	  } //if end
} //end