package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.ExceptionsDialogs;
import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;
import by.bobruisk.trainingmanual.model.Group;

public class NewStudentButtonListener implements ActionListener {

	private SelectCurrentUserWindow selectCurrentUserWindow;

	public NewStudentButtonListener(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (selectCurrentUserWindow.groupsPanel.allGroupsComboBox.getSelectedItem() != null) {
			if (!selectCurrentUserWindow.studentsPanel.nameTextField.getText().isEmpty()
					&& !selectCurrentUserWindow.studentsPanel.surnameTextField.getText().isEmpty()) {
				String name = selectCurrentUserWindow.studentsPanel.nameTextField.getText();
				String surname = selectCurrentUserWindow.studentsPanel.surnameTextField.getText();
				Group group = selectCurrentUserWindow.studentsPanel.currentGroup;
				selectCurrentUserWindow.mainWindow.usersDataBase.addNewStudent(name, surname, group);
				selectCurrentUserWindow.studentsPanel.refreshStudentsModel();
				selectCurrentUserWindow.studentsPanel.nameTextField.setText("");
				selectCurrentUserWindow.studentsPanel.surnameTextField.setText("");
			} else {

				ExceptionsDialogs.showWarningExceptionDialog("Введите Имя и Фамилию");

			}
		} else {

			ExceptionsDialogs.showWarningExceptionDialog("Нужно выбрать текущую группу!");

		}

	}

}
