package by.bobruisk.trainingmanual.listener.runtestpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import by.bobruisk.trainingmanual.gui.RunTestPanel;
import by.bobruisk.trainingmanual.model.Answer;
import by.bobruisk.trainingmanual.model.Question;

public class FixAnswerButtonListener implements ActionListener {
	private RunTestPanel runTestPanel;
	private int currentQuestionIndex;
	private Question currentQuestion;
	private String selectedAnswerText;
	private Answer selectedAnswer;

	public FixAnswerButtonListener(RunTestPanel runTestPanel) {
		this.runTestPanel = runTestPanel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		currentQuestionIndex = runTestPanel.getTest().getIndexOfCurrentQuestion();
		currentQuestion = runTestPanel.getTest().getQuestionsForTest().get(currentQuestionIndex);

		if (runTestPanel.answerButtonGroup.getSelection() == null) {
			JOptionPane.showMessageDialog(runTestPanel, "Сначала нужно выбрать вариант ответа!", "Ошибка",
					JOptionPane.ERROR_MESSAGE);
		} else {
			selectedAnswerText = runTestPanel.answerButtonGroup.getSelection().getActionCommand();
			selectedAnswer = getSelectedAnswer();
			int currentRightAnswerCount = runTestPanel.getTest().getRightAnswersCount();
			currentQuestion.setAnswered(true);
			selectedAnswer.setIsSelected(true);
			if (selectedAnswer.getIsCorrect()) {
				runTestPanel.getTest().setRightAnswersCount(++currentRightAnswerCount);
			}
			runTestPanel.showCurrentAnswers();
		}

	}

	private Answer getSelectedAnswer() {
		for (int i = 0; i < currentQuestion.getAnswers().size(); i++) {
			if (currentQuestion.getAnswers().get(i).getAnswerText().equals(selectedAnswerText)) {
				return currentQuestion.getAnswers().get(i);
			}
		}
		return null;
	}

}
