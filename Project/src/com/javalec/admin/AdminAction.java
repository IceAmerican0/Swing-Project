package com.javalec.admin;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;

	public class AdminAction {
//--------------------------------------------------------------------------------------------
		private final String url_mysql = ShareVar.DBName;
	    private final String id_mysql = ShareVar.DBUser;
	    private final String pw_mysql = ShareVar.DBPass;
		
//--------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------
		//
		public boolean InsertQueryComment(String adminComment, int seq) {
			PreparedStatement ps = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String A = "insert into answer (answercontent, query_queryid, user_userid";
				String B = ") values (?, ?, ?)";
				
				ps = conn_mysql.prepareStatement(A+B);
				ps.setString(1, adminComment);
				ps.setInt(2, seq);
				ps.setString(3, ShareVar.useridIndex);
				
				ps.executeUpdate();
				
				conn_mysql.close();
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
			return true;

		}
		//
		public boolean InsertAdminDocument(String title, String post) {
			PreparedStatement ps = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String A = "insert into Document (documenttitle, documentcontent, documenttype, user_userid";
				String B = ") values (?,?,?,?)";
				
				ps = conn_mysql.prepareStatement(A+B);
				ps.setString(1, title);
				ps.setString(2, post);
				ps.setInt(3, 1);//공지사항인지 아닌지
				ps.setString(4, ShareVar.useridIndex);//공지사항인지 아닌지
				
				ps.executeUpdate();
				
				conn_mysql.close();
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
	
	
	
	
	
}
