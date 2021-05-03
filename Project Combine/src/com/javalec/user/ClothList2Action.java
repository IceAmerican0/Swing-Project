package com.javalec.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;


public class ClothList2Action {
	
	// field
	int clothid;
	String clothtype;
	String clothname;
	String blindtime;
	FileInputStream file;
	
	int seqno;
	
	// constructor
	public ClothList2Action() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ClothList2Action(int seqno) {
		super();
		this.seqno = seqno;
	}


	// method
	public ArrayList<Bean> ConditionList(String ConditionQueryColumn){
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select clothid, clothtype, clothname from cloth ";
		String WhereDefault2 = "where clothtype = " + ConditionQueryColumn;
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);

            while(rs.next()){
            	
            	int wkclothid = rs.getInt(1);
            	String wkclothtype = rs.getString(2);
            	String wkclothname = rs.getString(3);
            	
            	Bean bean = new Bean(wkclothid, wkclothtype, wkclothname);
            	BeanList.add(bean);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return BeanList;
	}
	
	public void TableClick() {
		Bean bean = null;
		String WhereDefault = "select clothimage from cloth ";
		String WhereDefault2 = "where clothid = " + seqno;
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
            
            

            if(rs.next()){
            	
            	// File
            	ShareVar.filename = ShareVar.filename + 1;
            	File file = new File(Integer.toString(ShareVar.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(1);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            	
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		
	}
	
	// 검색 결과를 Table로 
		public ArrayList<Bean> SelectList(){
			
			ArrayList<Bean> BeanList = new ArrayList<Bean>();
			
			String WhereDefault = "select clothid, clothtype, clothname from cloth ";
			
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

	            while(rs.next()){
	            	
	            	int wkclothid = rs.getInt(1);
	            	String wkclothtype = rs.getString(2);
	            	String wkTclothname = rs.getString(3);
	            	
	            	Bean bean = new Bean(wkclothid, wkclothtype, wkTclothname);
	            	BeanList.add(bean);
	            }
	            
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return BeanList;
		}
}
