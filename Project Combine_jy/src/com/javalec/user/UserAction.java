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
		
		String documenttitle;
		String documentcontent;
		int documenttype;
		String User_userid;
		String Cloth_clothid;
		
//--------------------------------------------------------------------------------------------
		public UserAction() {
			// TODO Auto-generated constructor stub
		}
		
		
		public UserAction(String documenttitle, String documentcontent, int documenttype, String user_userid,
				String cloth_clothid) {
			super();
			this.documenttitle = documenttitle;
			this.documentcontent = documentcontent;
			this.documenttype = documenttype;
			this.User_userid = user_userid;
			this.Cloth_clothid  = cloth_clothid;
		}
		
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
	
	public boolean InsertAction() {
	      PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "insert into document (documenttitle, documentcontent, documenttype, User_userid, Cloth_clothid";
	          String B = ") values (?,?,?,?,?)";
	
	          ps = conn_mysql.prepareStatement(A+B);
	          ps.setString(1, documenttitle.trim());
	          ps.setString(2, documentcontent.trim());
	          ps.setInt(3, documenttype);
	          ps.setString(4, User_userid.trim());
	          ps.setString(5, Cloth_clothid.trim());
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
	}
	
	
}
