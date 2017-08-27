package com.tanveer.collections.withXML.mapOfString;

import java.util.HashMap;
import java.util.Map;

public class Marksheet {
	
	Integer marksheetId;
	
	String studentName;
	
	Map<String, String> subjectMarks = new HashMap<String,String>();

	public Integer getMarksheetId() {
		return marksheetId;
	}

	public void setMarksheetId(Integer marksheetId) {
		this.marksheetId = marksheetId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Map<String, String> getSubjectMarks() {
		return subjectMarks;
	}

	public void setSubjectMarks(Map<String, String> subjectMarks) {
		this.subjectMarks = subjectMarks;
	}
	
	

}
