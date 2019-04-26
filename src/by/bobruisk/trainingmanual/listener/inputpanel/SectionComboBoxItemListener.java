package by.bobruisk.trainingmanual.listener.inputpanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import by.bobruisk.trainingmanual.gui.MainWindow;

public class SectionComboBoxItemListener implements ItemListener {

	private MainWindow mainWindow;
	private JComboBox<String> topicComboBox;

	public SectionComboBoxItemListener(MainWindow mainWindow) {

		this.mainWindow = mainWindow;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void itemStateChanged(ItemEvent arg0) {

		if (!mainWindow.inputNewQuestionPanel.sectionComboBox.getSelectedItem().equals("")) {
			topicComboBox = mainWindow.inputNewQuestionPanel.topicComboBox;
			topicComboBox.removeAllItems();
			String sectionName = mainWindow.inputNewQuestionPanel.sectionComboBox.getSelectedItem().toString();
			topicComboBox.setModel(new DefaultComboBoxModel(mainWindow.questionsDataBase
					.getTopicsName(mainWindow.questionsDataBase.getSections(), sectionName).toArray()));
			topicComboBox.addItem("");
			topicComboBox.setSelectedItem("");
			mainWindow.inputNewQuestionPanel.topicNameTextField.setEnabled(true);
			if (mainWindow.inputNewQuestionPanel.sectionNameTextField.getText().isEmpty()) {
				topicComboBox.setEnabled(true);
				mainWindow.inputNewQuestionPanel.questionTextTextField.setText("");
			}
		} else {
			if (mainWindow.inputNewQuestionPanel.sectionNameTextField.getText().isEmpty()) {
				mainWindow.inputNewQuestionPanel.topicNameTextField.setText("");
				mainWindow.inputNewQuestionPanel.topicNameTextField.setEnabled(false);
				mainWindow.inputNewQuestionPanel.questionTextTextField.setText("");
				mainWindow.inputNewQuestionPanel.questionTextTextField.setEnabled(false);
			}
			if (topicComboBox != null) {
				topicComboBox.setSelectedItem("");
				topicComboBox.setEnabled(false);
			}
		}
	}

}
