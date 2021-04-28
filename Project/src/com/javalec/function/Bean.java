package com.javalec.function;

public class Bean {
	
	public static int seqIndex;
	
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


