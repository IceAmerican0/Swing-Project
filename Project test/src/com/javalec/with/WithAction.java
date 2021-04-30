package com.javalec.with;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;




	public class WithAction {
//--------------------------------------------------------------------------------------------
	
		private final String url_mysql=ShareVar.url_mysql;	
		private final String id_mysql=ShareVar.id_mysql;	
		private final String pw_mysql=ShareVar.pw_mysql;
	
	int seq;
	String QueryTitle;
	String QueryContent;
	String QueryAnswer;
//--------------------------------------------------------------------------------------------

	public WithAction() {
		super();
	}
	public WithAction(int seq) {
		super();
		this.seq = seq;
	}
	public WithAction(String queryAnswer) {
		super();
		QueryAnswer = queryAnswer;
	}
	public WithAction(String queryTitle, String queryContent) {
		super();
		QueryTitle = queryTitle;
		QueryContent = queryContent;
	}
//--------------------------------------------------------------------------------------------



	// 1:1 게시판 출력
	public ArrayList<Bean> QueryList(){
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select q.queryid, q.querytitle, q.addtime, u.username"
				+ " from user as u inner join query as q on u.userid=q.user_userid"
				+ " where q.blindtime is null";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

            while(rs.next()){
            	
            	int wkSeq = rs.getInt(1);
            	String wktitle = rs.getString(2);
		        String wkaddtime = rs.getString(3);
		        String wkusername = rs.getString(4);
            	
            	Bean bean = new Bean(wkSeq, wktitle, wkaddtime, wkusername);
            	BeanList.add(bean);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return BeanList;
	}


	public ArrayList<Bean> AnswerList(int query){
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select a.answerid, a.answercontent, a.addtime, u.username"
				+ " from answer as a inner join user as u on u.userid=a.user_userid"
				+" inner join query as q on q.queryid=a.query_queryid where a.query_queryid = "
				+ ShareVar.seqIndex
				+ " and a.blindtime is null order by a.addtime Desc";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

            while(rs.next()){
            	
            	int wkSeq = rs.getInt(1);
            	String wkcontent = rs.getString(2);
		        String wkaddtime = rs.getString(3);
		        String wkname = rs.getString(4);
            	
            	Bean bean = new Bean(wkSeq, wkcontent, wkaddtime, wkname);
            	BeanList.add(bean);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return BeanList;
	}
	public String AnswerClick() {
		String str = null;
		String WhereDefault = "select answercontent from answer ";
		String WhereDefault2 = "where answerid = " + seq;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
	
			if(rs.next()){
				String wkcontent = rs.getString(1);
				str = wkcontent;
				
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
	public ArrayList<Bean> NoticeList() {
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select d.documentid, d.documenttitle, d.addtime, u.username"
				+ "   from user as u inner join document as d on u.userid=d.user_userid"
				+ "   where d.documenttype=1 and d.blindtime is null";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
			
			while(rs.next()){
				
				int wkSeq = rs.getInt(1);
				String wktitle = rs.getString(2);
		        String wktime = rs.getString(3); //작성시간
		        String wkusername = rs.getString(4); //작성자
				
				Bean bean = new Bean(wkSeq, wktitle, wktime, wkusername);
				BeanList.add(bean);
			}
			
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return BeanList;
	}
	public Bean NoticeTableClick() {
		Bean bean = null;
		
		String WhereDefault = "select d.documentid, d.documenttitle, d.documentcontent, d.addtime, u.username"
				+ " from document as d inner join user as u on d.user_userid = u.userid";
		String WhereDefault2 = " where documentid = " + ShareVar.seqIndex;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
			
			
			
			if(rs.next()){
				
				int wkSeq = rs.getInt(1);
				String wkTitle = rs.getString(2);
				String wkContent = rs.getString(3);
				String wkTime = rs.getString(4);
				String wkusername = rs.getString(5);
				
//		            	
				bean = new Bean(wkSeq, wkTitle, wkContent, wkTime, wkusername);
				
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return bean;
		
		
	}
	public Bean QueryTableClick() {
		Bean bean = null;
		
		String WhereDefault = "select q.queryid, q.querytitle, q.querycontent, q.addtime, u.username"
				+ " from query as q inner join user as u on q.user_userid = u.userid";
		String WhereDefault2 = " where queryid = " + seq;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
			
			
			
			if(rs.next()){
				
				int wkSeq = rs.getInt(1);
				String wkTitle = rs.getString(2);
				String wkContent = rs.getString(3);
				String wkTime = rs.getString(4);
				String wkusername = rs.getString(5);
				
//		            	
				bean = new Bean(wkSeq, wkTitle, wkContent, wkTime, wkusername);
				
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}
	public boolean InsertAnswer(String Answer , int queryid) {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String A = "insert into Answer (Answercontent, user_userid, query_queryid";
			String B = ") values (?, ?, ?)";
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, Answer);
			ps.setString(2, ShareVar.nowId);
			ps.setInt(3, queryid);
			ps.executeUpdate();
			
			
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean UpdateAnswer(String answer, int answerid) {
		 PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String A = "update Answer set answercontent = ?";
		      String B = " where answerid = ? ";
		
		      ps = conn_mysql.prepareStatement(A+B);
		      
		      ps.setString(1, answer);
		      ps.setInt(2, answerid);
		    
		      ps.executeUpdate();
		
		      conn_mysql.close();
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }
		
		  return true;
	}
	public boolean UpdateQuery(String title, String Query, int queryid) {
		PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String A = "update Query set querytitle, querycontent = ?, ? ";
		      String B = " where queryid = ? ";
		
		      ps = conn_mysql.prepareStatement(A+B);
		      
		      ps.setString(1, title);
		      ps.setString(2, Query);
		      ps.setInt(3, queryid);
		    
		      ps.executeUpdate();
		
		      conn_mysql.close();
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }
		
		  return true;
	}
	public boolean DeleteQuery(int queryid) {
		//공지와 일반게시물 같이사용 가능
		 PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "UPDATE Query SET blindtime = now() where queryid = ?";
	
	          ps = conn_mysql.prepareStatement(A);
	          
	          ps.setInt(1, ShareVar.seqIndex);
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
	}
	public boolean DeleteAnswer(int answerid) {
		//공지와 일반게시물 같이사용 가능
		 PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "UPDATE Answer SET blindtime = now() where answerid = ? ;";
	
	          ps = conn_mysql.prepareStatement(A);
	          
	          ps.setInt(1, answerid);
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
		}
	}
