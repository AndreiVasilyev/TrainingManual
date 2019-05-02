package by.bobruisk.trainingmanual.data;

import java.util.List;

import by.bobruisk.trainingmanual.exceptionHandling.FileLoaderException;
import by.bobruisk.trainingmanual.model.Section;

public interface DataLoader {
	
	public List<Section> getData() throws FileLoaderException;

	public void saveData(List<Section> sections) throws FileLoaderException;
}
