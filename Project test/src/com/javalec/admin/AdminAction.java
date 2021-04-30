package com.javalec.admin;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
				ps.setString(3, ShareVar.nowId);
				
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
				ps.setString(4, ShareVar.nowId);
				
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

		public ArrayList<Bean> ConditionList(String conditionQueryColumn, String querykey, String WhereCheck) {
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select userid, username, useremail, useraddtime, userblindtime, admin from user ";
			String WhereDefault2 = WhereCheck+ conditionQueryColumn + " like '%" + querykey + "%'";
//			System.out.println(WhereDefault+WhereDefault2);
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);

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
		public String blindcheck(String tablePK) {
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
		public boolean UpdateBlindtime(String tkSequence, int i) {
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
	
	
	
	
	
}
