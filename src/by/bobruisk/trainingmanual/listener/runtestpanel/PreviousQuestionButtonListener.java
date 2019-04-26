package by.bobruisk.trainingmanual.listener.runtestpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.RunTestPanel;

public class PreviousQuestionButtonListener implements ActionListener {
	private RunTestPanel runTestPanel;
	private int currentQuestionIndex;

	public PreviousQuestionButtonListener(RunTestPanel runTestPanel) {
		this.runTestPanel = runTestPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		currentQuestionIndex = runTestPanel.getTest().getIndexOfCurrentQuestion();
		if (currentQuestionIndex != 0) {
			runTestPanel.getTest().setIndexOfCurrentQuestion(--currentQuestionIndex);
			runTestPanel.showCurrentAnswers();
			runTestPanel.rightAnswerLabel.setText("");
		}

	}
}
