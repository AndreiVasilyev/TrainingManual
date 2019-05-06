package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import by.bobruisk.trainingmanual.gui.ExceptionsDialogs;
import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;
import by.bobruisk.trainingmanual.model.Student;

public class SelectStudentButtonListener implements ActionListener {

	private SelectCurrentUserWindow selectCurrentUserWindow;

	public SelectStudentButtonListener(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (!selectCurrentUserWindow.studentsPanel.studentsList.isSelectionEmpty()) {

			String selectedStudentName = selectCurrentUserWindow.studentsPanel.studentsList.getSelectedValue();
			List<Student> students = selectCurrentUserWindow.studentsPanel.currentGroup.getStudents();
			Student selectedStudent = students.stream()
					.filter(Student -> Student.toString().equals(selectedStudentName)).findFirst().get();
			selectCurrentUserWindow.mainWindow.usersDataBase.setCurrentUser(selectedStudent);
			selectCurrentUserWindow.mainWindow.mainPanel.currentUserNameLable.setText(selectedStudent.toString());
			selectCurrentUserWindow.mainWindow.mainPanel.selectUserButton.setEnabled(true);
			selectCurrentUserWindow.dispose();

		} else {

			ExceptionsDialogs.showWarningExceptionDialog("Нет выбранного студента!");

		}

	}

}
