package com.javalec.user;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;

	public class UserAction {

//--------------------------------------------------------------------------------------------
		private final String url_mysql=ShareVar.url_mysql;	
		private final String id_mysql=ShareVar.id_mysql;	
		private final String pw_mysql=ShareVar.pw_mysql;
		
		
		int seqno;
		int loginnumber = 1;
		String userid;//유저 아이디
		String title; //공지사항 제목
		String post; //공지사항 내용
		String date; //공지사항 제목
		FileInputStream file;
//--------------------------------------------------------------------------------------------
	//1:1 질문 등록
	public boolean InsertQuery(String title, String content) {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String A = "insert into Query ( Querytitle, Querycontent";
			String B = ") values (?, ?)";
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.executeUpdate();
//			String C = "insert into writequery (User_userid, query_queryid";
//			String D = ") values (?, ?)";
			
			
//			ps.setString(3, Bean.useridIndex);
//			ps.setString(4, "10");
			
			
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//옷데이터 등록
	public boolean InsertCloth(String clothtype, String clothname, FileInputStream input) {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String A = "insert into cloth (clothtype, clothname, clothimage, User_userid";
			String B = ") values (?,?,?,?)";
			
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, clothtype);
			ps.setString(2, clothname);
			ps.setBinaryStream(3, input);
			ps.setString(4, ShareVar.nowId);
			
			ps.executeUpdate();
			
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//게시물에 댓글가져오
	public ArrayList<Bean> DocumentCommentList() {
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select User_userid, commentcontent, comment_document_documentid, addtime from writecomment";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
			
			while(rs.next()){
				
				int wkSeq = rs.getInt(1);
				String wkcontent = rs.getString(2);
				String wktime = rs.getString(3);
            	String wkaddtime = rs.getString(4);
				
				Bean bean = new Bean(wkSeq, wkcontent, wktime, wkaddtime);
				BeanList.add(bean);
			}
			
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return BeanList;
		
	}
	public boolean InsertDocumentComment(String text) {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String A = "insert into comment (commentcontent";
			String B = ") values (?)";
			
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, text);
			
			ps.executeUpdate();
			
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
