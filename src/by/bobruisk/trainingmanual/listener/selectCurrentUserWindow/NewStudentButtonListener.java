package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(selectCurrentUserWindow, "Введите Имя и Фамилию", "Ошибка",
						JOptionPane.WARNING_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(selectCurrentUserWindow, "Нужно выбрать текущую группу!", "Ошибка",
					JOptionPane.WARNING_MESSAGE);
		}

	}

}
