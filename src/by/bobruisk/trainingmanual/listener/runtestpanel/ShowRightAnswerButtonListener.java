package by.bobruisk.trainingmanual.listener.runtestpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import by.bobruisk.trainingmanual.gui.RunTestPanel;
import by.bobruisk.trainingmanual.model.Answer;

public class ShowRightAnswerButtonListener implements ActionListener {
	private RunTestPanel runTestPanel;
	private int currentQuestionIndex;

	public ShowRightAnswerButtonListener(RunTestPanel runTestPanel) {
		this.runTestPanel = runTestPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		currentQuestionIndex = runTestPanel.getTest().getIndexOfCurrentQuestion();
		List<Answer> answers = runTestPanel.getTest().getQuestionsForTest().get(currentQuestionIndex).getAnswers();
		for (int i = 0; i < answers.size(); i++) {
			if (answers.get(i).getIsCorrect()) {
				runTestPanel.rightAnswerLabel.setText(answers.get(i).getAnswerText());
			}
		}

	}

}
