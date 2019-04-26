package by.bobruisk.trainingmanual.model;

import java.io.Serializable;
import java.util.List;

public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;
	private String topicName;
	private List<Question> questions;
	private boolean isSelectedInTree;

	public boolean isSelectedInTree() {
		return isSelectedInTree;
	}

	public void setSelectedInTree(boolean isSelectedInTree) {
		this.isSelectedInTree = isSelectedInTree;
	}

	public String getTopicName() {
		return topicName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {

		return topicName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Topic topic = (Topic) obj;
		return (topicName == topic.topicName || (topicName != null && topicName.equals(topic.getTopicName())));

	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((topicName == null) ? 0 : topicName.hashCode());
		return result;

	}

}
