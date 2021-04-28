//package com.javalec.admin;
//
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import com.javalec.function.Bean;
//import com.javalec.function.ShareVar;
//
//public class AdminAction {
//
//	public AdminAction() {
//		//--------------------------------------------------------------------------------------------
////	    private final String url_mysql = ShareVar.DBName;
////	    private final String id_mysql = ShareVar.DBUser;
////	    private final String pw_mysql = ShareVar.DBPass;
////		
////		
////		int seqno;
////		int loginnumber = 1;
////		String userid;//유저 아이디
////		String title; //공지사항 제목
////		String post; //공지사항 내용
////		String date; //공지사항 제목
////		FileInputStream file;
//////--------------------------------------------------------------------------------------------
////		public DbAction() {
////			super();
////		}
////
////
////		public DbAction(int seqno) {
////			super();
////			this.seqno = seqno;
////		}
////
////		public DbAction(String title, String post) {
////			super();
////			this.title = title;
////			this.post = post;
////		}
//
////---------------------------------검색 결과를 Table로------------------------------------------
//		public ArrayList<Bean> QueryList(){
//			
//			ArrayList<Bean> BeanList = new ArrayList<Bean>();
//			
//			String WhereDefault = "select queryid, querytitle, querycontent from query ";
//			
//	        try{
//	            Class.forName("com.mysql.cj.jdbc.Driver");
//	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//	            Statement stmt_mysql = conn_mysql.createStatement();
//
//	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
//
//	            while(rs.next()){
//	            	
//	            	int wkSeq = rs.getInt(1);
//	            	String wktitle = rs.getString(2);
//	            	String wkcontent = rs.getString(3);
////	            	String wktime = rs.getString(4);
//	            	
//	            	Bean bean = new Bean(wkSeq, wktitle, wkcontent);
//	            	BeanList.add(bean);
//	            }
//	            
//	            conn_mysql.close();
//	        }
//	        catch (Exception e){
//	            e.printStackTrace();
//	        }
//			return BeanList;
//		}
//		public ArrayList<Bean> DocumentList() {
//			
//			ArrayList<Bean> BeanList = new ArrayList<Bean>();
//			
//			String WhereDefault = "select documentid, documenttitle, documentcontent from Document";
//			
//			try{
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//				Statement stmt_mysql = conn_mysql.createStatement();
//				
//				ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
//				
//				while(rs.next()){
//					
//					int wkSeq = rs.getInt(1);
//					String wktitle = rs.getString(2);
//					String wkcontent = rs.getString(3);
////	            	String wktime = rs.getString(4);
//					
//					Bean bean = new Bean(wkSeq, wktitle, wkcontent);
//					BeanList.add(bean);
//				}
//				
//				conn_mysql.close();
//			}
//			catch (Exception e){
//				e.printStackTrace();
//			}
//			return BeanList;
//			
//		}
//		public ArrayList<Bean> DocumentComment() {
//			
//			ArrayList<Bean> BeanList = new ArrayList<Bean>();
//			
//			String WhereDefault = "select User_userid, commentcontent, comment_document_documentid, addtime from writecomment";
//			
//			try{
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//				Statement stmt_mysql = conn_mysql.createStatement();
//				
//				ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
//				
//				while(rs.next()){
//					
//					int wkSeq = rs.getInt(1);
//					String wktitle = rs.getString(2);
//					String wkcontent = rs.getString(3);
////	            	String wktime = rs.getString(4);
//					
//					Bean bean = new Bean(wkSeq, wktitle, wkcontent);
//					BeanList.add(bean);
//				}
//				
//				conn_mysql.close();
//			}
//			catch (Exception e){
//				e.printStackTrace();
//			}
//			return BeanList;
//			
//		}
//
//		// QnA Table을 Click하였을 경우
//		public Bean TableClick() {
//			System.out.println(seqno);
//			Bean bean = null;
//			String WhereDefault = "select queryid, querytitle, querycontent, querytime from query ";
//			String WhereDefault2 = "where queryid = " + seqno;
//			
//	        try{
//	            Class.forName("com.mysql.cj.jdbc.Driver");
//	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//	            Statement stmt_mysql = conn_mysql.createStatement();
//
//	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
//	            
//	            
//
//	            if(rs.next()){
//	            	
//	            	int wkSeq = rs.getInt(1);
//	            	String wkTitle = rs.getString(2);
//	            	String wkContent = rs.getString(3);
//	            	String wkTime = rs.getString(4);
////	            	// File
////	            	ShareVar.filename = ShareVar.filename + 1;
////	            	File file = new File(Integer.toString(ShareVar.filename));
////	            	FileOutputStream output = new FileOutputStream(file);
////	            	InputStream input = rs.getBinaryStream(7);
////	                byte[] buffer = new byte[1024];
////	                while (input.read(buffer) > 0) {
////	                    output.write(buffer);
////	                }
//	            	
//	            bean = new Bean(wkSeq, wkTitle, wkContent);
//	            }
//	            conn_mysql.close();
//	        }
//	        catch (Exception e){
//	            e.printStackTrace();
//	        }
//			return bean;
//			
//			
//		}
////		
////		
//		//조건 검색 결과를 Table로 
////		public ArrayList<Bean> ConditionList(){
////			
////			ArrayList<Bean> BeanList = new ArrayList<Bean>();
////			
////			String WhereDefault = "select seqno, name, telno, relation from userinfo2 ";
////			String WhereDefault2 = "where " + conname + " like '%" + condata + "%'";
////			
////	        try{
////	            Class.forName("com.mysql.cj.jdbc.Driver");
////	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
////	            Statement stmt_mysql = conn_mysql.createStatement();
////
////	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
////
////	            while(rs.next()){
////	            	
////	            	int wkSeq = rs.getInt(1);
////	            	String wkName = rs.getString(2);
////	            	String wkTelno = rs.getString(3);
////	            	String wkRelation = rs.getString(4);
////	            	
////	            	Bean bean = new Bean(wkSeq, wkName, wkTelno, wkRelation);
////	            	BeanList.add(bean);
////	            }
////	            
////	            conn_mysql.close();
////	        }
////	        catch (Exception e){
////	            e.printStackTrace();
////	        }
////			return BeanList;
////		}
//
//		
//
//		//-----------------------------------------입력------------------------------------
//		public boolean InsertQnaComment(String adminComment) {
//			PreparedStatement ps = null;
//			try{
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//				@SuppressWarnings("unused")
//				Statement stmt_mysql = conn_mysql.createStatement();
//				
//				String A = "insert into answer (answercontent";
//				String B = ") values (?)";
//				
//				ps = conn_mysql.prepareStatement(A+B);
//				ps.setString(1, adminComment);
//				
//				ps.executeUpdate();
//				
//				conn_mysql.close();
//			} catch (Exception e){
//				e.printStackTrace();
//				return false;
//			}
//			return true;
//
//		}
//		public boolean InsertDocument(String title, String post) {
//			PreparedStatement ps = null;
//			try{
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//				@SuppressWarnings("unused")
//				Statement stmt_mysql = conn_mysql.createStatement();
//				
//				String A = "insert into Document (documenttitle, documentcontent, documenttype";
//				String B = ") values (?,?,?)";
//				
//				ps = conn_mysql.prepareStatement(A+B);
//				ps.setString(1, title);
//				ps.setString(2, post);
//				ps.setInt(3, loginnumber);
//				
//				ps.executeUpdate();
//				
//				conn_mysql.close();
//			} catch (Exception e){
//				e.printStackTrace();
//				return false;
//			}
//			return true;
//		}
//		public boolean InsertComment(String text) {
//			PreparedStatement ps = null;
//			try{
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//				@SuppressWarnings("unused")
//				Statement stmt_mysql = conn_mysql.createStatement();
//				
//				String A = "insert into comment (commentcontent";
//				String B = ") values (?)";
//				
//				ps = conn_mysql.prepareStatement(A+B);
//				ps.setString(1, text);
//				
//				ps.executeUpdate();
//				
//				conn_mysql.close();
//			} catch (Exception e){
//				e.printStackTrace();
//				return false;
//			}
//			return true;
//		}
//		public boolean InsertCloth(String clothtype, String clothname, FileInputStream file) {
//			PreparedStatement ps = null;
//			try{
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//				@SuppressWarnings("unused")
//				Statement stmt_mysql = conn_mysql.createStatement();
//				
//				String A = "insert into cloth (clothtype, clothname, clothimage";
//				String B = ") values (?,?,?)";
//				
//				ps = conn_mysql.prepareStatement(A+B);
//				ps.setString(1, clothtype);
//				ps.setString(2, clothname);
//				ps.setBinaryStream(3, file);
//				
//				ps.executeUpdate();
//				
//				conn_mysql.close();
//			} catch (Exception e){
//				e.printStackTrace();
//				return false;
//			}
//			return true;
//		}
//		public boolean InsertQuery(String title, String content) {
//			PreparedStatement ps = null;
//			try{
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//				@SuppressWarnings("unused")
//				Statement stmt_mysql = conn_mysql.createStatement();
//				
//				String A = "insert into Query (Querytitle, Querycontent";
//				String B = ") values (?,?)";
//				
//				ps = conn_mysql.prepareStatement(A+B);
//				ps.setString(1, title);
//				ps.setString(2, content);
//				
//				ps.executeUpdate();
//				
//				conn_mysql.close();
//			} catch (Exception e){
//				e.printStackTrace();
//				return false;
//			}
//			return true;
//		}
//		
//		//---------------------------------------------- 수정----------------------------------------------
//
//	}
//
//}
