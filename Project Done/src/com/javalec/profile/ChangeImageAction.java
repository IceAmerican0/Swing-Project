package com.javalec.profile;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.javalec.function.ShareVar;

public class ChangeImageAction {
	
	// field
	String userid;
	FileInputStream changeimage;
	
	// constructor
	public ChangeImageAction() {
		// TODO Auto-generated constructor stub
	}

	public ChangeImageAction(String userid, FileInputStream changeimage) {
		super();
		this.userid = userid;
		this.changeimage = changeimage;
	}

	// method
	
	public boolean UpdateImageAction() {
		  PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String A = "update user set userimage = ? ";
		      String B = " where userid = ? ";
		
		      ps = conn_mysql.prepareStatement(A+B);
		      
		      ps.setBinaryStream(1, changeimage);
		      ps.setString(2, userid);
		      ps.executeUpdate();
		
		      conn_mysql.close();
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }
		
		  return true;
	}
	
	
	
}
