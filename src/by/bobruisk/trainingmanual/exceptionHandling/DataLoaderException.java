package by.bobruisk.trainingmanual.exceptionHandling;

public class DataLoaderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataLoaderException() {
	}

	public DataLoaderException(String message) {
	}

	public DataLoaderException(Throwable cause) {
	}

	protected DataLoaderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
	}

	public DataLoaderException(String message, Throwable currentException) {

		super(message);

	}

}
