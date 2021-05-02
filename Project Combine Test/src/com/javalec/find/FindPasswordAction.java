package com.javalec.find;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.function.ShareVar;

public class FindPasswordAction {
	private final String url_mysql=ShareVar.url_mysql;	
	private final String id_mysql=ShareVar.id_mysql;	
	private final String pw_mysql=ShareVar.pw_mysql;
	
	String id;
	String name;
	String email;
	
	public FindPasswordAction() {
		// TODO Auto-generated constructor stub
	}

	public FindPasswordAction(String id,String name, String email) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
	}
	
	public String IdfindAction() {
		
		
		String sql1="select userpw from user where";
		String sql2=" user.userid='"+id+"' and user.useremail='"+email+"' and user.username='"+name+"'";
		String userpw="";
		
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          ResultSet rs = stmt_mysql.executeQuery(sql1+sql2);
	          while(rs.next()) {
	        	  userpw=rs.getString(1);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
		return userpw;
	}
	

}
