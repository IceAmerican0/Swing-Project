package com.javalec.login;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;


public class LoginAction {
	private final String url_mysql=ShareVar.url_mysql;	
	private final String id_mysql=ShareVar.id_mysql;	
	private final String pw_mysql=ShareVar.pw_mysql;
	
	String id;
	String pw;
	String name;
	String email; // jy : 추가
	String blindtime;
	int admin; 
	
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}

	public LoginAction(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public int Login() {
		String sql1="select userpw, useremail, username, userblindtime, admin, userimage from user where"; // jy : useremail, userblindtime, userimage 추가, 순서 db와 다름
		String sql2=" user.userid='"+id+"'";
		String userpw="";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          ResultSet rs = stmt_mysql.executeQuery(sql1+sql2);
	          while(rs.next()) {
	        	  userpw=rs.getString(1);
	        	  this.email=rs.getString(2); // jy : 추가
	        	  this.name=rs.getString(3); 
	        	  this.blindtime=rs.getString(4); // jy : 추가
	        	  this.admin=rs.getInt(5);
	        	  
	        	  ShareVar.filename += 1;
	        	  File file = new File(Integer.toString(ShareVar.filename));
            	  FileOutputStream output = new FileOutputStream(file);
            	  InputStream input = rs.getBinaryStream(6);
                  byte[] buffer = new byte[1024];
                  while (input.read(buffer) > 0) {
                      output.write(buffer);
                  }
	            	
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
		
		
		if(userpw.equals("")) return 0;
		if(userpw.equals(pw)) {
			ShareVar.nowId=id;
			ShareVar.nowPw=pw;
			ShareVar.admincheck=admin; 
			ShareVar.userName=name; // jy : 추가
			ShareVar.userEmail=email; // jy : 추가
			ShareVar.blindTime=blindtime; // jy : 추가
//			ShareVar.closeIndex=0;
			return 1;
		}
		else return 0;
	}
}
