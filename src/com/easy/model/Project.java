package com.easy.model;

public class Project {

	private int proid;
	private String proname;
	private String start_time;
	private String end_time;
	@Override
	public String toString() {
		return "Project [proid=" + proid + ", proname=" + proname
				+ ", start_time=" + start_time + ", end_time=" + end_time
				+ ", header=" + header + "]";
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getHeader() {
		return header;
	}
	public void setHeader(int header) {
		this.header = header;
	}
	public Project(int proid, String proname, String start_time,
			String end_time, int header) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.start_time = start_time;
		this.end_time = end_time;
		this.header = header;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int header;
	
}
