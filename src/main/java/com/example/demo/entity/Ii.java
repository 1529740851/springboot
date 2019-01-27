package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

public class Ii implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id1;
	private String id2;
	private String id3;

	public Ii(String id1, String id2, String id3) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.id3 = id3;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getId3() {
		return id3;
	}

	public void setId3(String id3) {
		this.id3 = id3;
	}

	@Override
	public String toString() {
		return "Ii [id1=" + id1 + ", id2=" + id2 + ", id3=" + id3 + "]";
	}

}
