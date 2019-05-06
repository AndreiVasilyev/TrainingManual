package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class SelectCurrentUserWindowListener implements WindowListener {

	private MainWindow mainWindow;

	public SelectCurrentUserWindowListener(MainWindow mainWindow) {

		this.mainWindow = mainWindow;

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {

		mainWindow.mainPanel.selectUserButton.setEnabled(true);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
