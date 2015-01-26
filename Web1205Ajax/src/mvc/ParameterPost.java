package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBSQL;
import common.DBbean;

import java.io.*;

public class ParameterPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{//GET방식으로 요청시 실행
		requestProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{//POST방식으로 요청시 실행
		requestProcess(request, response);
	}

	public void requestProcess(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html;charset=euc-kr");//응답되는 내용의 Content-type을 설정
		PrintWriter out = response.getWriter();//화면에 출력하기 위해 out객체 얻어냄
	
		String sabun = request.getParameter("sabun"); //요청파라미터 name변수의 값을 얻어냄
		String name = request.getParameter("name"); //요청파라미터 name변수의 값을 얻어냄
		String pay = request.getParameter("pay"); //요청파라미터 age변수의 값을 얻어냄
		
	
		String str = "<b><h2><font color=red>" + name + "</font></b>님의 급여는 "+ pay +"이고, 사번는 " + sabun + " 입니다.</h2>";
		out.println(str); //화면에 str의 내용 출력 =>여기서는 parameterGet.js의 xhrObject.responseText의 값
		out.close(); //out객체 리소스 해제
		
		DBbean  bean  = new  DBbean( ) ;
		DBSQL  dbsql = new  DBSQL( );
		bean.setSabun(Integer.parseInt(sabun)) ;
		bean.setName(name) ; 
		bean.setPay(Integer.parseInt(pay)) ;
		dbsql.dbInsert(bean) ; 
	 } //end
} //class END
