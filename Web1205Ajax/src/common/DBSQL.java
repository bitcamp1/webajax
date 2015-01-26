package common;

import  java.sql.*;
import  java.util.Date ;
import  java.util.ArrayList;
import  java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBSQL { 
    private   Connection  CN = null ;
    private   Statement  ST = null ;
    private   PreparedStatement   PST = null ;
    private  ResultSet  RS = null ;
    private  String sql ="" ;  
    private  int OK = 0  ;  
    
	public  DBSQL( ){ 
		CN= DB.getConnection(); 
		try{
			//Context initCtx=new InitialContext();
			//Context envCtx=(Context)initCtx.lookup("java:comp/env");
			//DataSource ds=(DataSource)envCtx.lookup("jdbc/snow");
			//CN=ds.getConnection();
		}catch(Exception ex) {  }
  } //  end
	
	public int  dbEdit(DBbean  bean){
		try{
			sql ="update  guest  set  name=?, nalja=sysdate, pay=?  where  sabun=?" ; 
			PST = CN.prepareStatement(sql);
			PST.setString(1,  bean.getName()) ;
			PST.setInt(2, bean.getPay()) ;
			PST.setInt(3, bean.getSabun()) ;
			OK = PST.executeUpdate(); 
		}catch(Exception ex) {  }
		return  OK ; 
	}//end
	
	public int  dbDelete(String  data) {
		 try{ 
			 sql ="delete  from  guest  where  sabun =  " + data ;
			 ST = CN.createStatement();
			 OK =ST.executeUpdate(sql);
		 }catch(Exception ex) {  }
		return  OK;
	} //end
	

	public  DBbean   dbDetail(String  data){ 
		 DBbean  bean  = new  DBbean( );
		  try{
			  sql ="select  * from  guest  where  sabun =  " + data ; 
			  ST = CN.createStatement();
			  RS=ST.executeQuery(sql);
			  if(RS.next()==true){
				  bean.setSabun(RS.getInt("sabun"));
				  bean.setName(RS.getString("name")) ;
				  bean.setNalja(RS.getDate("nalja")) ; 
				  bean.setPay(RS.getInt("pay"));
			  }
		  }catch(Exception ex) {  }
		 return  bean ; 
	} //end
	
	public  List  dbSelect( ) {
		List  LT = new ArrayList( );
		try{
			sql="select  *  from  guest  order by sabun " ;  
			ST = CN.createStatement();
			RS=ST.executeQuery(sql) ; 
			while(RS.next()==true){  
				DBbean  bean  = new  DBbean( );
				bean.setSabun(  RS.getInt("sabun")) ;
				bean.setName(RS.getString("name")) ;
				bean.setNalja(RS.getDate("nalja"));
				bean.setPay(RS.getInt("pay"));
				LT.add(bean);  
			} //while end
		}catch(Exception ex) {  }
		return  LT ;
	} //end
	
	public   int   dbInsert( DBbean  bean){
			int data1 =  bean.getSabun() ;
			String data2 =  bean.getName( );
			int data3 =  bean.getPay() ;

			try{
				sql ="insert into  guest  values(?, ?, sysdate, ? )" ;
				PST = CN.prepareStatement(sql) ;
				PST.setInt(1,  data1) ;
				PST.setString(2, data2) ;
				PST.setInt(3, data3) ;
				OK = PST.executeUpdate();
			}catch(Exception ex) {  System.out.println("error: " + ex.toString());  }
		return  OK;
	} //end 
	
} //class end















