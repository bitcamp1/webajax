 
 var xhr;
 
function makeRequest(url) {
    xhr = new XMLHttpRequest();
    xhr.onreadystatechange = RP;
    xhr.open('GET', url, true);
    xhr.send(null);
 } //end

  function RP( ) {
      if (xhr.readyState == 4) {
          if (xhr.status == 200) {
             viewData(xhr.responseXML);
          }
      }
 } //end
    
    function getData(){
     	makeRequest("data.xml")
    }//end
    
		/*
		    function viewData(xobj){
		     var itemsize = xobj.getElementsByTagName("item").length;
		     var obj = document.getElementById("tableObj");
		     var trObj = obj.firstChild.firstChild;
		     var cnt = 1;
		     document.testForm.test1.value = xobj.getElementsByTagName("item").length;
		     	if(itemsize != 0){
		   	    while(true){
			    var tr_obj =  obj.insertRow(cnt);
			    
		   			var td_obj = tr_obj.insertCell(0);
		       		td_obj.innerHTML = xobj.getElementsByTagName("no")[cnt-1].firstChild.nodeValue;
		       		var td_obj = tr_obj.insertCell(1);
		       		td_obj.innerHTML = xobj.getElementsByTagName("title")[cnt-1].firstChild.nodeValue;
		       		var td_obj = tr_obj.insertCell(2);
		       		td_obj.innerHTML = xobj.getElementsByTagName("author")[cnt-1].firstChild.nodeValue;
		
		       cnt = cnt + 1;
		       if(itemsize+1 == cnt) break;
		     }// while end
		    } // if end
		    } //end
		*/
    
 function viewData(xobj){
	var xmlDoc = xobj; 
	
	var subject="";
	var trTag ="";
    var tdTag ="";
    
	var subjects=xmlDoc.getElementsByTagName("item"); 
	for(var i=0;i<subjects.length;i++){ 
		trTag = document.createElement("tr");
		subject= subjects[i];
        var child = subject.childNodes; 
		for(var j=0; j<child.length;j++){
			tdTag = document.createElement("td"); 	
			var text = document.createTextNode(child[j].firstChild.nodeValue);
            tdTag.appendChild(text); 
			trTag.appendChild(tdTag);
        }
		document.getElementById("resultDisplay").appendChild(trTag); 
	}
}//end

