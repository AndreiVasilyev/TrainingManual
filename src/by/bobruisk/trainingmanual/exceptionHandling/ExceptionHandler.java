package by.bobruisk.trainingmanual.exceptionHandling;

import by.bobruisk.trainingmanual.gui.ExceptionsDialods;

public class ExceptionHandler {

	public ExceptionHandler(Throwable currentException) {
		handleException(currentException);
	}

	private void handleException(Throwable currentException) {

		if (currentException.getMessage().contains("чтения")) {
			ExceptionsDialods.showFatalExceptionDialog(currentException.getMessage());
			System.exit(0);
		} else {
			ExceptionsDialods.showWarningExceptionDialog(currentException.getMessage());
		}

	}
}
