package by.bobruisk.trainingmanual.gui;

import javax.swing.JOptionPane;

public class ExceptionsDialogs {
	private static MainWindow mainWindow;
	public static final String READ_ERROR= "Ошибка чтения";
	public static final String WRITE_ERROR= "Ошибка записи";
	public static final String TITLE_TEXT= "Ошибка";

	public ExceptionsDialogs(MainWindow mainWindow) {
		ExceptionsDialogs.mainWindow = mainWindow;
	}

	public static void showFatalExceptionDialog(String message) {
		JOptionPane.showMessageDialog(mainWindow, message,TITLE_TEXT, JOptionPane.ERROR_MESSAGE);
	}

	public static void showWarningExceptionDialog(String message) {
		JOptionPane.showMessageDialog(mainWindow, message, TITLE_TEXT, JOptionPane.WARNING_MESSAGE);
	}
}
