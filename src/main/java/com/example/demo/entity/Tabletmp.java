package com.example.demo.entity;

import java.util.Date;

public class Tabletmp {
	private int id;
	
	private String acloumn;
	
	private String title;
	
	private String acontent;
	
	private String author;


	private String subtitle;
	
	private String titlehref;
	
	private String source;
	
	private String people;
	
	private String draft;
	
	
	private String Abstract;
	
	private Date releasedate;
	
	private String image;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the abstract
	 */
	public String getAbstract() {
		return Abstract;
	}

	/**
	 * @param abstract1 the abstract to set
	 */
	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the acloumn
	 */
	public String getAcloumn() {
		return acloumn;
	}

	/**
	 * @param acloumn the acloumn to set
	 */
	public void setAcloumn(String acloumn) {
		this.acloumn = acloumn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the acontent
	 */
	public String getAcontent() {
		return acontent;
	}

	/**
	 * @param acontent the acontent to set
	 */
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @return the titlehref
	 */
	public String getTitlehref() {
		return titlehref;
	}

	/**
	 * @param titlehref the titlehref to set
	 */
	public void setTitlehref(String titlehref) {
		this.titlehref = titlehref;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the people
	 */
	public String getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(String people) {
		this.people = people;
	}

	/**
	 * @return the draft
	 */
	public String getDraft() {
		return draft;
	}

	/**
	 * @param draft the draft to set
	 */
	public void setDraft(String draft) {
		this.draft = draft;
	}

	/**
	 * @return the releasedate
	 */
	public Date getReleasedate() {
		return releasedate;
	}

	/**
	 * @param releasedate the releasedate to set
	 */
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

}
