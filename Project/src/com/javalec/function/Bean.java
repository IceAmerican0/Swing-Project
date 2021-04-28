package com.javalec.function;

public class Bean {
	
	
	//Primary key
	public static int userid;
	public static int queryid;
	public static int answerid;
	public static int clothid;
	public static int commentid;
	public static int documentid;
	//foreign key
	int query_queryid;
	int document_documentid;
	int User_userid;
	int Cloth_clothid;
	int answer_answerid;
	int answer_query_queryid;
	int comment_commentid;
	int comment_document_documentid;
	//not primary
	int	documenttype;
	int	likecount;
	String	userpw;
	String	useremail;
	String	username;
	String	useraddtime;
	String	userblindtime;
	String	documenttitle;
	String	documentcontent;
	String	commentcontent;
	String	clothtype;
	String	clothname;
	String	liketime;
	String	querytitle;
	String	querycontent;
	String	answercontent;
	String	addtime;
	String	blindtime;
	int	admin;
	String	clothimage;
	String	userimage;
	//
	public Bean(int seq, String documentcontent, String addtime) {
		super();
		this.documentid = seq;
		this.documentcontent = documentcontent;
		this.addtime = addtime;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//
	public static int getUserid() {
		return userid;
	}
	public static void setUserid(int userid) {
		Bean.userid = userid;
	}
	public static int getQueryid() {
		return queryid;
	}
	public static void setQueryid(int queryid) {
		Bean.queryid = queryid;
	}
	public static int getAnswerid() {
		return answerid;
	}
	public static void setAnswerid(int answerid) {
		Bean.answerid = answerid;
	}
	public static int getClothid() {
		return clothid;
	}
	public static void setClothid(int clothid) {
		Bean.clothid = clothid;
	}
	public static int getCommentid() {
		return commentid;
	}
	public static void setCommentid(int commentid) {
		Bean.commentid = commentid;
	}
	public static int getDocumentid() {
		return documentid;
	}
	public static void setDocumentid(int documentid) {
		Bean.documentid = documentid;
	}
	public int getQuery_queryid() {
		return query_queryid;
	}
	public void setQuery_queryid(int query_queryid) {
		this.query_queryid = query_queryid;
	}
	public int getDocument_documentid() {
		return document_documentid;
	}
	public void setDocument_documentid(int document_documentid) {
		this.document_documentid = document_documentid;
	}
	public int getUser_userid() {
		return User_userid;
	}
	public void setUser_userid(int user_userid) {
		User_userid = user_userid;
	}
	public int getCloth_clothid() {
		return Cloth_clothid;
	}
	public void setCloth_clothid(int cloth_clothid) {
		Cloth_clothid = cloth_clothid;
	}
	public int getAnswer_answerid() {
		return answer_answerid;
	}
	public void setAnswer_answerid(int answer_answerid) {
		this.answer_answerid = answer_answerid;
	}
	public int getAnswer_query_queryid() {
		return answer_query_queryid;
	}
	public void setAnswer_query_queryid(int answer_query_queryid) {
		this.answer_query_queryid = answer_query_queryid;
	}
	public int getComment_commentid() {
		return comment_commentid;
	}
	public void setComment_commentid(int comment_commentid) {
		this.comment_commentid = comment_commentid;
	}
	public int getComment_document_documentid() {
		return comment_document_documentid;
	}
	public void setComment_document_documentid(int comment_document_documentid) {
		this.comment_document_documentid = comment_document_documentid;
	}
	public int getDocumenttype() {
		return documenttype;
	}
	public void setDocumenttype(int documenttype) {
		this.documenttype = documenttype;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getDocumenttitle() {
		return documenttitle;
	}
	public void setDocumenttitle(String documenttitle) {
		this.documenttitle = documenttitle;
	}
	public String getDocumentcontent() {
		return documentcontent;
	}
	public void setDocumentcontent(String documentcontent) {
		this.documentcontent = documentcontent;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public String getClothtype() {
		return clothtype;
	}
	public void setClothtype(String clothtype) {
		this.clothtype = clothtype;
	}
	public String getClothname() {
		return clothname;
	}
	public void setClothname(String clothname) {
		this.clothname = clothname;
	}
	public String getLiketime() {
		return liketime;
	}
	public void setLiketime(String liketime) {
		this.liketime = liketime;
	}
	public String getQuerytitle() {
		return querytitle;
	}
	public void setQuerytitle(String querytitle) {
		this.querytitle = querytitle;
	}
	public String getQuerycontent() {
		return querycontent;
	}
	public void setQuerycontent(String querycontent) {
		this.querycontent = querycontent;
	}
	public String getAnswercontent() {
		return answercontent;
	}
	public void setAnswercontent(String answercontent) {
		this.answercontent = answercontent;
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
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getClothimage() {
		return clothimage;
	}
	public void setClothimage(String clothimage) {
		this.clothimage = clothimage;
	}
	public String getUserimage() {
		return userimage;
	}
	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}

	



}


