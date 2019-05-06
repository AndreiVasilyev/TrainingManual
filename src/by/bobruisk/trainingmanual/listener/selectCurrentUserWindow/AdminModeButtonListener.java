package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;

public class AdminModeButtonListener implements ActionListener {

	private SelectCurrentUserWindow selectCurrentUserWindow;

	public AdminModeButtonListener(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		selectCurrentUserWindow.mainWindow.usersDataBase.setCurrentUser(null);
		selectCurrentUserWindow.mainWindow.mainPanel.currentUserNameLable
				.setText(selectCurrentUserWindow.mainWindow.usersDataBase.getDefaultUser());
		selectCurrentUserWindow.mainWindow.mainPanel.selectUserButton.setEnabled(true);
		selectCurrentUserWindow.dispose();

	}

}
