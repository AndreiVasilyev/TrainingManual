package by.bobruisk.trainingmanual.listener.inputpanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class TopicNameTextFieldListener implements KeyListener {

	private MainWindow mainWindow;

	public TopicNameTextFieldListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		if (!mainWindow.inputNewQuestionPanel.topicNameTextField.getText().isEmpty()) {
			mainWindow.inputNewQuestionPanel.questionTextTextField.setEnabled(true);
			mainWindow.inputNewQuestionPanel.topicComboBox.setEnabled(false);

		} else {

			mainWindow.inputNewQuestionPanel.questionTextTextField.setText("");
			mainWindow.inputNewQuestionPanel.questionTextTextField.setEnabled(false);
			if (mainWindow.inputNewQuestionPanel.sectionNameTextField.getText().equals("")) {
				mainWindow.inputNewQuestionPanel.topicComboBox.setEnabled(true);
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
