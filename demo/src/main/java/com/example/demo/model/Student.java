package com.example.demo.model;

public class Student {
	private String regNo;
	private String name;
	private int age;
	private String course;
	private double gpa;
	
	
	public Student(String regNo,String name, int age, String course, double gpa) {
		this.regNo=regNo;
		this.name=name;
		this.age=age;
		this.course=course;
		this.gpa=gpa;
		
	}
	
	
	public String getRegNo() {
		return regNo;
	}
	
	
	
	public void setRegNo(String regNo) {
		this.regNo=regNo;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	
	public String getCourse() {
		return course;
	}
	
	
	public void setCourse(String course) {
		this.course=course;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	
	public void setGpa(double gpa) {
		this.gpa=gpa;
	}


	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

}
