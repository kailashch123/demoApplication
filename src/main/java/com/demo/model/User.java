package com.demo.model;

public class User {
	
	private String userId;
	private String firstName;
	private String lastName;
	private String password;
	
	

	public User(String userId, String firstName, String lastName, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString(){
	    String foo = "userId: "+ this.userId + ". firstName:" + this.firstName + ". lastName:" + lastName; //example
	    return foo;

}
}
