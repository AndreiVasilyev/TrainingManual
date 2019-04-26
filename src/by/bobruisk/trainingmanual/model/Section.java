package by.bobruisk.trainingmanual.model;

import java.io.Serializable;
import java.util.List;

public class Section implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sectionName;
	private List<Topic> topics;
	private List<Section> subSections;

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public List<Section> getSubSections() {
		return subSections;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public void setSubSections(List<Section> subSections) {
		this.subSections = subSections;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sectionName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Section section = (Section) obj;
		return (sectionName == section.sectionName
				|| (sectionName != null && sectionName.equals(section.getSectionName())));

	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionName == null) ? 0 : sectionName.hashCode());
		return result;

	}
}
