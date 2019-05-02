package by.bobruisk.trainingmanual.exceptionHandling;

public class FileLoaderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileLoaderException() {
	}

	public FileLoaderException(String message) {
	}

	public FileLoaderException(Throwable cause) {
	}

	protected FileLoaderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
	}

	public FileLoaderException(String message, Throwable currentException) {

		super(message);

	}

}
