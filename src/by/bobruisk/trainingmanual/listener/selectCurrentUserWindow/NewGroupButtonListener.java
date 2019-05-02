package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;

public class NewGroupButtonListener implements ActionListener {

	private SelectCurrentUserWindow selectCurrentUserWindow;

	public NewGroupButtonListener(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!selectCurrentUserWindow.groupsPanel.newGroupTextField.getText().isEmpty()) {
			String groupName = selectCurrentUserWindow.groupsPanel.newGroupTextField.getText();
			selectCurrentUserWindow.mainWindow.usersDataBase.addNewEmptyGroup(groupName);
			selectCurrentUserWindow.groupsPanel.refreshComboBoxModelData();
			selectCurrentUserWindow.groupsPanel.newGroupTextField.setText("");
		} else {
			JOptionPane.showMessageDialog(selectCurrentUserWindow, "Введите название новой группы", "Ошибка",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
