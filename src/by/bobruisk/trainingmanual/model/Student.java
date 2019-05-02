package by.bobruisk.trainingmanual.model;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private List<Result> passedTests;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Result> getPassedTests() {
		return passedTests;
	}

	public void setPassedTests(List<Result> passedTests) {
		this.passedTests = passedTests;
	}

	@Override
	public String toString() {

		return surname + " " + name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Student student = (Student) obj;
		return (name == student.name || (name != null && name.equals(student.getName())))
				&& (surname == student.surname || (surname != null && surname.equals(student.getSurname())));

	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;

	}
}
