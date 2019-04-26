package by.bobruisk.trainingmanual.listener.inputpanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class TopicComboBoxItemListener implements ItemListener {

	private MainWindow mainWindow;

	public TopicComboBoxItemListener(MainWindow mainWindow) {

		this.mainWindow = mainWindow;

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (mainWindow.inputNewQuestionPanel.topicComboBox.getSelectedItem() != null
				&& !mainWindow.inputNewQuestionPanel.topicComboBox.getSelectedItem().equals("")) {
			mainWindow.inputNewQuestionPanel.sectionNameTextField.setText("");
			mainWindow.inputNewQuestionPanel.sectionNameTextField.setEnabled(false);
			mainWindow.inputNewQuestionPanel.topicNameTextField.setText("");
			mainWindow.inputNewQuestionPanel.topicNameTextField.setEnabled(false);
			mainWindow.inputNewQuestionPanel.questionTextTextField.setEnabled(true);
		} else {
			mainWindow.inputNewQuestionPanel.questionTextTextField.setText("");
			mainWindow.inputNewQuestionPanel.questionTextTextField.setEnabled(false);
			mainWindow.inputNewQuestionPanel.topicNameTextField.setEnabled(true);
			mainWindow.inputNewQuestionPanel.sectionNameTextField.setEnabled(true);
		}

	}

}
