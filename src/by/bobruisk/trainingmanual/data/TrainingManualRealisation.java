package by.bobruisk.trainingmanual.data;

import by.bobruisk.trainingmanual.exceptionHandling.DataBaseException;
import by.bobruisk.trainingmanual.exceptionHandling.ExceptionHandler;
import by.bobruisk.trainingmanual.exceptionHandling.MainWindowException;
import by.bobruisk.trainingmanual.gui.MainWindow;

public class TrainingManualRealisation {
	private QuestionsDataBase questionsDataBase;
	private UsersDataBase usersDataBase;
	private MainWindow mainWindow;

	public TrainingManualRealisation() {

		try {

			questionsDataBase = new QuestionsDataBase();
			usersDataBase = new UsersDataBase();
			mainWindow = new MainWindow(questionsDataBase, usersDataBase);

		} catch (DataBaseException currentException) {

			new ExceptionHandler(currentException);

		} catch (MainWindowException currentException) {

			new ExceptionHandler(currentException);

		}

		mainWindow.setVisible(true);
	}

}
