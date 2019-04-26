package by.bobruisk.trainingmanual.gui;

import javax.swing.JOptionPane;

public class ExceptionsDialods {
	private static MainWindow mainWindow;

	public ExceptionsDialods(MainWindow mainWindow) {
		ExceptionsDialods.mainWindow = mainWindow;
	}

	public static void showReadExceptionDialog(String sourseException, String message) {
		JOptionPane.showMessageDialog(mainWindow, message, sourseException, JOptionPane.ERROR_MESSAGE);
	}

	public static void showWriteExceptionDialog(String sourseException, String message) {
		JOptionPane.showMessageDialog(mainWindow, message, sourseException, JOptionPane.WARNING_MESSAGE);
	}
}
