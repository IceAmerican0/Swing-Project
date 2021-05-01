package com.javalec.admin;

import java.awt.image.BufferedImage;
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

import javax.imageio.ImageIO;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;

	public class AdminAction {
//--------------------------------------------------------------------------------------------
		private final String url_mysql=ShareVar.url_mysql;	
		private final String id_mysql=ShareVar.id_mysql;	
		private final String pw_mysql=ShareVar.pw_mysql;
		
//--------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------
		//
		public ArrayList<Bean> UserList(String WhereCheck){
			
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select userid, username, useremail, useraddtime, userblindtime, admin"
					+ " from user"
					+ WhereCheck;
//			System.out.println(WhereDefault);
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

	            while(rs.next()){
	            	
	            	String wktablePK = rs.getString(1);
	            	String wkname = rs.getString(2);
			        String wkemail = rs.getString(3);
			        String wkuseraddtime = rs.getString(4);
			        String wkuserblindtime = rs.getString(5);
			        int wkadmincheck = rs.getInt(6);
	            	
	            	Bean bean = new Bean(wktablePK, wkname, wkemail, wkuseraddtime, wkuserblindtime, wkadmincheck);
	            	BeanList.add(bean);
	            }
	            
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return BeanList;
		} 
		public ArrayList<Bean> ClothList(String WhereCheck){
			
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select clothid, clothtype, clothname, clothimage, addtime, blindtime, User_userid"
					+ " from cloth"
					+ WhereCheck;
//			System.out.println(WhereDefault);
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
			        
			        
	            	Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkclothimage, wkaddtime, wkblindtime, wkuserid);
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
		public ArrayList<Bean> DocumentList(String WhereCheck){
			//---------------수정전------------
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select documentid, documenttitle, documentcontent, User_userid, addtime, blindtime, Cloth_clothid"
					+ " from document where documenttype = 0 "
					+ WhereCheck;
			System.out.println(WhereDefault);
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
				
				while(rs.next()){
					
					int wktablePK = rs.getInt(1);
					String wktitle = rs.getString(2);
					String wkcontent = rs.getString(3);
					String wkuserid = rs.getString(4);
					String wkaddtime = rs.getString(5);
					String wkblindtime = rs.getString(6);
					int wkcontentid = rs.getInt(7);
					//image처리
//					ShareVar.filename = ShareVar.filename + 1;
//					File file = new File(Integer.toString(ShareVar.filename));
//					FileOutputStream output = new FileOutputStream(file);
//					InputStream wkclothimage = rs.getBinaryStream(7);
//					byte[] buffer = new byte[1024];
//					while (wkclothimage.read(buffer) > 0) {
//						output.write(buffer);
//					}
					
					
					Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkuserid, wkaddtime, wkblindtime, wkcontentid);
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
		
		
		public ArrayList<Bean> UserConditionList(String conditionQueryColumn, String querykey, String WhereCheck) {
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select clothid, clothtype, clothname, clothimage, addtime, blindtime, User_userid from user ";
			String WhereDefault2 = WhereCheck+ conditionQueryColumn + " like '%" + querykey + "%'";
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
		public ArrayList<Bean> ClothConditionList(String conditionQueryColumn, String querykey, String WhereCheck) {
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select clothid, clothtype, clothname, clothimage, addtime, blindtime, User_userid from cloth ";
			String WhereDefault2 = WhereCheck+ conditionQueryColumn + " clothname like '%" + querykey + "%'";
			
			System.out.println(WhereDefault+WhereDefault2);
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
				System.out.println(WhereDefault+WhereDefault2);
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
		//수정
		public ArrayList<Bean> DocumentConditionList(String conditionQueryColumn, String querykey, String WhereCheck) {
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select documentid, documenttitle, documentcontent, User_userid, addtime, blindtime, Cloth_clothid"
					+ " from document where documenttype = 0 ";
			String WhereDefault2 = WhereCheck+ conditionQueryColumn + " like '%" + querykey + "%'";
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
					String wkuserid = rs.getString(4);
					String wkaddtime = rs.getString(5);
					String wkblindtime = rs.getString(6);
					int wkcontentid = rs.getInt(7);
//	            	//image처리
//			        ShareVar.filename = ShareVar.filename + 1;
//	            	File file = new File(Integer.toString(ShareVar.filename));
//	            	FileOutputStream output = new FileOutputStream(file);
//	            	InputStream wkclothimage = rs.getBinaryStream(4);
//	                byte[] buffer = new byte[1024];
//	                while (wkclothimage.read(buffer) > 0) {
//	                    output.write(buffer);
//	                }
			        
			        
					Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkuserid, wkaddtime, wkblindtime, wkcontentid);
	            	BeanList.add(bean);
	            }
	            
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return BeanList;
		}
		public String UserBlindCheck(String tablePK) {
			String userid = null;
			PreparedStatement ps = null;
			//정상사용자인 경우에만 값이 나옴
			String WhereDefault = "select userid"
					+ " from user "
					+ " where userblindtime is null and userid = '" + tablePK +"'";
//			System.out.println(WhereDefault);
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
	
				if(rs.next()){
					userid  = rs.getString(1);
					conn_mysql.close();
				}
			}catch (Exception e){
			e.printStackTrace();
			}
		return userid;
		}
		public String ClothBlindCheck(String tablePK) {
			String userid = null;
			PreparedStatement ps = null;
			//정상사용자인 경우에만 값이 나옴
			String WhereDefault = "select clothid"
					+ " from cloth "
					+ " where blindtime is null and clothid = '" + tablePK +"'";
//			System.out.println(WhereDefault);
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
	
				if(rs.next()){
					userid  = rs.getString(1);
					conn_mysql.close();
				}
			}catch (Exception e){
			e.printStackTrace();
			}
		return userid;
		}
		public String DocumentBlindCheck(String tablePK) {
			String userid = null;
			PreparedStatement ps = null;
			//정상사용자인 경우에만 값이 나옴
			String WhereDefault = "select clothid"
					+ " from cloth "
					+ " where blindtime is null and clothid = '" + tablePK +"'";
//			System.out.println(WhereDefault);
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
	
				if(rs.next()){
					userid  = rs.getString(1);
					conn_mysql.close();
				}
			}catch (Exception e){
			e.printStackTrace();
			}
		return userid;
		}
		public boolean UpdateUserBlindtime(String tkSequence, int i) {
			//공지와 일반게시물 같이사용 가능
			
			PreparedStatement ps = null;
			String A = null;
		      try{
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
		          if (i == 0) {
		        	A = "UPDATE User SET userblindtime = now() where userid = '"+tkSequence+"'";		        	  
		          }
		          if (i == 1) {
		        	  A = "UPDATE user SET userblindtime = null WHERE userid = '"+tkSequence+"'";		        	  		        	  
		          }
		          ps = conn_mysql.prepareStatement(A);
			      
			    
			      ps.executeUpdate();
			
			      conn_mysql.close();

		      }catch (Exception e){
		          e.printStackTrace();
		          return false;
		      }
		      return true;
		}
		public boolean UpdateClothBlindtime(String tkSequence, int i) {
			
			PreparedStatement ps = null;
			String A = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				if (i == 0) {
					A = "UPDATE cloth SET blindtime = now() where clothid = '"+tkSequence+"'";		        	  
				}
				if (i == 1) {
					A = "UPDATE cloth SET blindtime = null WHERE clothid = '"+tkSequence+"'";		        	  		        	  
				}
				ps = conn_mysql.prepareStatement(A);
				
				
				ps.executeUpdate();
				
				conn_mysql.close();
				
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		public boolean UpdateDocumentBlindtime(String tkSequence, int i) {
			//공지와 일반게시물 같이사용 가능
			
			PreparedStatement ps = null;
			String A = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				if (i == 0) {
					A = "UPDATE cloth SET blindtime = now() where clothid = '"+tkSequence+"'";		        	  
				}
				if (i == 1) {
					A = "UPDATE cloth SET blindtime = null WHERE clothid = '"+tkSequence+"'";		        	  		        	  
				}
				ps = conn_mysql.prepareStatement(A);
				
				
				ps.executeUpdate();
				
				conn_mysql.close();
				
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
	
	
	
	
	
}
