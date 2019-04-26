package by.bobruisk.trainingmanual.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import by.bobruisk.trainingmanual.listener.inputpanel.AnswerTextFieldListener;
import by.bobruisk.trainingmanual.listener.inputpanel.CloseInputNewQuestionPanelButton;
import by.bobruisk.trainingmanual.listener.inputpanel.SaveQuestionButtonListener;
import by.bobruisk.trainingmanual.listener.inputpanel.SectionComboBoxItemListener;
import by.bobruisk.trainingmanual.listener.inputpanel.SectionNameTextFieldListener;
import by.bobruisk.trainingmanual.listener.inputpanel.TopicComboBoxItemListener;
import by.bobruisk.trainingmanual.listener.inputpanel.TopicNameTextFieldListener;
import by.bobruisk.trainingmanual.model.Section;

public class InputNewQuestionPanel extends JPanel {

	public final int DEFAULT_COUNT_ANSWERS = 4;
	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	private List<Section> sections;
	private JPanel answerPanel;
	private JLabel sectionNameLabel;
	private JLabel sectionNewNameLabel;
	private JLabel topicNameLabel;
	private JLabel topicNewNameLabel;
	private JLabel questionTextLabel;
	private JLabel answersLabel;
	private JLabel correctBoxLabel;
	private JLabel answersTextLabel;
	public JTextField sectionNameTextField;
	public JTextField topicNameTextField;
	public JTextField questionTextTextField;
	public JTextField answerTextTextField;
	public JComboBox<String> sectionComboBox;
	public JComboBox<String> topicComboBox;
	public List<JCheckBox> answersCheckBox;
	public List<JTextField> answersTextField;
	private JCheckBox answerTextCheckBox;
	private JButton saveQuestionButton;
	private JButton closeInputNewQuestionPanelButton;
	public JScrollPane scrollPane;
	public int currentActiveAnswerIndex;
	private AnswerTextFieldListener answerTextFieldListener;

	public InputNewQuestionPanel(MainWindow mainWindow) {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Добавление новых вопросов"));
		this.mainWindow = mainWindow;
		sections = mainWindow.questionsDataBase.getSections();
		createPanelElements();

		add(sectionNameLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		add(sectionComboBox, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(sectionNewNameLabel, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(sectionNameTextField, new GridBagConstraints(3, 0, 2, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
		add(topicNameLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		add(topicComboBox, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(topicNewNameLabel, new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(topicNameTextField, new GridBagConstraints(3, 1, 2, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
		add(questionTextLabel, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(questionTextTextField, new GridBagConstraints(1, 2, 4, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
		add(answersLabel, new GridBagConstraints(0, 3, 5, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(25, 5, 5, 5), 0, 0));
		add(scrollPane, new GridBagConstraints(0, 5, 5, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		add(saveQuestionButton, new GridBagConstraints(3, 7, 1, 1, 1, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(closeInputNewQuestionPanelButton, new GridBagConstraints(4, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

	}

	private void createPanelElements() {

		sectionNameLabel = new JLabel("Выбор раздела:");
		sectionNewNameLabel = new JLabel("Создать новый:");
		topicNameLabel = new JLabel("Выбор темы:");
		topicNewNameLabel = new JLabel("Создать новую:");
		questionTextLabel = new JLabel("Текст вопроса:");
		answersLabel = new JLabel("Варианты ответов");
		createAnswersPanel();
		sectionNameTextField = new JTextField("", 20);
		sectionNameTextField.addKeyListener(new SectionNameTextFieldListener(mainWindow));
		topicNameTextField = new JTextField("", 20);
		topicNameTextField.setEnabled(false);
		topicNameTextField.addKeyListener(new TopicNameTextFieldListener(mainWindow));
		questionTextTextField = new JTextField("", 30);
		questionTextTextField.setEnabled(false);
		createSectionComboBox();
		createTopicComboBox();
		saveQuestionButton = new JButton("Сохранить");
		saveQuestionButton.addActionListener(new SaveQuestionButtonListener(mainWindow));
		closeInputNewQuestionPanelButton = new JButton("Закрыть");
		closeInputNewQuestionPanelButton.addActionListener(new CloseInputNewQuestionPanelButton(mainWindow));

	}

	private void createTopicComboBox() {
		topicComboBox = new JComboBox<String>();
		topicComboBox.addItemListener(new TopicComboBoxItemListener(mainWindow));
		topicComboBox.setEnabled(false);
	}

	private void createSectionComboBox() {

		sectionComboBox = new JComboBox<String>();
		paintSectionComboBox();
		sectionComboBox.addItemListener(new SectionComboBoxItemListener(mainWindow));

	}

	private void createAnswersPanel() {
		currentActiveAnswerIndex = 0;
		answerPanel = new JPanel();
		answerPanel.setLayout(new GridBagLayout());
		correctBoxLabel = new JLabel("Правильный ответ");
		answersTextLabel = new JLabel("Тексты ответов");
		answersCheckBox = new ArrayList<JCheckBox>();
		answersTextField = new ArrayList<JTextField>();
		paintAnswersPanel();
		scrollPane = new JScrollPane(answerPanel);
	}

	public void repaintAnswerPanel() {

		if (!answersTextField.get(currentActiveAnswerIndex).getText().isEmpty()) {
			currentActiveAnswerIndex++;
			if (currentActiveAnswerIndex < DEFAULT_COUNT_ANSWERS) {
				answersTextField.get(currentActiveAnswerIndex).setEnabled(true);
				answersCheckBox.get(currentActiveAnswerIndex).setEnabled(true);

			} else {
				answerTextCheckBox = new JCheckBox("", false);
				answerTextTextField = new JTextField(48);
				answersCheckBox.add(answerTextCheckBox);
				answersTextField.add(answerTextTextField);
				answerPanel.add(answerTextCheckBox, new GridBagConstraints(1, currentActiveAnswerIndex + 1, 1, 1, 0, 0,
						GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2, 5, 2, 0), 0, 0));
				answerPanel.add(answerTextTextField, new GridBagConstraints(0, currentActiveAnswerIndex + 1, 1, 1, 0, 0,
						GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 2, 0), 0, 0));
			}
			answersTextField.get(currentActiveAnswerIndex).addKeyListener(answerTextFieldListener);
			answersTextField.get(currentActiveAnswerIndex - 1).removeKeyListener(answerTextFieldListener);
			answerPanel.validate();
			scrollPane.validate();

		}

	}

	public void paintAnswersPanel() {
		answerTextFieldListener = new AnswerTextFieldListener(this);
		answerPanel.add(correctBoxLabel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		answerPanel.add(answersTextLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		for (int i = 0; i < DEFAULT_COUNT_ANSWERS; i++) {
			answerTextCheckBox = new JCheckBox("", false);
			answerTextTextField = new JTextField(48);
			answersCheckBox.add(answerTextCheckBox);
			answersTextField.add(answerTextTextField);
			answerPanel.add(answerTextCheckBox, new GridBagConstraints(1, i + 1, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(2, 5, 2, 0), 0, 0));
			answerPanel.add(answerTextTextField, new GridBagConstraints(0, i + 1, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, new Insets(2, 5, 2, 0), 0, 0));

			if (i == 0) {
				answerTextTextField.addKeyListener(answerTextFieldListener);

			} else {
				answerTextTextField.setEnabled(false);
				answerTextCheckBox.setEnabled(false);
			}

		}
		answerPanel.validate();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void paintSectionComboBox() {
		sectionComboBox.setModel(
				new DefaultComboBoxModel(mainWindow.questionsDataBase.getAllSectionsName(sections).toArray()));
		sectionComboBox.addItem("");
		sectionComboBox.setSelectedItem("");
	}
}
