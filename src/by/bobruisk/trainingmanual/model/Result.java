package by.bobruisk.trainingmanual.model;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	private String date;
	private List<String> topics;
	private int persents;
	private String countAnswers;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public int getPersents() {
		return persents;
	}

	public String getCountAnswers() {
		return countAnswers;
	}

	public void setPersents(int persents) {
		this.persents = persents;
	}

	public void setCountAnswers(String countAnswers) {
		this.countAnswers = countAnswers;
	}
}
