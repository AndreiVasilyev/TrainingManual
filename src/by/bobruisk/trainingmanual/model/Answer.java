package by.bobruisk.trainingmanual.model;

import java.io.Serializable;

public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;
	private String answerText;
	private Boolean isCorrect;
	private Boolean isSelected;

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	@Override
	public String toString() {

		return answerText;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Answer answer = (Answer) obj;
		return (answerText == answer.answerText || (answerText != null && answerText.equals(answer.getAnswerText())));

	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerText == null) ? 0 : answerText.hashCode());
		return result;

	}
}
