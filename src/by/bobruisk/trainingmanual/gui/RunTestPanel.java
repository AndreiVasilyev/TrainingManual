package by.bobruisk.trainingmanual.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import by.bobruisk.trainingmanual.data.Test;
import by.bobruisk.trainingmanual.listener.runtestpanel.FinishTestButtonListener;
import by.bobruisk.trainingmanual.listener.runtestpanel.FixAnswerButtonListener;
import by.bobruisk.trainingmanual.listener.runtestpanel.NextQuestionButtonListener;
import by.bobruisk.trainingmanual.listener.runtestpanel.PreviousQuestionButtonListener;
import by.bobruisk.trainingmanual.listener.runtestpanel.ShowRightAnswerButtonListener;
import by.bobruisk.trainingmanual.model.Answer;

public class RunTestPanel extends JPanel {
	private MainWindow mainWindow;
	private static final long serialVersionUID = 1L;
	private Test test;
	private JPanel answerСhoicesPanel;
	private JPanel navigationPanel;
	public ButtonGroup answerButtonGroup;
	private JLabel questionTextLabel;
	public JButton fixAnswerButton;
	private JButton showRightAnswerButton;
	private JButton finishTestButton;
	public JLabel rightAnswerLabel;
	private JButton nextQuestionButton;
	private JButton previousQuestionButton;
	private JTextField currentQuestionIndexJTextField;
	private JSeparator separatorFirst;
	private JSeparator separatorSecond;
	private JRadioButton[] answerVariantRadioButton;

	public RunTestPanel(MainWindow mainWindow) {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Тест по выбранным темам"));
		this.mainWindow = mainWindow;
		test = mainWindow.questionsDataBase.test;
		createPanelElements();
		add(navigationPanel, new GridBagConstraints(0, 4, 3, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
		add(separatorFirst, new GridBagConstraints(0, 1, 3, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(separatorSecond, new GridBagConstraints(0, 5, 3, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(questionTextLabel, new GridBagConstraints(0, 0, 3, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 15, 5), 0, 0));
		add(answerСhoicesPanel, new GridBagConstraints(0, 2, 3, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 25, 5), 0, 0));
		add(fixAnswerButton, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		add(showRightAnswerButton, new GridBagConstraints(1, 6, 1, 1, 1, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(finishTestButton, new GridBagConstraints(2, 6, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		add(rightAnswerLabel, new GridBagConstraints(0, 3, 3, 1, 0, 0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 25, 5, 0), 0, 0));
		showCurrentAnswers();

	}

	private void createPanelElements() {
		questionTextLabel = new JLabel("");
		createNavigationPanel();
		rightAnswerLabel = new JLabel("");
		createaAnswerСhoicesRadioButtons();
		createButtons();
		separatorFirst = new JSeparator();
		separatorFirst.setForeground(Color.LIGHT_GRAY);
		separatorSecond = new JSeparator();
		separatorSecond.setForeground(Color.LIGHT_GRAY);
	}

	private void createNavigationPanel() {
		navigationPanel = new JPanel(new BorderLayout(2, 0));
		nextQuestionButton = new JButton(">>");
		previousQuestionButton = new JButton("<<");
		currentQuestionIndexJTextField = new JTextField("");
		nextQuestionButton.setPreferredSize(new Dimension(50, 20));
		previousQuestionButton.setPreferredSize(new Dimension(50, 20));
		nextQuestionButton.addActionListener(new NextQuestionButtonListener(this));
		previousQuestionButton.addActionListener(new PreviousQuestionButtonListener(this));
		currentQuestionIndexJTextField.setPreferredSize(new Dimension(40, 15));
		currentQuestionIndexJTextField.setEditable(false);
		currentQuestionIndexJTextField.setHorizontalAlignment(0);
		navigationPanel.add(previousQuestionButton, BorderLayout.WEST);
		navigationPanel.add(currentQuestionIndexJTextField, BorderLayout.CENTER);
		navigationPanel.add(nextQuestionButton, BorderLayout.EAST);

	}

	private void createButtons() {
		fixAnswerButton = new JButton("Ответить");
		fixAnswerButton.setPreferredSize(new Dimension(140, 30));
		fixAnswerButton.addActionListener(new FixAnswerButtonListener(this));
		showRightAnswerButton = new JButton("Показать ответ");
		showRightAnswerButton.setPreferredSize(new Dimension(140, 30));
		showRightAnswerButton.addActionListener(new ShowRightAnswerButtonListener(this));
		finishTestButton = new JButton("Завершить тест");
		finishTestButton.setPreferredSize(new Dimension(140, 30));
		finishTestButton.addActionListener(new FinishTestButtonListener(mainWindow));
	}

	private void createaAnswerСhoicesRadioButtons() {
		answerСhoicesPanel = new JPanel(new GridLayout(0, 1, 0, 1));
		answerButtonGroup = new ButtonGroup();

	}

	public void showCurrentAnswers() {
		answerButtonGroup = new ButtonGroup();
		boolean isAnswered = test.getQuestionsForTest().get(test.getIndexOfCurrentQuestion()).isAnswered();
		answerСhoicesPanel.removeAll();
		questionTextLabel.setText(test.getQuestionsForTest().get(test.getIndexOfCurrentQuestion()).getQuestionText());
		currentQuestionIndexJTextField
				.setText((test.getIndexOfCurrentQuestion() + 1) + "/" + test.getTestQuestionsCount());
		List<Answer> answers = test.getQuestionsForTest().get(test.getIndexOfCurrentQuestion()).getAnswers();
		answerVariantRadioButton = new JRadioButton[answers.size()];
		for (int i = 0; i < answers.size(); i++) {
			JRadioButton radioButton = new JRadioButton(answers.get(i).getAnswerText());
			answerVariantRadioButton[i] = radioButton;
			answerVariantRadioButton[i].setAlignmentX(Component.LEFT_ALIGNMENT);
			answerVariantRadioButton[i].setActionCommand(answers.get(i).getAnswerText());
			if (isAnswered) {

				if (answers.get(i).getIsSelected()) {

					answerVariantRadioButton[i].setSelected(true);
				}
				answerVariantRadioButton[i].setEnabled(false);

			}

			answerButtonGroup.add(answerVariantRadioButton[i]);
			answerСhoicesPanel.add(answerVariantRadioButton[i]);

		}
		if (isAnswered) {
			fixAnswerButton.setEnabled(false);
		} else
			fixAnswerButton.setEnabled(true);

		validate();
		repaint();
	}

	public Test getTest() {
		return test;
	}
}