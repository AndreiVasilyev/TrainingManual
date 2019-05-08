package by.bobruisk.trainingmanual.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.bobruisk.trainingmanual.exceptionHandling.DataBaseException;
import by.bobruisk.trainingmanual.exceptionHandling.DataLoaderException;
import by.bobruisk.trainingmanual.model.Group;
import by.bobruisk.trainingmanual.model.Result;
import by.bobruisk.trainingmanual.model.Student;
import by.bobruisk.trainingmanual.run.Run;

public class UsersDataBase {

	private final static Logger LOGGER = Logger.getLogger(Run.class);
	private final String DEFAULT_USER = "administrator";
	private List<Group> groups;
	private Student currentUser;
	public StatFileLoader statFileLoader;

	public UsersDataBase() throws DataBaseException {

		LOGGER.info("start creation UsersDataBase");
		statFileLoader = new StatFileLoader();
		try {

			LOGGER.warn("try load groups");
			groups = statFileLoader.getData();
			LOGGER.warn("loading OK");

		} catch (DataLoaderException currentException) {

			LOGGER.error("loading failed", currentException);
			throw new DataBaseException("Ошибка загрузки статистики для БД  " + currentException.getMessage(),
					currentException);
		}
		if (groups == null) {
			groups = new ArrayList<Group>();
		}

	}

	public void addNewEmptyGroup(String groupName) {

		LOGGER.info("start addNewEmptyGroup()");
		Group newGroup = new Group();
		List<Student> students = new ArrayList<Student>();
		newGroup.setStudents(students);
		newGroup.setGroupName(groupName);
		groups.add(newGroup);
		saveChanges();
	}

	public void addNewStudent(String name, String surname, Group group) {

		LOGGER.info("start addNewStudent()");
		Student student = new Student();
		List<Result> passedTests = new ArrayList<Result>();
		student.setPassedTests(passedTests);
		student.setName(name);
		student.setSurname(surname);
		group.getStudents().add(student);
		saveChanges();
	}

	public void saveChanges() throws DataBaseException {

		LOGGER.info("start saveChanges()");
		try {

			LOGGER.warn("try save changes");
			statFileLoader.saveData(groups);
			LOGGER.warn("saving OK");

		} catch (DataLoaderException currentException) {

			LOGGER.error("saving failed", currentException);
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
