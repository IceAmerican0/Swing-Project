package com.javalec.profile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.function.ShareVar;

public class ChangePasswordAction {
	
	//field
	String changepasswordid;
	String changepasswordpw;
	
	//constructor
	public ChangePasswordAction() {
		// TODO Auto-generated constructor stub
	}

	
	public ChangePasswordAction(String changepasswordid, String changepasswordpw) {
		super();
		this.changepasswordid = changepasswordid;
		this.changepasswordpw = changepasswordpw;
	}


	//method
	public boolean pwchangeaction() {
		
		PreparedStatement ps = null;
		try{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		    @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
		
		    String A = "update user set userpw = ? ";
		    String B = " where userid = ? ";
		
		    ps = conn_mysql.prepareStatement(A+B);
		      
		    ps.setString(1, changepasswordpw);
		    ps.setString(2, changepasswordid);
		    ps.executeUpdate();
		    // jy : 중복이라 불필요 start
//		    conn_mysql.close();
		    
//		    Connection conn_mysql2 = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
//		    Statement stmt_mysql2 = conn_mysql2.createStatement();
		    // jy : 중복이라 불필요 end
		    String C = "select userpw from user ";
		    String D = " where userid = '" + changepasswordid + "'";
		    
	        ResultSet rs = stmt_mysql.executeQuery(C+D);
	        while(rs.next()) {
	        	ShareVar.nowPw = rs.getString(1);
	            	
	        }
	        conn_mysql.close();
		    
		} catch (Exception e){
		    e.printStackTrace();
		    return false;
		}
		
		return true;
		
	}
	
	
	 
}
