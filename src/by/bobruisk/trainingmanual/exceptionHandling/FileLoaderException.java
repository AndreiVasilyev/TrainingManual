package by.bobruisk.trainingmanual.exceptionHandling;

import by.bobruisk.trainingmanual.gui.ExceptionsDialods;

public class FileLoaderException extends Exception {

	private static final long serialVersionUID = 1L;

	private Exception currentException;
	private String sourseException;
	private String message;

	public FileLoaderException(String sourseException, Exception currentException) {
		super(sourseException);
		this.currentException = currentException;
		this.sourseException = sourseException;
	}

	public void getMessageDialog() {

		if (sourseException.equals("Ошибка записи")) {
			if (currentException.getClass().getSimpleName().equals("FileNotFoundException")) {
				message = "Файл для записи данных не найден!";
				ExceptionsDialods.showWriteExceptionDialog(sourseException, message);

			} else {

				message = "Сбой записи данных!";
				ExceptionsDialods.showWriteExceptionDialog(sourseException, message);

			}

		} else if (sourseException.equals("Ошибка чтения")) {
			if (currentException.getClass().getSimpleName().equals("FileNotFoundException")) {
				message = "Файл для чтения данных не найден!";
				ExceptionsDialods.showReadExceptionDialog(sourseException, message);

			} else if (currentException.getClass().getSimpleName().equals("ClassNotFoundException")) {

				message = "Данные из файла повреждены или не соответствуют требуемому формату!";
				ExceptionsDialods.showReadExceptionDialog(sourseException, message);

			} else {

				message = "Сбой чтения данных!";
				ExceptionsDialods.showReadExceptionDialog(sourseException, message);

			}

			System.exit(0);
		}

	}

}
