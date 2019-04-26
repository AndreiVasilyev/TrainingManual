package by.bobruisk.trainingmanual.listener.runtestpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.RunTestPanel;

public class NextQuestionButtonListener implements ActionListener {
	private RunTestPanel runTestPanel;
	private int currentQuestionIndex;
	private int testQuestionsCount;

	public NextQuestionButtonListener(RunTestPanel runTestPanel) {
		this.runTestPanel = runTestPanel;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		currentQuestionIndex = runTestPanel.getTest().getIndexOfCurrentQuestion();
		testQuestionsCount = runTestPanel.getTest().getTestQuestionsCount();
		if (currentQuestionIndex != testQuestionsCount - 1) {
			runTestPanel.getTest().setIndexOfCurrentQuestion(++currentQuestionIndex);
			runTestPanel.showCurrentAnswers();
			runTestPanel.rightAnswerLabel.setText("");
		}
	}

}
