package by.bobruisk.trainingmanual.listener.inputpanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import by.bobruisk.trainingmanual.gui.InputNewQuestionPanel;

public class AnswerTextFieldListener implements KeyListener {
	InputNewQuestionPanel inputNewQuestionPanel;

	public AnswerTextFieldListener(InputNewQuestionPanel inputNewQuestionPanel) {
		this.inputNewQuestionPanel = inputNewQuestionPanel;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		inputNewQuestionPanel.repaintAnswerPanel();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
