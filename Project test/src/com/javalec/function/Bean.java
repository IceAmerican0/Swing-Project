package com.javalec.function;

import java.io.InputStream;

public class Bean {

	String userid;
	String User_userid;
	String	username;
	int tablePK;
//	int clothid;
//	int documentid;
//	int queryid;
//	int answerid;
//	int commentid;
	
//	int tableFK;
//	int Query_queryid;
//	int Document_documentid;
//	int Cloth_clothid;
//--------------------------------------------------------------------
	String content;
//	String	documentcontent;
//	String	commentcontent;
//	String	querycontent;
//	String	clothname;
	String name;
	String title; //
	String	clothtype;
//	String	answercontent;
//	String	documenttitle;
//	String	querytitle;
	String	addtime;
	String	blindtime;
	InputStream	clothimage;
	int	likecount;
	int	documenttype;
	String	liketime;
	String	userpw;
	String	useremail;
	String	useraddtime;
	String	userblindtime;
	int	admin;
	String	userimage;
//----------------------------------------------------------------------------

	
	public Bean(int tablePK, String content) {
		super();
		this.tablePK = tablePK;
		this.content = content;
	}
	public Bean(int tablePK, String title, String content, InputStream clothimage, String addtime, String blindtime,
			 String user_userid) {
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.content = content;
		this.clothimage = clothimage;
		this.addtime = addtime;
		this.blindtime = blindtime;
		User_userid = user_userid;
	}
	public Bean(int tablePK, String title, String addtime, String username) {
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.username = username;
		this.addtime = addtime;
	}
	//----------------------------------------------------------------------------
	
	
	public Bean(int tablePK, String title, String content, String addtime, String username) {
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.content = content;
		this.addtime = addtime;
		this.username = username;
	}
	public Bean(String userid, String username, String useremail, String useraddtime, String userblindtime, int admin) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.useraddtime = useraddtime;
		this.userblindtime = userblindtime;
		this.admin = admin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUser_userid() {
		return User_userid;
	}
	public void setUser_userid(String user_userid) {
		User_userid = user_userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTablePK() {
		return tablePK;
	}
	public void setTablePK(int tablePK) {
		this.tablePK = tablePK;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getBlindtime() {
		return blindtime;
	}
	public void setBlindtime(String blindtime) {
		this.blindtime = blindtime;
	}
	public String getClothtype() {
		return clothtype;
	}
	public void setClothtype(String clothtype) {
		this.clothtype = clothtype;
	}
	
	public InputStream getClothimage() {
		return clothimage;
	}
	public void setClothimage(InputStream clothimage) {
		this.clothimage = clothimage;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getDocumenttype() {
		return documenttype;
	}
	public void setDocumenttype(int documenttype) {
		this.documenttype = documenttype;
	}
	public String getLiketime() {
		return liketime;
	}
	public void setLiketime(String liketime) {
		this.liketime = liketime;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUseraddtime() {
		return useraddtime;
	}
	public void setUseraddtime(String useraddtime) {
		this.useraddtime = useraddtime;
	}
	public String getUserblindtime() {
		return userblindtime;
	}
	public void setUserblindtime(String userblindtime) {
		this.userblindtime = userblindtime;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getUserimage() {
		return userimage;
	}
	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}
	
}