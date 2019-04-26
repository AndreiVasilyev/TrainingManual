package by.bobruisk.trainingmanual.model;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	private String questionText;
	private List<Answer> answers;
	private boolean isAnswered;

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return questionText;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Question question = (Question) obj;
		return (questionText == question.questionText
				|| (questionText != null && questionText.equals(question.getQuestionText())));

	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		return result;

	}

}
