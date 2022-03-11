package com.unitbv.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String job;
    
    public User(int id, String firstName, String lastName, int age, String job) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.job = job;
	}

    public User() {
    	this.id = 0;
    	this.firstName = "";
    	this.lastName = "";
    	this.age = 0;
    	this.job = "";
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		
		return this.id == user.id &&
			   this.firstName.equals(user.firstName) &&
			   this.lastName.equals(user.lastName) &&
			   this.age == user.age &&
			   this.job.equals(user.job);
	}
}
