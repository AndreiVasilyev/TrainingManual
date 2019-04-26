package by.bobruisk.trainingmanual.listener.inputpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class CloseInputNewQuestionPanelButton implements ActionListener {
	private MainWindow mainWindow;

	public CloseInputNewQuestionPanelButton(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainWindow.activateMenu();
		mainWindow.remove(mainWindow.inputNewQuestionPanel);
		mainWindow.inputNewQuestionPanel = null;
		mainWindow.createMainPanel();
		mainWindow.repaint();
	}

}
