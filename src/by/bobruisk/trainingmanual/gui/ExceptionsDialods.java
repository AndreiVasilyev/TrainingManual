package by.bobruisk.trainingmanual.gui;

import javax.swing.JOptionPane;

public class ExceptionsDialods {
	private static MainWindow mainWindow;

	public ExceptionsDialods(MainWindow mainWindow) {
		ExceptionsDialods.mainWindow = mainWindow;
	}

	public static void showFatalExceptionDialog(String message) {
		JOptionPane.showMessageDialog(mainWindow, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
	}

	public static void showWarningExceptionDialog(String message) {
		JOptionPane.showMessageDialog(mainWindow, message, "Ошибка", JOptionPane.WARNING_MESSAGE);
	}
}
