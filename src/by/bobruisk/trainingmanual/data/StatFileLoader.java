package by.bobruisk.trainingmanual.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import by.bobruisk.trainingmanual.exceptionHandling.FileLoaderException;
import by.bobruisk.trainingmanual.model.Group;

public class StatFileLoader implements StatLoader {
	public static final String FILE_NAME = "res/stat.res";
	private File resourceFile;

	public StatFileLoader() throws FileLoaderException {
		resourceFile = new File(FILE_NAME);
		if (!resourceFile.exists()) {

			try {
				resourceFile.createNewFile();
			} catch (IOException currentException) {

				throw new FileLoaderException("Сбой создания файла статистики", currentException);
			}

		}
	}

	public void saveData(List<Group> groups) throws FileLoaderException {

		try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(groups);
			objectOutputStream.flush();

		} catch (FileNotFoundException currentException) {

			throw new FileLoaderException("Файл для записи не найден", currentException);

		} catch (IOException currentException) {

			throw new FileLoaderException("Ошибка записи в файл", currentException);

		}

	}

	@SuppressWarnings("unchecked")
	public List<Group> getData() throws FileLoaderException {

		List<Group> result = null;
		if (resourceFile.length() != 0) {
			try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

				result = (List<Group>) objectInputStream.readObject();

			} catch (FileNotFoundException currentException) {

				throw new FileLoaderException("Файл для чтения не найден", currentException);

			} catch (IOException currentException) {

				throw new FileLoaderException("Ошибка чтения из файла", currentException);

			} catch (ClassNotFoundException currentException) {

				throw new FileLoaderException(
						"Данные для чтения из файла повреждены или не соответствуют требуемому формату!",
						currentException);

			}
		}
		return result;
	}
}
