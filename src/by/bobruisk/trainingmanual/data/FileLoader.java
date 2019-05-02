package by.bobruisk.trainingmanual.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import by.bobruisk.trainingmanual.exceptionHandling.DataBaseException;
import by.bobruisk.trainingmanual.exceptionHandling.FileLoaderException;
import by.bobruisk.trainingmanual.model.Section;

public class FileLoader implements DataLoader {

	public static final String FILE_NAME = "res/data.res";
	private File resourceFile;

	public FileLoader() throws DataBaseException {
		resourceFile = new File(FILE_NAME);
		if (!resourceFile.exists()) {

			DefaultQuestionsDataBaseLoader defaultQuestionsDataBaseLoader = new DefaultQuestionsDataBaseLoader(this);
			defaultQuestionsDataBaseLoader.loadDefaultDataToFile();

		}
	}

	public void saveData(List<Section> sections) throws FileLoaderException {

		try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

			objectOutputStream.writeObject(sections);
			objectOutputStream.flush();

		} catch (FileNotFoundException currentException) {

			throw new FileLoaderException("Файл для записи не найден", currentException);

		} catch (IOException currentException) {

			throw new FileLoaderException("Ошибка записи в файл", currentException);

		}

	}

	@SuppressWarnings("unchecked")
	public List<Section> getData() throws FileLoaderException {

		List<Section> result = null;
		try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			result = (List<Section>) objectInputStream.readObject();

		} catch (FileNotFoundException currentException) {

			throw new FileLoaderException("Файл для чтения не найден", currentException);

		} catch (IOException currentException) {

			throw new FileLoaderException("Ошибка чтения из файла", currentException);

		} catch (ClassNotFoundException currentException) {

			throw new FileLoaderException(
					"Данные для чтения из файла повреждены или не соответствуют требуемому формату!", currentException);

		}
		return result;
	}
}
