package by.bobruisk.trainingmanual.listener.mainwindowelements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import by.bobruisk.trainingmanual.gui.MainWindow;

public class AdministrationModeItemListener implements ActionListener {
	private MainWindow mainWindow;

	public AdministrationModeItemListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		mainWindow.deactivateMenu();
		mainWindow.createLoginDialog();

	}
}
