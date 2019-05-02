package by.bobruisk.trainingmanual.listener.statisticsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class ClosePanelButtonListener implements ActionListener {

	private MainWindow mainWindow;

	public ClosePanelButtonListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainWindow.remove(mainWindow.viewStatisticPanel);
		mainWindow.viewStatisticPanel = null;
		mainWindow.activateMenu();
		mainWindow.createMainPanel();
		mainWindow.repaint();
	}

}
