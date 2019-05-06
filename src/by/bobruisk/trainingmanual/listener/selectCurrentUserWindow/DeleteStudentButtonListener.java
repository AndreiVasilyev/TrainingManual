package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import by.bobruisk.trainingmanual.gui.ExceptionsDialogs;
import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;
import by.bobruisk.trainingmanual.model.Student;

public class DeleteStudentButtonListener implements ActionListener {

	private SelectCurrentUserWindow selectCurrentUserWindow;

	public DeleteStudentButtonListener(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (!selectCurrentUserWindow.studentsPanel.studentsList.isSelectionEmpty()) {
			String selectedStudentName = selectCurrentUserWindow.studentsPanel.studentsList.getSelectedValue();
			List<Student> students = selectCurrentUserWindow.studentsPanel.currentGroup.getStudents();
			Student selectedStudent = students.stream()
					.filter(student -> student.toString().equals(selectedStudentName)).findFirst().get();
			students.remove(selectedStudent);
			selectCurrentUserWindow.studentsPanel.refreshStudentsModel();
			selectCurrentUserWindow.studentsPanel.refreshStudentsList();

		} else {

			ExceptionsDialogs.showWarningExceptionDialog("Необходимо выбрать студента!");

		}

	}

}
