package by.bobruisk.trainingmanual.exceptionHandling;

import by.bobruisk.trainingmanual.gui.ExceptionsDialogs;

public class ExceptionHandler {

	public ExceptionHandler(Throwable currentException) {
		handleException(currentException);
	}

	private void handleException(Throwable currentException) {

		if (currentException.getMessage().contains("чтения")) {
			ExceptionsDialogs.showFatalExceptionDialog(currentException.getMessage());
			System.exit(0);
		} else {
			ExceptionsDialogs.showWarningExceptionDialog(currentException.getMessage());
		}

	}
}
