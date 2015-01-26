package mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import common.DB;

//twoAjax.jsp  Testing
public class SessionLogin222  extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	private  Connection CN     = null;
	private  Statement ST = null;
	private  ResultSet RS       = null;
	private String sql        = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user( request, response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user( request, response) ;
	}
	
	protected void  user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String p_name = request.getParameter("name") ;
		int p_sabun   = Integer.parseInt(request.getParameter("sabun")) ;		
		try {
			CN = DB.getConnection();
			
			sql = "select name from  guest  where sabun ="+p_sabun;
			//System.out.println(sql +"\n");
			ST = CN.createStatement();
			
			RS = ST.executeQuery(sql);
			
			String db_name = "";
			StringBuilder sb = new StringBuilder();
			
			if(RS.next()==true) {
				db_name = RS.getString("name");
				if(p_name.equals(db_name)) {	
					 sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
					 sb.append("<items><login>true</login><name>"+p_name+"</name></items>");
				} else {
					sb.append("<login>false</login>");
				}
			} else {
				sb.append("<login>false</login>");
			}
			
			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(sb.toString());
			System.out.println(sb.toString());
		} catch (Exception ex) {	}
	}
} //class END