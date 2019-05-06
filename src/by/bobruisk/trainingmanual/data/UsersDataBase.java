package by.bobruisk.trainingmanual.data;

import java.util.ArrayList;
import java.util.List;

import by.bobruisk.trainingmanual.exceptionHandling.DataBaseException;
import by.bobruisk.trainingmanual.exceptionHandling.DataLoaderException;
import by.bobruisk.trainingmanual.model.Group;
import by.bobruisk.trainingmanual.model.Result;
import by.bobruisk.trainingmanual.model.Student;

public class UsersDataBase {

	private final String DEFAULT_USER = "administrator";
	private List<Group> groups;
	private Student currentUser;
	public StatFileLoader statFileLoader;

	public UsersDataBase() throws DataBaseException {

		statFileLoader = new StatFileLoader();
		try {
			groups = statFileLoader.getData();
		} catch (DataLoaderException currentException) {

			throw new DataBaseException("Ошибка загрузки статистики для БД  " + currentException.getMessage(),
					currentException);
		}
		if (groups == null) {
			groups = new ArrayList<Group>();
		}

	}

	public void addNewEmptyGroup(String groupName) {
		Group newGroup = new Group();
		List<Student> students = new ArrayList<Student>();
		newGroup.setStudents(students);
		newGroup.setGroupName(groupName);
		groups.add(newGroup);
		saveChanges();
	}

	public void addNewStudent(String name, String surname, Group group) {
		Student student = new Student();
		List<Result> passedTests = new ArrayList<Result>();
		student.setPassedTests(passedTests);
		student.setName(name);
		student.setSurname(surname);
		group.getStudents().add(student);
		saveChanges();
	}

	public void saveChanges() throws DataBaseException {
		try {

			statFileLoader.saveData(groups);

		} catch (DataLoaderException currentException) {

			throw new DataBaseException("Ошибка сохранения статистики из БД " + currentException.getMessage(),
					currentException);

		}

	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Student getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Student currentUser) {
		this.currentUser = currentUser;
	}

	public String getDefaultUser() {
		return DEFAULT_USER;
	}

}
