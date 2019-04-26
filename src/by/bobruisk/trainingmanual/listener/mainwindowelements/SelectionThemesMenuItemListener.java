package by.bobruisk.trainingmanual.listener.mainwindowelements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class SelectionThemesMenuItemListener implements ActionListener {
	private MainWindow mainWindow;

	public SelectionThemesMenuItemListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		mainWindow.deactivateMenu();
		mainWindow.remove(mainWindow.mainPanel);
		mainWindow.mainPanel = null;
		mainWindow.createSelectionThemesPanel();

	}

}
