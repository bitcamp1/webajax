package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;  //PrintWriter
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;  //List, ArrayList
import javax.servlet.http.*; //HttpSession

import common.DB;


public class SessionLogin333 extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	private  Connection CN = null ; 
	private  Statement  ST = null ; 
	private  PreparedStatement  PST = null ; 
	private  ResultSet  RS = null ; 
	private String sql = null ; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user( request, response) ;
	} //end

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user( request, response) ;
	} //end
	
protected void  user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setCharacterEncoding("EUC-KR") ;
	response.setContentType("text/html;charset=EUC-KR");
	PrintWriter  out = response.getWriter() ;
	out.println("<h1><center><font size=7 color=green>[SessionLogin.java]</font></h1>") ;
	out.println("<img src='./images/bbb.gif'>") ; 	out.println("<img src='./images/bbb.gif'>") ; 
	out.println("<img src='./images/bbb.gif'>") ;	  out.println("<img src='./images/bbb.gif'><br><p><hr>") ; 
	
	int data1 = Integer.parseInt(request.getParameter("sabun")) ;
	String data2 = request.getParameter("name") ;
 try{
	 CN=DB.getConnection() ;
	 sql="select  * from guest " ;  
	 boolean  flag=false ; 
	 int str1=0; //RS.getInt("sabun")
	 String str2= null ; //RS.getString("name")
	 ST= CN.createStatement() ;
	 RS=ST.executeQuery(sql) ;
	 while(RS.next() ==true) {
		 str1=RS.getInt("sabun");  //id=sabun
		 if(str1==data1){
			 flag=true;
			 str2=RS.getString("name") ;
			 if(str2.equals(data2)) { 
				 HttpSession  ses =request.getSession() ;
				 String send = String.valueOf(str1) ;
				 ses.setAttribute("naver", send); 
				 out.println("<font size=7><b> <a href='photo.do'> [Photo Show] </a></b></font>") ;
				 out.println("<br><p><img src='./images/bar2.gif'><br>") ;
			 } else {
				 out.println("<font size=7><b> <a href='./day20/SessionLogin.html'> [SessoinLogin.html] </a></b></font>") ;
				 out.println("<br><img src='./images/bar2.gif'><br>") ;
			 }
		 }
	 } //while end
	 
	 if(!flag) { //
		 out.println("<font size=7><b> <a href='./day20/SessionLogin.html'> [SessoinLogin.html] </a></b></font>") ;
	  out.println("<a href='twoList.jsp'> <font size=7><b> [twoList.jsp] </b></font> </center></a>") ;
	 }
 }catch(Exception ex) { }
} //user(1,2) end

} //class END



