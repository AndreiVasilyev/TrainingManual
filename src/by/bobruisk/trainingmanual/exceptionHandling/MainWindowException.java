package by.bobruisk.trainingmanual.exceptionHandling;

public class MainWindowException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MainWindowException() {
	}

	public MainWindowException(String message) {
	}

	public MainWindowException(Throwable cause) {
	}

	protected MainWindowException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
	}

	public MainWindowException(String message, Throwable currentException) {

		super(message);

	}
}
