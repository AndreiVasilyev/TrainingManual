package by.bobruisk.trainingmanual.listener.runtestpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class CloseInformationPanelButtonListener implements ActionListener {
	private MainWindow mainWindow;

	public CloseInformationPanelButtonListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainWindow.remove(mainWindow.resultTestInformationPanel);
		mainWindow.resultTestInformationPanel = null;
		mainWindow.activateMenu();
		mainWindow.createMainPanel();
		mainWindow.repaint();

	}

}
