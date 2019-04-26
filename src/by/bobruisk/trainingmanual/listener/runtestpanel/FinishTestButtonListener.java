package by.bobruisk.trainingmanual.listener.runtestpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import by.bobruisk.trainingmanual.gui.MainWindow;

public class FinishTestButtonListener implements ActionListener {
	private MainWindow mainWindow;

	public FinishTestButtonListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		mainWindow.remove(mainWindow.runTestPanel);
		mainWindow.runTestPanel = null;
		mainWindow.createResultTestInformationPanel();
		mainWindow.repaint();
	}

}
