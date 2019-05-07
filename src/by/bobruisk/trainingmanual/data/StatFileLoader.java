package by.bobruisk.trainingmanual.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.log4j.Logger;

import by.bobruisk.trainingmanual.exceptionHandling.DataLoaderException;
import by.bobruisk.trainingmanual.gui.ExceptionsDialogs;
import by.bobruisk.trainingmanual.model.Group;
import by.bobruisk.trainingmanual.run.Run;

public class StatFileLoader implements StatLoader {

	private final static Logger LOGGER = Logger.getLogger(Run.class);
	public static final String FILE_NAME = "res/stat.res";
	private File resourceFile;

	public StatFileLoader() throws DataLoaderException {
		LOGGER.info("run statFileLoader");
		resourceFile = new File(FILE_NAME);
		LOGGER.warn("check if file exist");
		if (!resourceFile.exists()) {
			LOGGER.warn("creation new default file");
			try {
				resourceFile.createNewFile();
				LOGGER.warn("creation OK");
			} catch (IOException currentException) {
				LOGGER.error("creation failed, IOException");
				throw new DataLoaderException("Сбой создания файла статистики", currentException);
			}

		}
	}

	public void saveData(List<Group> groups) throws DataLoaderException {

		LOGGER.info("save data method started");
		try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			LOGGER.warn("try writing data");
			objectOutputStream.writeObject(groups);
			LOGGER.warn("writing OK");
			objectOutputStream.flush();

		} catch (FileNotFoundException currentException) {

			LOGGER.error("writing failed, file not found");
			throw new DataLoaderException("Файл для записи не найден", currentException);

		} catch (IOException currentException) {

			LOGGER.error("writing failed, IOException");
			throw new DataLoaderException(ExceptionsDialogs.WRITE_ERROR + " в файл", currentException);

		}

	}

	@SuppressWarnings("unchecked")
	public List<Group> getData() throws DataLoaderException {
		LOGGER.info("get data method started");
		List<Group> result = null;
		if (resourceFile.length() != 0) {
			try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
				LOGGER.warn("try reading data");
				result = (List<Group>) objectInputStream.readObject();
				LOGGER.warn("reading OK");

			} catch (FileNotFoundException currentException) {
				LOGGER.error("reading failed, file not found");
				throw new DataLoaderException("Файл для чтения не найден", currentException);

			} catch (IOException currentException) {
				LOGGER.error("reading failed, IOException");
				throw new DataLoaderException(ExceptionsDialogs.READ_ERROR + " из файла", currentException);

			} catch (ClassNotFoundException currentException) {
				LOGGER.error("reading failed, class not found");
				throw new DataLoaderException(
						"Данные для чтения из файла повреждены или не соответствуют требуемому формату!",
						currentException);

			}
		}
		return result;
	}
}
