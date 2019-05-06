package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import by.bobruisk.trainingmanual.gui.ExceptionsDialogs;
import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;
import by.bobruisk.trainingmanual.model.Student;

public class RandomStudentButtonListener implements ActionListener {

	private SelectCurrentUserWindow selectCurrentUserWindow;

	public RandomStudentButtonListener(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (selectCurrentUserWindow.studentsPanel.studentsForModel != null
				&& !selectCurrentUserWindow.studentsPanel.studentsForModel.isEmpty()) {

			int studentsCount = selectCurrentUserWindow.studentsPanel.studentsForModel.size();
			Random random = new Random();
			int selectedStudentIndex = random.nextInt(studentsCount);
			selectCurrentUserWindow.studentsPanel.studentsList.setSelectedIndex(selectedStudentIndex);
			String selectedStudentName = selectCurrentUserWindow.studentsPanel.studentsList.getSelectedValue();
			List<Student> students = selectCurrentUserWindow.studentsPanel.currentGroup.getStudents();
			Student selectedStudent = students.stream()
					.filter(Student -> Student.toString().equals(selectedStudentName)).findFirst().get();
			selectCurrentUserWindow.mainWindow.usersDataBase.setCurrentUser(selectedStudent);
			selectCurrentUserWindow.mainWindow.mainPanel.currentUserNameLable.setText(selectedStudent.toString());
			selectCurrentUserWindow.mainWindow.mainPanel.selectUserButton.setEnabled(true);
			selectCurrentUserWindow.dispose();

		} else {

			ExceptionsDialogs.showWarningExceptionDialog("Нет студентов для выбора");

		}

	}

}
