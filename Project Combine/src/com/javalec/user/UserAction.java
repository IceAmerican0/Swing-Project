package com.javalec.user;

import java.awt.Image;
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

	public class UserAction {

//--------------------------------------------------------------------------------------------
		private final String url_mysql=ShareVar.url_mysql;	
		private final String id_mysql=ShareVar.id_mysql;	
		private final String pw_mysql=ShareVar.pw_mysql;
		
		
		
//--------------------------------------------------------------------------------------------
	
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
	
	
	
	public ArrayList<Bean> UserClothConditionList(String conditionQueryColumn, String trim, String whereCheck) {
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select clothid, clothtype, clothname, clothimage, addtime, blindtime, User_userid from cloth ";
		String WhereDefault2 = whereCheck+ conditionQueryColumn + " clothname like '%" + trim + "%'";
		
		System.out.println(WhereDefault+WhereDefault2);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
			
			while(rs.next()){
				
				int wktablePK = rs.getInt(1);
            	String wktitle = rs.getString(2);
            	String wkcontent = rs.getString(3);
            	
		        String wkaddtime = rs.getString(5);
		        String wkblindtime = rs.getString(6);
		        String wkusername = rs.getString(7);
            	//image처리
		        ShareVar.filename = ShareVar.filename + 1;
            	File file = new File(Integer.toString(ShareVar.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream wkclothimage = rs.getBinaryStream(4);
                byte[] buffer = new byte[1024];
                while (wkclothimage.read(buffer) > 0) {
                    output.write(buffer);
                }
		        
		        
            	Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkclothimage, wkaddtime, wkblindtime, wkusername);
            	BeanList.add(bean);
			}
		    conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return BeanList;
	}
	public ArrayList<Bean> UserClothList() {
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select clothid, clothtype, clothname, clothimage, addtime, blindtime, User_userid"
				+ " from cloth where blindtime is null and User_userid='"+ShareVar.nowId+"'";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

            while(rs.next()){
            	
            	int wktablePK = rs.getInt(1);
            	String wktitle = rs.getString(2);
            	String wkcontent = rs.getString(3);
            	
		        String wkaddtime = rs.getString(5);
		        String wkblindtime = rs.getString(6);
		        String wkuserid = rs.getString(7);
            	//image처리
		        ShareVar.filename = ShareVar.filename + 1;
            	File file = new File(Integer.toString(ShareVar.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream wkclothimage = rs.getBinaryStream(4);
                byte[] buffer = new byte[1024];
                while (wkclothimage.read(buffer) > 0) {
                    output.write(buffer);
                }
		        
		        
            	Bean bean = new Bean(wktablePK, wktitle, wkcontent, 
            			wkclothimage, wkaddtime, wkblindtime, wkuserid);
            	BeanList.add(bean);
            }
            rs.close ();
            stmt_mysql.close ();
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return BeanList;
	}
	
	
	public Bean ClothDBTableClick() {
		Bean bean = null;
		
		String WhereDefault = "select clothtype,clothname,clothimage,addtime from cloth";
		String WhereDefault2 = " where clothid = '"+ShareVar.seqIndex+"'";
		
		System.out.println(WhereDefault + WhereDefault2);
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
			
			
			
			if(rs.next()){
				
				String wkClothtype = rs.getString(1);
				String wkClothname = rs.getString(2);
				String wkaddtime = rs.getString(4);
				// File
            	ShareVar.filename = ShareVar.filename + 1;
            	File file = new File(Integer.toString(ShareVar.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(3);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
//		            	
				bean = new Bean(wkClothtype,wkClothname,wkaddtime,input);
				
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}
	
	public void UserClothDeleteAction() {
		
		String WhereDefault = "update cloth set blindtime=now()";
		String WhereDefault2 = " where clothid = '"+ShareVar.seqIndex+"'";
		
		PreparedStatement ps=null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ps = conn_mysql.prepareStatement(WhereDefault+WhereDefault2);
			
			ps.executeUpdate();
			
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Bean> UserPresetList() {
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select clothid, clothtype, clothname, clothimage, addtime, blindtime, User_userid"
				+ " from cloth where blindtime is null and User_userid='"+ShareVar.nowId+"' and clothtype='"+ShareVar.cloth+"'";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

            while(rs.next()){
            	
            	int wktablePK = rs.getInt(1);
            	String wktitle = rs.getString(2);
            	String wkcontent = rs.getString(3);
            	
		        String wkaddtime = rs.getString(5);
		        String wkblindtime = rs.getString(6);
		        String wkuserid = rs.getString(7);
            	//image처리
		        ShareVar.filename = ShareVar.filename + 1;
            	File file = new File(Integer.toString(ShareVar.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream wkclothimage = rs.getBinaryStream(4);
                byte[] buffer = new byte[1024];
                while (wkclothimage.read(buffer) > 0) {
                    output.write(buffer);
                }
		        
		        
            	Bean bean = new Bean(wktablePK, wktitle, wkcontent, 
            			wkclothimage, wkaddtime, wkblindtime, wkuserid);
            	BeanList.add(bean);
            }
            rs.close ();
            stmt_mysql.close ();
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return BeanList;
	}
	
	public ArrayList<Bean> UserPresetConditionList(String conditionQueryColumn, String trim, String whereCheck) {
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select clothid, clothtype, clothname, clothimage, addtime, blindtime, User_userid from cloth ";
		String WhereDefault2 = "where blindtime is null and User_userid='"+ShareVar.nowId+"' and clothtype='"+ShareVar.cloth+"' and clothname like '%" + trim + "%'";
		
		System.out.println(WhereDefault+WhereDefault2);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
			
			while(rs.next()){
				
				int wktablePK = rs.getInt(1);
            	String wktitle = rs.getString(2);
            	String wkcontent = rs.getString(3);
            	
		        String wkaddtime = rs.getString(5);
		        String wkblindtime = rs.getString(6);
		        String wkusername = rs.getString(7);
            	//image처리
		        ShareVar.filename = ShareVar.filename + 1;
            	File file = new File(Integer.toString(ShareVar.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream wkclothimage = rs.getBinaryStream(4);
                byte[] buffer = new byte[1024];
                while (wkclothimage.read(buffer) > 0) {
                    output.write(buffer);
                }
		        
		        
            	Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkclothimage, wkaddtime, wkblindtime, wkusername);
            	BeanList.add(bean);
			}
		    conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return BeanList;
	}
	//-----------------------------------------------아래로 새로 추가함----------------------------------------
	public Bean DocumentForAllTableClick() {
		Bean bean = null;
		
		String WhereDefault = "select d.documentid, d.documenttitle, d.documentcontent, u.username, d.addtime, c.clothimage, d.User_userid "
				+ " from document as d inner join user as u on d.user_userid = u.userid "
				+ " inner join cloth as c on d.Cloth_clothid = c.clothid";
		String WhereDefault2 = " where d.documentid = " + ShareVar.seqIndex;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
			
			
			
			if(rs.next()){
				
				int wkSeq = rs.getInt(1);
				String wkTitle = rs.getString(2);
				String wkContent = rs.getString(3);
				String wkusername = rs.getString(4);
				String wkaddtime = rs.getString(5);
				String wkUser_userid = rs.getString(7);
				// File
            	ShareVar.filename = ShareVar.filename + 1;
            	File file = new File(Integer.toString(ShareVar.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(6);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
		        }
				bean = new Bean(wkSeq, wkTitle, wkContent, wkusername, wkaddtime, input, wkUser_userid);
				
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}
	public ArrayList<Bean> DocumentForAllCommentList(){
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select c.commentid, c.commentcontent, c.addtime, u.username "
				+ " from comment as c inner join document as d on c.Document_documentid=d.documentid"
				+ " inner join user as u on u.userid = c.User_userid "
				+ " where d.documentid = "
				+ ShareVar.seqIndex
				+ " and c.blindtime is null"
				+ " order by c.addtime Desc";
		System.out.println(WhereDefault);
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

            while(rs.next()){
            	
            	int wkSeq = rs.getInt(1);
            	String wkcontent = rs.getString(2);
		        String wkaddtime = rs.getString(3);
		        String wkusername = rs.getString(4);
            	
            	Bean bean = new Bean(wkSeq, wkcontent, wkaddtime, wkusername);
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
		public Bean CommentClick(int seq) {
			Bean bean  = null;
			String WhereDefault = "select commentcontent, User_userid from comment ";
			String WhereDefault2 = "where commentid = " + seq;
			
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
		//Admin이 답변을 넣을 때
		public boolean InsertComment(String comment , int documentid) {
			PreparedStatement ps = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String A = "insert into comment (commentcontent, user_userid, Document_documentid";
				String B = ") values (?, ?, ?)";
				ps = conn_mysql.prepareStatement(A+B);
				System.out.println(A+B);
				
				ps.setString(1, comment);
				ps.setString(2, ShareVar.nowId);
				ps.setInt(3, documentid);
				ps.executeUpdate();
				
				
				conn_mysql.close();
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		//Admin이 답변을 수정할 때
		public boolean UpdateComment(String comment) {
			 PreparedStatement ps = null;
			  try{
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			      @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
			
			      String A = "update comment set commentcontent = '"+comment;
			      String B = "' where commentid = "+ShareVar.commentIndex;
			System.out.println(A+B);
			      ps = conn_mysql.prepareStatement(A+B);
			    
			      ps.executeUpdate();
			
			      conn_mysql.close();
			  } catch (Exception e){
			      e.printStackTrace();
			      return false;
			  }
			
			  return true;
		}
		public boolean DeleteComment(int answerid) {
			//공지와 일반게시물 같이사용 가능
			 PreparedStatement ps = null;
		      try{
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
		
		          String A = "UPDATE Comment SET blindtime = now() where Commentid = "+answerid;
		          System.out.println(A);
		          ps = conn_mysql.prepareStatement(A);
		        
		          ps.executeUpdate();
		
		          conn_mysql.close();
		      } catch (Exception e){
		          e.printStackTrace();
		          return false;
		      }
		      return true;
			}
		public String WriterCheck() {
			String check  = null;
			String WhereDefault = "select User_userid from document ";
			String WhereDefault2 = "where documentid = " + ShareVar.seqIndex;
			System.out.println(WhereDefault+WhereDefault2);
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
				 if(rs.next()){
					 check = rs.getString(1);
				 }
				conn_mysql.close();
				System.out.println(check);
			}
			catch (Exception e){
				e.printStackTrace();
			}
			return check;
		}
		public boolean UpdateDocument(String title, String document) {
			PreparedStatement ps = null;
			  try{
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			      @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
			
			      String A = "update document set documenttitle = ?, documentcontent = ? ";
			      String B = " where documentid = ? ";
			
			      ps = conn_mysql.prepareStatement(A+B);
			      
			      ps.setString(1, title);
			      ps.setString(2, document);
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
			 PreparedStatement ps = null;
		      try{
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
		
		          String A = "UPDATE document SET blindtime = now() where documentid = "+ShareVar.seqIndex;
		
		          ps = conn_mysql.prepareStatement(A);
		          ps.executeUpdate();
		
		          conn_mysql.close();
		      } catch (Exception e){
		          e.printStackTrace();
		          return false;
		      }
		      return true;
		}
}
