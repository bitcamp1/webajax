<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head> <title>twoAjax.jsp</title>
<script type="text/javascript">
var request = null;

	function requestSend() { 
		request = new XMLHttpRequest();
		var loginId = document.getElementById('main_login_sabun').value;
		var loginPw = document.getElementById('main_login_name').value;
		if (loginId == "" || loginPw == "") {
			alert('sabun name input');
		} else {
			var url = "login.do?sabun=" + loginId + "&name=" + loginPw;
			request.onreadystatechange = RP222;
			request.open('GET', url, true);
			request.send(null);
		}
	}

	function  RP() {
		if (request.readyState == 4 && request.status==200) {  
			var ret = request.responseText;
			var str = '<font size=7 color=green>' + ret + '님 로그인성공</font><br>';
			document.getElementById('login_two_div').innerHTML= str ; 
		} 
	} //end

	function  RP222() {
		 try {
			if (request.readyState == 4 && request.status==200) {  
				//var xmlText = request.responseText;
				//alert("xmlText=" + xmlText);
				//var parser = new DOMParser();
				//var dom = parser.parseFromString(xmlText, "text/xml");
				//var items = dom.getElementsByTagName('items');
				//var login_result = items[0].childNodes[0].firstChild.nodeValue;
				//var name_result = items[0].childNodes[1].firstChild.nodeValue;
                //http://blog.naver.com/hjshin9851/220063948219 ajax참고사이트 
				var xmlText = request.responseXML;
				var login_result = xmlText.getElementsByTagName('login')[0].childNodes[0].nodeValue;
				//var login_result = xmlText.getElementsByTagName('login')[0].firstChild.nodeValue;
				
				if (login_result == 'true') {
					//var ret = xmlText.getElementsByTagName('name')[0].childNodes[0].nodeValue;
					var ret = xmlText.getElementsByTagName('name')[0].firstChild.nodeValue;
					var str = '<font size=7 color=blue>' + ret + '님 로그인성공 </font><br>';
					var str2 = '<img src='./imagesfont size=7 color=blue>' + ret + '님 로그인성공 </font><br>';
					var loginView = document.getElementById('login_two_div');
					loginView.innerHTML = str;
				} else { alert('failed'); }
			 }
		  } catch (e) {	alert("error: " + e.description);	}
		} //end
	
</script>
</head>

<body>

	<div id="login_two_div">
	<font color=red size=7> <b>[twoAjax.jsp] </b></font>
		<form method=post>
		<table  border=1 width=400>
			<tr>
				<td>사번:</td>
				<td align="left" >
				<input type=text  name="sabun" id="main_login_sabun" size=20  /></td>
			</tr>

			<tr>
				<td>이름:</td>
				<td align="left">
				<input type=text  name="name" id="main_login_name" size=20  /></td>
			</tr>

			<tr>
				<td colspan=2>&nbsp;&nbsp; 
				<input  type="button" value="twoAjax응용" onClick="requestSend( )"> &nbsp;&nbsp;
				 <input  type="reset"  value="취 소">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>


</html>



