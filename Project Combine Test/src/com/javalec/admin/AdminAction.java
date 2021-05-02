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
	            	
			        String wkaddtime = rs.getString(5);
			        String wkblindtime = rs.getString(6);
			        String wkuserid = rs.getString(7);
//	            	//image처리
//			        ShareVar.filename = ShareVar.filename + 1;
//	            	File file = new File(Integer.toString(ShareVar.filename));
//	            	FileOutputStream output = new FileOutputStream(file);
//	            	InputStream wkclothimage = rs.getBinaryStream(4);
//	                byte[] buffer = new byte[1024];
//	                while (wkclothimage.read(buffer) > 0) {
//	                    output.write(buffer);
//	                }
//			        System.out.println(wktablePK+ wktitle+ wkcontent+ wkaddtime+ wkblindtime+ wkuserid);
	                Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkaddtime, wkblindtime, wkuserid);
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
					
					
					Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkcontentid, wkuserid, wkaddtime, wkblindtime);
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
			
			String WhereDefault = "select userid,username,useremail,useraddtime,userblindtime,admin from user ";
			String WhereDefault2 = WhereCheck+ conditionQueryColumn + " like '%" + querykey + "%'";
			System.out.println(WhereDefault+WhereDefault2);
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
	            System.out.println(WhereDefault+WhereDefault2);
	            while(rs.next()){
	            	
	            	String wkuserid = rs.getString(1);
	            	String wkusername = rs.getString(2);
	            	String wkuseremail = rs.getString(3);
			        String wkaddtime = rs.getString(4);
			        String wkblindtime = rs.getString(5);
			        int wkadmin=rs.getInt(6);
			        
			        
	            	Bean bean = new Bean(wkuserid, wkusername, wkuseremail, wkaddtime, wkblindtime, wkadmin);
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
			
			String WhereDefault = "select clothid, clothtype, clothname, addtime, blindtime, User_userid from cloth ";
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
	            	
			        String wkaddtime = rs.getString(4);
			        String wkblindtime = rs.getString(5);
			        String wkuserid = rs.getString(6);
//			            	//image처리
//					        ShareVar.filename = ShareVar.filename + 1;
//			            	File file = new File(Integer.toString(ShareVar.filename));
//			            	FileOutputStream output = new FileOutputStream(file);
//			            	InputStream wkclothimage = rs.getBinaryStream(4);
//			                byte[] buffer = new byte[1024];
//			                while (wkclothimage.read(buffer) > 0) {
//			                    output.write(buffer);
//			                }
//			        System.out.println(wktablePK+ wktitle+ wkcontent+ wkaddtime+ wkblindtime+ wkuserid);
	                Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkaddtime, wkblindtime, wkuserid);
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
			
			String WhereDefault = "select documentid, documenttitle, documentcontent, Cloth_clothid, User_userid, addtime, blindtime"
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
					int wkcontentid = rs.getInt(4);
					String wkuserid = rs.getString(5);
					String wkaddtime = rs.getString(6);
					String wkblindtime = rs.getString(7);
//	            	//image처리
//			        ShareVar.filename = ShareVar.filename + 1;
//	            	File file = new File(Integer.toString(ShareVar.filename));
//	            	FileOutputStream output = new FileOutputStream(file);
//	            	InputStream wkclothimage = rs.getBinaryStream(4);
//	                byte[] buffer = new byte[1024];
//	                while (wkclothimage.read(buffer) > 0) {
//	                    output.write(buffer);
//	                }
			        
			        
					Bean bean = new Bean(wktablePK, wktitle, wkcontent, wkcontentid, wkuserid, wkaddtime, wkblindtime);
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
		public String DocumentBlindCheck() {
			String userid = null;
//			PreparedStatement ps = null;
//			//정상사용자인 경우에만 값이 나옴
//			String WhereDefault = "select documentid"
//					+ " from document "
//					+ " where blindtime is null and documentid = '" + ShareVar.seqIndex +"'";
//			System.out.println(WhereDefault);
////			System.out.println(WhereDefault);
//			try{
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//			
//			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
//	
//				if(rs.next()){
//					userid  = rs.getString(1);
//					conn_mysql.close();
//				}
//			}catch (Exception e){
//			e.printStackTrace();
//			}
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
		public boolean UpdateDocumentBlindtime(int i) {
			//공지와 일반게시물 같이사용 가능
			
			PreparedStatement ps = null;
			String A = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				if (i == 0) {
					A = "UPDATE document SET blindtime = now() where documentid = '"+ShareVar.seqIndex+"'";		        	  
				}
				if (i == 1) {
					A = "UPDATE document SET blindtime = null WHERE documentid = '"+ShareVar.seqIndex+"'";		        	  		        	  
				}
				ps = conn_mysql.prepareStatement(A);
				System.out.println(A);
				
				ps.executeUpdate();
				
				conn_mysql.close();
				
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		public Bean DocumentDBTableClick() {
			Bean bean = null;
			
			String WhereDefault = "select d.documentid, d.documenttitle, d.documentcontent, d.addtime, d.blindtime, u.userid, c.clothimage "
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
					String wkaddtime = rs.getString(4);
					String wkblindtime = rs.getString(5);
					String wkuserid = rs.getString(6);
					// File
	            	ShareVar.filename = ShareVar.filename + 1;
	            	File file = new File(Integer.toString(ShareVar.filename));
	            	FileOutputStream output = new FileOutputStream(file);
	            	InputStream input = rs.getBinaryStream(7);
	                byte[] buffer = new byte[1024];
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
			        }
					bean = new Bean(wkSeq, wkTitle, wkContent, wkuserid, wkaddtime, wkblindtime, input);
					
				}
				conn_mysql.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
			return bean;
		}
		public ArrayList<Bean> DBCommentList(){
			
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select c.commentid, c.commentcontent, c.addtime, c.blindtime, c.User_userid "
					+ " from comment as c inner join document as d on c.Document_documentid=d.documentid"
					+ " where d.documentid = "
					+ ShareVar.seqIndex
					+ " order by c.addtime Desc";
			
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

	            while(rs.next()){
	            	
	            	int wkSeq = rs.getInt(1);
	            	String wkcontent = rs.getString(2);
			        String wkaddtime = rs.getString(3);
			        String wkblindtime = rs.getString(4);
			        String wkUser_userid = rs.getString(5);
	            	
	            	Bean bean = new Bean(wkUser_userid, wkSeq, wkcontent, wkaddtime, wkblindtime);
	            	BeanList.add(bean);
	            }
	            
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return BeanList;
		}
		public ArrayList<Bean> DBDocumentList(){
			
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select d.documentid, d.documenttitle, d.addtime, d.blindtime, d.User_userid "
					+ " from cloth as c inner join document as d on c.clothid=d.Cloth_clothid"
					+ " where c.clothid = "
					+ ShareVar.seqIndex
					+ " order by c.addtime Desc";
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
				
				while(rs.next()){
					
					int wkSeq = rs.getInt(1);
					String wkcontent = rs.getString(2);
					String wkaddtime = rs.getString(3);
					String wkblindtime = rs.getString(4);
					String wkUser_userid = rs.getString(5);
					
					Bean bean = new Bean(wkUser_userid, wkSeq, wkcontent, wkaddtime, wkblindtime);
					BeanList.add(bean);
				}
				
				conn_mysql.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
			return BeanList;
		}
		public Bean ClothDBTableClick() {
			Bean bean = null;
			
			String WhereDefault = "select c.clothid, c.clothtype, c.clothname, c.addtime, c.blindtime, u.userid, c.clothimage "
					+ " from cloth as c inner join user as u on c.user_userid = u.userid";
			String WhereDefault2 = " where c.clothid = " + ShareVar.seqIndex;
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
				
				
				
				if(rs.next()){
					
					int wkSeq = rs.getInt(1);
					String wkTitle = rs.getString(2);
					String wkContent = rs.getString(3);
					String wkaddtime = rs.getString(4);
					String wkblindtime = rs.getString(5);
					String wkuserid = rs.getString(6);
					// File
	            	ShareVar.filename = ShareVar.filename + 1;
	            	File file = new File(Integer.toString(ShareVar.filename));
	            	FileOutputStream output = new FileOutputStream(file);
	            	InputStream input = rs.getBinaryStream(7);
	                byte[] buffer = new byte[1024];
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
	                }
//			            	
					bean = new Bean(wkSeq, wkTitle, wkContent, wkuserid, wkaddtime, wkblindtime ,input);
					
				}
				conn_mysql.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
			return bean;
		}
		public boolean UpdateClothBlindtime(int i) {
			//공지와 일반게시물 같이사용 가능
			
			PreparedStatement ps = null;
			String A = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				if (i == 0) {
					A = "UPDATE Cloth SET blindtime = now() where clothid = '"+ShareVar.seqIndex+"'";		        	  
				}
				if (i == 1) {
					A = "UPDATE Cloth SET blindtime = null WHERE clothid = '"+ShareVar.seqIndex+"'";		        	  		        	  
				}
				ps = conn_mysql.prepareStatement(A);
				System.out.println(A);
				
				ps.executeUpdate();
				
				conn_mysql.close();
				
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		public boolean UpdateClothType(Object ClothType) {
			
			PreparedStatement ps = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
			
				String A = "UPDATE cloth SET clothtype = '"+ClothType+"' where clothid = '"+ShareVar.seqIndex+"'";		        	  
				
				System.out.println(A);
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
