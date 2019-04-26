package by.bobruisk.trainingmanual.data;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

import by.bobruisk.trainingmanual.exceptionHandling.FileLoaderException;
import by.bobruisk.trainingmanual.gui.CheckBoxNode;
import by.bobruisk.trainingmanual.model.Question;
import by.bobruisk.trainingmanual.model.Section;

public class QuestionsDataBase {

	private List<Section> sections;
	private List<Question> selectedQuestionsForTest;
	private List<String> allSectionsName;
	public Test test;
	public FileLoader fileLoader;

	public QuestionsDataBase() throws FileLoaderException {

		sections = new ArrayList<Section>();
		allSectionsName = new ArrayList<String>();
		fileLoader = new FileLoader();
		sections = fileLoader.getData();
		selectedQuestionsForTest = new ArrayList<Question>();
		setDefaultQuestionsForTest(sections);

	}

	public List<Question> getQuestionsForTest() {
		return selectedQuestionsForTest;
	}

	public void setQuestionsForTest(List<Question> questionsForTest) {
		this.selectedQuestionsForTest = questionsForTest;
	}
	
	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	public void resetTest() {
		test = new Test(selectedQuestionsForTest);
	}

	private void setDefaultQuestionsForTest(List<Section> subsections) {

		for (int i = 0; i < subsections.size(); i++) {
			if (subsections.get(i).getTopics() != null) {
				for (int j = 0; j < subsections.get(i).getTopics().size(); j++) {
					selectedQuestionsForTest.addAll(subsections.get(i).getTopics().get(j).getQuestions());
				}
			}
			if (subsections.get(i).getSubSections() != null) {
				setDefaultQuestionsForTest(subsections.get(i).getSubSections());
			}

		}
	}

	
	public List<Question> createQuestionsForTest(DefaultMutableTreeNode node, Section section) {

		DefaultMutableTreeNode currentNode;
		Section currentSection;

		for (int i = 0; i < node.getChildCount(); i++) {
			currentNode = (DefaultMutableTreeNode) node.getChildAt(i);

			if (currentNode.getUserObject() instanceof CheckBoxNode) {
				CheckBoxNode currentCheckBoxNode = (CheckBoxNode) currentNode.getUserObject();

				if (currentCheckBoxNode.isSelected()) {
					getAllQuestionsFromTopic(section, currentCheckBoxNode.getText(), true);
				} else {

					getAllQuestionsFromTopic(section, currentCheckBoxNode.getText(), false);
				}

			} else {

				if (section != null) {
					currentSection = getCurrentSection(section.getSubSections(), currentNode.toString());
				} else {
					currentSection = getCurrentSection(sections, currentNode.toString());
				}
				createQuestionsForTest(currentNode, currentSection);
			}

		}

		return selectedQuestionsForTest;

	}

	private Section getCurrentSection(List<Section> sections, String sectionName) {
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getSectionName().equals(sectionName)) {
				return sections.get(i);
			}
		}

		return null;
	}

	private void getAllQuestionsFromTopic(Section section, String topicName, boolean isSelected) {

		for (int i = 0; i < section.getTopics().size(); i++) {
			if (section.getTopics().get(i).getTopicName().equals(topicName)) {

				if (isSelected) {
					section.getTopics().get(i).setSelectedInTree(true);
					selectedQuestionsForTest.addAll(section.getTopics().get(i).getQuestions());
				} else {
					section.getTopics().get(i).setSelectedInTree(false);
				}
			}

		}

	}

	public List<String> getAllSectionsName(List<Section> subsections) {

		for (int i = 0; i < subsections.size(); i++) {
			if (!allSectionsName.contains(subsections.get(i).getSectionName())) {
				allSectionsName.add(subsections.get(i).getSectionName());
			}
			if (subsections.get(i).getSubSections() != null) {
				getAllSectionsName(subsections.get(i).getSubSections());
			}
		}
		return allSectionsName;
	}

	public List<String> getTopicsName(List<Section> subsections, String sectionName) {

		List<String> topicsName = new ArrayList<String>();
		for (int i = 0; i < subsections.size(); i++) {
			if (subsections.get(i).getSectionName().equals(sectionName) && subsections.get(i).getTopics() != null) {
				for (int j = 0; j < subsections.get(i).getTopics().size(); j++) {
					topicsName.add(subsections.get(i).getTopics().get(j).getTopicName());
				}
				return topicsName;
			}
			if (subsections.get(i).getSubSections() != null) {
				topicsName = getTopicsName(subsections.get(i).getSubSections(), sectionName);
			}
		}

		return topicsName;
	}
}
