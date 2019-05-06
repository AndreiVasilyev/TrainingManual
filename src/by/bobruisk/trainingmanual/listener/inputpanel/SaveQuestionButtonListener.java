package by.bobruisk.trainingmanual.listener.inputpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import by.bobruisk.trainingmanual.exceptionHandling.DataLoaderException;
import by.bobruisk.trainingmanual.exceptionHandling.ExceptionHandler;
import by.bobruisk.trainingmanual.gui.ExceptionsDialogs;
import by.bobruisk.trainingmanual.gui.MainWindow;
import by.bobruisk.trainingmanual.model.Answer;
import by.bobruisk.trainingmanual.model.Question;
import by.bobruisk.trainingmanual.model.Section;
import by.bobruisk.trainingmanual.model.Topic;

public class SaveQuestionButtonListener implements ActionListener {

	private List<Section> sections;
	private MainWindow mainWindow;
	private JComboBox<String> sectionComboBox;
	private JComboBox<String> topicComboBox;
	private JTextField sectionNameTextField;
	private JTextField topicNameTextField;
	private JTextField questionTextTextField;
	private List<JCheckBox> answersCheckBox;
	private List<JTextField> answersTextField;
	private Section section;
	private Section subSection;
	private Topic topic;
	private Question question;
	private List<Answer> answers;
	private int selectedanswersCount;

	public SaveQuestionButtonListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		sections = mainWindow.questionsDataBase.getSections();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sectionComboBox = mainWindow.inputNewQuestionPanel.sectionComboBox;
		topicComboBox = mainWindow.inputNewQuestionPanel.topicComboBox;
		sectionNameTextField = mainWindow.inputNewQuestionPanel.sectionNameTextField;
		topicNameTextField = mainWindow.inputNewQuestionPanel.topicNameTextField;
		questionTextTextField = mainWindow.inputNewQuestionPanel.questionTextTextField;
		answersCheckBox = mainWindow.inputNewQuestionPanel.answersCheckBox;
		answersTextField = mainWindow.inputNewQuestionPanel.answersTextField;

		if (!sectionComboBox.getSelectedItem().equals("")) {
			section = searchSection(sections, sectionComboBox.getSelectedItem().toString());
			if (section.getSubSections() == null) {
				section.setSubSections(new ArrayList<Section>());
			}
		}

		if (!sectionNameTextField.getText().isEmpty()) {
			subSection = new Section();
			subSection.setSectionName(sectionNameTextField.getText());
			subSection.setTopics(new ArrayList<Topic>());
			if (section != null) {
				section.getSubSections().add(subSection);
			} else {
				section = subSection;
				sections.add(section);
			}
		} else if (sectionComboBox.getSelectedItem().equals("")) {

			ExceptionsDialogs.showWarningExceptionDialog("Необходимо выбрать раздел или задать новый");
			return;

		} else {
			subSection = section;
		}

		if (!topicNameTextField.getText().isEmpty()) {
			topic = new Topic();
			topic.setTopicName(topicNameTextField.getText());
			topic.setQuestions(new ArrayList<Question>());
			topic.setSelectedInTree(true);
			if (subSection.getTopics() == null) {
				subSection.setTopics(new ArrayList<Topic>());
			}
			subSection.getTopics().add(topic);

		} else if (!topicComboBox.getSelectedItem().equals("")) {
			topic = searchTopic(subSection, topicComboBox.getSelectedItem().toString());
		} else {

			ExceptionsDialogs.showWarningExceptionDialog("Необходимо выбрать тему или задать новую");

			return;
		}

		if (!questionTextTextField.getText().isEmpty()) {
			question = new Question();
			question.setQuestionText(questionTextTextField.getText());
			question.setAnswered(false);
			topic.getQuestions().add(question);
		} else {

			ExceptionsDialogs.showWarningExceptionDialog("Необходимо ввести текст вопроса");

			return;
		}

		selectedanswersCount = 0;
		answers = new ArrayList<Answer>();
		for (int i = 0; i < answersTextField.size(); i++) {
			if (answersTextField.get(i) != null && !answersTextField.get(i).getText().isEmpty()) {
				Answer answer = new Answer();
				answer.setAnswerText(answersTextField.get(i).getText());
				answer.setIsSelected(false);
				if (answersCheckBox.get(i).isSelected()) {
					answer.setIsCorrect(true);
					selectedanswersCount++;
				} else {
					answer.setIsCorrect(false);
				}
				answers.add(answer);
			}

		}
		if (answers != null && answers.size() > 1 && selectedanswersCount == 1) {
			question.setAnswers(answers);
		} else {

			ExceptionsDialogs.showWarningExceptionDialog(
					"Необходимо ввести минимум два варианта ответа и отметить только один правильный");

			return;
		}

		try {
			mainWindow.questionsDataBase.fileLoader.saveData(sections);
		} catch (DataLoaderException currentException) {

			new ExceptionHandler(currentException);

		}
		resetValuesAndFields();

	}

	private void resetValuesAndFields() {
		section = null;
		subSection = null;
		topic = null;
		question = null;
		answers = null;
		selectedanswersCount = 0;
		mainWindow.inputNewQuestionPanel.paintSectionComboBox();
		sectionNameTextField.setText("");
		topicNameTextField.setText("");
		questionTextTextField.setText("");
		for (int i = 0; i < answersCheckBox.size(); i++) {
			answersCheckBox.get(i).setSelected(false);
			answersTextField.get(i).setText("");
		}

	}

	private Section searchSection(List<Section> sections, String sectionName) {
		Section result = null;
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getSectionName().equals(sectionName)) {
				return sections.get(i);
			}
			if (sections.get(i).getSubSections() != null) {
				result = searchSection(sections.get(i).getSubSections(), sectionName);
			}

		}
		return result;
	}

	private Topic searchTopic(Section section, String topicName) {
		Topic result = null;
		for (int i = 0; i < section.getTopics().size(); i++) {
			if (section.getTopics().get(i).getTopicName().equals(topicName)) {
				result = section.getTopics().get(i);
				return result;
			}
		}
		return result;
	}

}
