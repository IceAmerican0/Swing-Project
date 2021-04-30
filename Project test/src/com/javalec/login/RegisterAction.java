package com.javalec.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javalec.function.ShareVar;
import com.javalec.function.Bean;


public class RegisterAction {
	private final String url_mysql=ShareVar.url_mysql;	
	private final String id_mysql=ShareVar.id_mysql;	
	private final String pw_mysql=ShareVar.pw_mysql;
	
	String id;
	String pw1;
	String pw2;
	String name;
	String email;
	
	public RegisterAction() {
		// TODO Auto-generated constructor stub
	}
	
	public RegisterAction(String id, String pw1, String name,String email) {
		super();
		this.id = id;
		this.pw1 = pw1;
		this.name = name;
		this.email=email;
	}
	//-----
	// 검색 결과를 Table로 
	public ArrayList<Bean> SelectList(){
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select seqno, name, telno, relation from userinfo2 ";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

            while(rs.next()){
            	
            	int wkSeq = rs.getInt(1);
            	String wkName = rs.getString(2);
            	String wkTelno = rs.getString(3);
            	String wkRelation = rs.getString(4);
            	
            	Bean bean = new Bean(wkSeq, wkName, wkTelno, wkRelation);
            	BeanList.add(bean);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return BeanList;
	}


	//-----
	public void Register() {
		String sql="insert into user(userid,userpw,useremail,username,admin) values (?,?,?,?,0)";
		
		try{
			PreparedStatement ps=null;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ps=conn_mysql.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw1);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, name+"님의 정보가 입력됐습니다!");
			
	        conn_mysql.close();
	    }
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	}
	
	public int Idchk(String inputId) {
		String sql1="select userid from user where";
		String sql2=" user.userid='"+inputId+"'";
		String userid="";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          ResultSet rs = stmt_mysql.executeQuery(sql1+sql2);
	          while(rs.next()) {
	        	  userid=rs.getString(1);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
		

//1= 이미 가입된 아이디입니다
//0= 가입가능
		if(userid.equals(id)) return 1;
		else return 0;
	}
	
	public int Emailchk(String inputEmail) {
		String sql1="select useremail from user where";
		String sql2=" user.useremail='"+inputEmail+"'";
		String useremail="";
		
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          ResultSet rs = stmt_mysql.executeQuery(sql1+sql2);
	          while(rs.next()) {
	        	  useremail=rs.getString(1);
	          }
	          conn_mysql.close();
	      }
	      catch (Exception e){
	          e.printStackTrace();
	      }
		

		//1= 이미 가입된 이메일입니다
		//0= 가입가능
		if(useremail.equals(email)) return 1;
		else return 0;
	}
}