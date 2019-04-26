package by.bobruisk.trainingmanual.listener.mainwindowelements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class RunTestMenuItemListener implements ActionListener {
	private MainWindow mainWindow;

	public RunTestMenuItemListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		mainWindow.deactivateMenu();
		mainWindow.questionsDataBase.resetTest();
		mainWindow.remove(mainWindow.mainPanel);
		mainWindow.mainPanel = null;
		mainWindow.createRunTestPanel();

	}

}
