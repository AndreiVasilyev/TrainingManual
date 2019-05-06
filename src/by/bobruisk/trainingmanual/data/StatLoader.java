package by.bobruisk.trainingmanual.data;

import java.util.List;

import by.bobruisk.trainingmanual.exceptionHandling.DataLoaderException;
import by.bobruisk.trainingmanual.model.Group;

public interface StatLoader {
	public List<Group> getData() throws DataLoaderException;

	public void saveData(List<Group> sections) throws DataLoaderException;
}
