package by.bobruisk.trainingmanual.listener.mainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import by.bobruisk.trainingmanual.gui.MainWindow;
import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;

public class SelectUserButtonListener implements ActionListener {

	private MainWindow mainWindow;

	public SelectUserButtonListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		mainWindow.mainPanel.selectUserButton.setEnabled(false);
		new SelectCurrentUserWindow(mainWindow);

	}

}
