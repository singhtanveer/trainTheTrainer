package com.tanveer.collections.withXML.listOfString;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	Integer questionId;
	String questionName;
	List<String> answers = new ArrayList<String>();
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
}
