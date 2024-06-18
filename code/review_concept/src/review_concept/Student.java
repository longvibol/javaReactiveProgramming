package review_concept;

import java.util.List;

public class Student {
	private String name;
	private String gender;
	private int age;
	private List<String> subjects;
	
	
	
	
	public Student(String name, String gender, int age, List<String> subjects) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.subjects = subjects;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	
	

}
