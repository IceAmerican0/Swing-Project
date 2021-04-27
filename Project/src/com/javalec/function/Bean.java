package com.javalec.function;

public class Bean {
	
	int seqno;
	String name;
	String telno;
	String address;
	String email;
	String relation;
	
	public Bean(int seqno, String name, String telno, String address, String email, String relation) {
		super();
		this.seqno = seqno;
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}

	
	
	public Bean(int seqno, String name, String telno, String relation) {
		super();
		this.seqno = seqno;
		this.name = name;
		this.telno = telno;
		this.relation = relation;
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

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	} 
	

}

