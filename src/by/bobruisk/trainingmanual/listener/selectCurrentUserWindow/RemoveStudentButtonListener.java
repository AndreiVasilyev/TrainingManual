package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;
import by.bobruisk.trainingmanual.model.Student;

public class RemoveStudentButtonListener implements ActionListener {

	private SelectCurrentUserWindow selectCurrentUserWindow;

	public RemoveStudentButtonListener(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (!selectCurrentUserWindow.studentsPanel.studentsList.isSelectionEmpty()) {
			String selectedStudentName = selectCurrentUserWindow.studentsPanel.studentsList.getSelectedValue();
			List<Student> studentsForModel = selectCurrentUserWindow.studentsPanel.studentsForModel;
			Student selectedStudent = studentsForModel.stream()
					.filter(Student -> Student.toString().equals(selectedStudentName)).findFirst().get();
			studentsForModel.remove(selectedStudent);
			selectCurrentUserWindow.studentsPanel.refreshStudentsList();

		} else {

			JOptionPane.showMessageDialog(selectCurrentUserWindow, "Необходимо выбрать студента!", "Ошибка",
					JOptionPane.WARNING_MESSAGE);
		}

	}

}
