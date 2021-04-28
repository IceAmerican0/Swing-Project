package com.javalec.function;

public class Bean {
	
	
	//Primary key
	public static int userid;
	public static int queryid;
	public static int answerid;
	public static int clothid;
	public static int commentid;
	public static int documentid;
	
	int query_queryid;
	int document_documentid;
	int User_userid;
	int Cloth_clothid;
	int answer_answerid;
	int answer_query_queryid;
	int comment_commentid;
	int comment_document_documentid;

	//
	
	
	int seqno;
	String name;
	String title;
	String content;
	String time;
	
	public Bean(int seqno, String title, String content) {
		super();
		this.seqno = seqno;
		this.title = title;
		this.content = content;
		this.time = time;
	}

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}





}


