package com.javalec.profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.javalec.function.ShareVar;

public class CloseAcountAction {

	//field
	String blindid;
	//constructor
	public CloseAcountAction() {
		// TODO Auto-generated constructor stub
	}
	



	public CloseAcountAction(String blindid) {
		super();
		this.blindid = blindid;
	}




	//method
	public boolean blindaction() {
		
		SimpleDateFormat datetimeformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String nowtime = datetimeformat.format(System.currentTimeMillis());
		
		PreparedStatement ps = null;
		try{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		    @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
		
		    String A = "update user set userblindtime = ? ";
		    String B = " where userid = ? ";
		
		    ps = conn_mysql.prepareStatement(A+B);
		      
		    ps.setString(1, nowtime);
		    ps.setString(2, blindid);
		    ps.executeUpdate();
		
		    conn_mysql.close();
		} catch (Exception e){
		    e.printStackTrace();
		    return false;
		}
		
		return true;
		
	}
	public boolean blindcancelaction(String inputid) {
		
		String canceltime = null;
		
		PreparedStatement ps = null;
		try{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		    @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
		
		    String A = "update user set userblindtime = ? ";
		    String B = " where userid = ? ";
		
		    ps = conn_mysql.prepareStatement(A+B);
		      
		    ps.setString(1, canceltime);
		    ps.setString(2, inputid);
		    ps.executeUpdate();
		
		    conn_mysql.close();
		} catch (Exception e){
		    e.printStackTrace();
		    return false;
		}
		
		return true;
		
	}
	
	
}
