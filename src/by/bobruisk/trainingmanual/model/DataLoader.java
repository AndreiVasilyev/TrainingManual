package by.bobruisk.trainingmanual.model;

import java.util.List;

import by.bobruisk.trainingmanual.exceptionHandling.FileLoaderException;

public interface DataLoader {
	
	public List<Section> getData() throws FileLoaderException;

	public void saveData(List<Section> sections) throws FileLoaderException;
}
