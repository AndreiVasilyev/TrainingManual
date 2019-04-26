package by.bobruisk.trainingmanual.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import by.bobruisk.trainingmanual.gui.MainWindow;

public class DialogWindowListener implements WindowListener {

	private MainWindow mainWindow;

	public DialogWindowListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

		mainWindow.getJMenuBar().getMenu(0).setEnabled(true);
		mainWindow.getJMenuBar().validate();
		mainWindow.getJMenuBar().repaint();

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
