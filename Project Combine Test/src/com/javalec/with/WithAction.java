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
//----------------------------------------------NOTICE---------------------------------------------------
	//공지 메인 출력
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
	//공지 메인의 테이블을 클릭하
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
			ps.setString(4, ShareVar.nowId);
			
			ps.executeUpdate();
			
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean UpdateNotice(String title, String content) {
		 PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String A = "update Document set documenttitle = ?, documentcontent = ? ";
		      String B = " where Documentid = ? ";
		
		      ps = conn_mysql.prepareStatement(A+B);
		      
		      ps.setString(1, title);
		      ps.setString(2, content);
		      ps.setInt(3, ShareVar.seqIndex);
		    
		      ps.executeUpdate();
		
		      conn_mysql.close();
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }
		
		  return true;
	}
	public boolean DeleteDocument() {
		//공지와 일반게시물 같이사용 가능
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String A = "UPDATE Document SET blindtime = now() where documentid = ?";
			
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

//-----------------------------------------------NOTICE---------------------------------------------------
//-----------------------------------------QUERY&ANSWER---------------------------------------------------



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
	//1:1메인 테이블 클
	public Bean QueryTableClick() {
		Bean bean = null;
		
		String WhereDefault = "select q.queryid, q.querytitle, q.querycontent, q.addtime, u.username, q.User_userid, u.admin "
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
				String wkaddime = rs.getString(4);
				String wkusername = rs.getString(5);
				String wkuserid = rs.getString(6);
				int wkadmin = rs.getInt(7);
//				System.out.println(wkuserid+wkadmin);
//		            	
				bean = new Bean(wkSeq, wkTitle, wkContent, wkaddime, wkusername, wkuserid, wkadmin);
				
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}

		//1:1 게시판 댓글 출력
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
	//댓글 클릭시
	public Bean AnswerClick(int seq) {
		Bean bean  = null;
		String WhereDefault = "select answercontent, User_userid from answer ";
		String WhereDefault2 = "where answerid = " + seq;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
	
			if(rs.next()){
				String wkcontent = rs.getString(1);
				String wkUser_userid = rs.getString(2);
				
				bean = new Bean(wkcontent, wkUser_userid);
			} 
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}
//-----------------------------------------QUERY&ANSWER---------------------------------------------------
	
	//1:1 질문 등록
	public boolean InsertQuery(String title, String content) {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String A = "insert into Query (querytitle, querycontent, User_userid";
			String B = ") values (?, ?, ?)";
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, ShareVar.nowId);
			ps.executeUpdate();

			
			
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//User가 질문을 수정할 때
	public boolean UpdateQuery(String title, String Query, int queryid) {
		PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String A = "update Query set querytitle = ?, querycontent = ? ";
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
//	public boolean InsertQueryComment(String adminComment, int seq) {
//		PreparedStatement ps = null;
//		try{
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//			@SuppressWarnings("unused")
//			Statement stmt_mysql = conn_mysql.createStatement();
//			
//			String A = "insert into answer (answercontent, query_queryid, user_userid";
//			String B = ") values (?, ?, ?)";
//			
//			ps = conn_mysql.prepareStatement(A+B);
//			ps.setString(1, adminComment);
//			ps.setInt(2, seq);
//			ps.setString(3, ShareVar.nowId);
//			
//			ps.executeUpdate();
//			
//			conn_mysql.close();
//		} catch (Exception e){
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//
//	}
	//Admin이 답변을 넣을 때
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
	//Admin이 답변을 수정할 때
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
	public boolean DeleteAnswer(int answerid) {
		//공지와 일반게시물 같이사용 가능
		 PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "UPDATE Answer SET blindtime = now() where answerid = ? ";
	
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
	//공지사항 작성자 체크
	public String WriterCheck(int seqIndex, int documenttype) {
		 String result = null;
		 String A = "SELECT User_userid FROM document WHERE documentid = "+seqIndex+ " and documenttype = "+documenttype;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	
	          ResultSet rs = stmt_mysql.executeQuery(A);
	          
	          if(rs.next()){
	            	String wkuserid = rs.getString(1);
	            	
	            	result = wkuserid;
	            }
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	    
	      }
	      return result;
		
	}
	
	
	}
