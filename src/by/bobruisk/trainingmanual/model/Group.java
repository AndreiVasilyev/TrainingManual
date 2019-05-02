package by.bobruisk.trainingmanual.model;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String groupName;
	private List<Student> students;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {

		return groupName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Group group = (Group) obj;
		return (groupName == group.groupName || (groupName != null && groupName.equals(group.getGroupName())));

	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		return result;

	}
}
