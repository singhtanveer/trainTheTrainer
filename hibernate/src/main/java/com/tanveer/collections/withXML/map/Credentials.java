package com.tanveer.collections.withXML.map;

public class Credentials {
	
	Integer credentialId;
	String loginId;
	String password;
	String secretQuestion;
	String secretAnswer;
	public Credentials(String loginId, String password, String secretQuestion, String secretAnswer) {
		this.loginId = loginId;
		this.password = password;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public Integer getCredentialId() {
		return credentialId;
	}
	public void setCredentialId(Integer credentialId) {
		this.credentialId = credentialId;
	}

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
