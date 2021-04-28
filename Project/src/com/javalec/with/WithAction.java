package com.javalec.with;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;




	public class WithAction {
//--------------------------------------------------------------------------------------------
	
	private final String url_mysql = ShareVar.DBName;
    private final String id_mysql = ShareVar.DBUser;
    private final String pw_mysql = ShareVar.DBPass;
	
	
	int seqno;
	int loginnumber = 1;
	String userid;//유저 아이디
	String title; //공지사항 제목
	String post; //공지사항 내용
	String date; //공지사항 제목
	FileInputStream file;
//--------------------------------------------------------------------------------------------

	public WithAction() {
		super();
	}
	
	public WithAction(int seqno) {
		super();
		this.seqno = seqno;
	}
	
//--------------------------------------------------------------------------------------------



	// 1:1 게시판 출력
	public ArrayList<Bean> QueryList(){
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select queryid, querytitle, querycontent from query ";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

            while(rs.next()){
            	
            	int wkSeq = rs.getInt(1);
            	String wktitle = rs.getString(2);
            	String wkcontent = rs.getString(3);
//		            	String wktime = rs.getString(4);
            	
            	Bean bean = new Bean(wkSeq, wktitle, wkcontent);
            	BeanList.add(bean);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return BeanList;
	}
	//1:1 table 클릭
	public Bean QueryTableClick() {
		System.out.println(seqno);
		Bean bean = null;
		String WhereDefault = "select queryid, querytitle, querycontent, querytime from query ";
		String WhereDefault2 = "where queryid = " + seqno;
		
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
//		            	// File
//		            	ShareVar.filename = ShareVar.filename + 1;
//		            	File file = new File(Integer.toString(ShareVar.filename));
//		            	FileOutputStream output = new FileOutputStream(file);
//		            	InputStream input = rs.getBinaryStream(7);
//		                byte[] buffer = new byte[1024];
//		                while (input.read(buffer) > 0) {
//		                    output.write(buffer);
//		                }
				
				bean = new Bean(wkSeq, wkTitle, wkContent);
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return bean;
		
		
	}
	//게시글 데이터 가져오기 (작성자 데이터로 공지사항인지 게시글인지 구분?)
	public ArrayList<Bean> DocumentList() {
		
		ArrayList<Bean> BeanList = new ArrayList<Bean>();
		
		String WhereDefault = "select documentid, documenttitle from Document";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
			
			while(rs.next()){
				
				int wkSeq = rs.getInt(1);
				String wktitle = rs.getString(2);
//				String wkcontent = rs.getString(3); 작성자
//		        String wktime = rs.getString(4); 작성시간
				
				Bean bean = new Bean(wkSeq, wktitle);
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
