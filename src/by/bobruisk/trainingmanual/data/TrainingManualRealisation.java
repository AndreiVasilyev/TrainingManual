package by.bobruisk.trainingmanual.data;

import by.bobruisk.trainingmanual.exceptionHandling.FileLoaderException;
import by.bobruisk.trainingmanual.gui.MainWindow;

public class TrainingManualRealisation {
	private QuestionsDataBase questionsDataBase;
	private MainWindow mainWindow;

	public TrainingManualRealisation() {
		try {
			questionsDataBase = new QuestionsDataBase();
		} catch (FileLoaderException exception) {

			exception.getMessageDialog();

		}
		mainWindow = new MainWindow(questionsDataBase);
		mainWindow.setVisible(true);
	}

}
