package by.bobruisk.trainingmanual.exceptionHandling;

public class DataBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataBaseException() {
	}

	public DataBaseException(String message) {
	}

	public DataBaseException(Throwable cause) {
	}

	protected DataBaseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
	}

	public DataBaseException(String message, Throwable currentException) {

		super(message);

	}

}
