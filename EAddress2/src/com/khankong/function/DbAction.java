package com.khankong.function;

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

import com.khankong.function.ShareVar;


public class DbAction {

    private final String url_mysql = ShareVar.DBName;
    private final String id_mysql = ShareVar.DBUser;
    private final String pw_mysql = ShareVar.DBPass;
	
	int seqno;
	String name;
	String telno;
	String address;
	String email;
	String relation;
	String conname;
	String condata;
	FileInputStream file;

	public DbAction() {
		super();
	}

	public DbAction(int seqno, String name, String telno, String address, String email, String relation, FileInputStream file) {
		super();
		this.seqno = seqno;
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.relation = relation;
		this.file = file;
	}
	
	public DbAction(String name, String telno, String address, String email, String relation, FileInputStream file) {
		super();
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.relation = relation;
		this.file = file;
	}

	public DbAction(int seqno) {
		super();
		this.seqno = seqno;
	}

	public DbAction(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}

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

	// Table을 Click하였을 경우
	public Bean TableClick() {
		Bean bean = null;
		String WhereDefault = "select seqno, name, telno, address, email, relation, file from userinfo2 ";
		String WhereDefault2 = "where seqno = " + seqno;
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
            
            

            if(rs.next()){
            	
            	int wkSeq = rs.getInt(1);
            	String wkName = rs.getString(2);
            	String wkTelno = rs.getString(3);
            	String wkAddress = rs.getString(4);
            	String wkEmail = rs.getString(5);
            	String wkRelation = rs.getString(6);
            	// File
            	ShareVar.filename = ShareVar.filename + 1;
            	File file = new File(Integer.toString(ShareVar.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(7);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            	
            bean = new Bean(wkSeq, wkName, wkTelno, wkAddress, wkEmail, wkRelation);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		
		return bean;
	}
	
	
	//조건 검색 결과를 Table로 
	public ArrayList<Bean> ConditionList(){
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select seqno, name, telno, relation from userinfo2 ";
		String WhereDefault2 = "where " + conname + " like '%" + condata + "%'";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);

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

	
	// 입력
	public boolean InsertAction() {
	      PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "insert into userinfo2 (name, telno, address, email, relation, file";
	          String B = ") values (?,?,?,?,?,?)";
	
	          ps = conn_mysql.prepareStatement(A+B);
	          ps.setString(1, name.trim());
	          ps.setString(2, telno.trim());
	          ps.setString(3, address.trim());
	          ps.setString(4, email.trim());
	          ps.setString(5, relation.trim());
	          ps.setBinaryStream(6, file);
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
	}
	
	// 수정
	public boolean UpdateAction() {
		  PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String A = "update userinfo2 set name = ?, telno = ?, address = ?, email = ?, relation = ?, file = ? ";
		      String B = " where seqno = ? ";
		
		      ps = conn_mysql.prepareStatement(A+B);
		      
		      ps.setString(1, name);
		      ps.setString(2, telno);
		      ps.setString(3, address);
		      ps.setString(4, email);
		      ps.setString(5, relation);
		      ps.setBinaryStream(6, file);
		      ps.setInt(7, seqno);
		      ps.executeUpdate();
		
		      conn_mysql.close();
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }
		
		  return true;
	}

	// 삭제
	public boolean DeleteAction() {
	      PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "delete from userinfo2 where seqno = ? ";
	
	          ps = conn_mysql.prepareStatement(A);
	          
	          ps.setInt(1, seqno);
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
	}
	
}// ------------
