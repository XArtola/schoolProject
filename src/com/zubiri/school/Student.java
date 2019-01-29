package com.zubiri.school;

public class Student extends Person {

	private String studentID = "";
	private int absenses = 0;
	private String classroom = "";
	private int markAverage = 0;
	private int course = 0;
	private boolean repeater = false;

	public String getStudentID() {

		return studentID;
	}

	public void setStudentID(String studentID) {

		this.studentID = studentID;
	}

	public int getAbsenses() {

		return absenses;
	}

	public void setAbsenses(int absenses) {

		this.absenses = absenses;

	}

	public String getClassroom() {

		return classroom;
	}

	public void setClassroom(String classroom) {

		this.classroom = classroom;
	}

	public int getMarkAverage() {

		return markAverage;
	}

	public void setMarkAverage(int markAverage) {
		this.markAverage = markAverage;
	}
	
	public int getCourse() {
		return course;
		
	}
	
	public void setCourse(int course) {
		
		if( course> 0)
		
		this.course = course;
		
	}
	
	public boolean getRepeater() {
		
		return repeater;
	}
	
	public void setRepeater(boolean repeater) {
		
		this.repeater = repeater;
	}

 
}
