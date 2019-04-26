package by.bobruisk.trainingmanual.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import by.bobruisk.trainingmanual.model.Question;

public class Test {
	private final int TEST_PASSING_LEVEL_PERSENT = 80;
	private final int DEFAULT_TEST_QUESTIONS_COUNT = 10;
	private List<Question> selectedQuestionsForTest;
	private List<Question> questionsForTest;
	private int testQuestionsCount;
	private int rightAnswersCount;
	private int indexOfCurrentQuestion;

	public Test(List<Question> selectedQuestionsForTest) {

		this.selectedQuestionsForTest = selectedQuestionsForTest;
		testQuestionsCount = DEFAULT_TEST_QUESTIONS_COUNT;
		rightAnswersCount = 0;
		indexOfCurrentQuestion = 0;
		resetFlags();
		createQuestionsForTest();

	}

	public List<Question> getSelectedQuestionsForTest() {
		return selectedQuestionsForTest;
	}

	public void setSelectedQuestionsForTest(Question[] selectedQuestionsForTest) {
		this.selectedQuestionsForTest = new ArrayList<Question>(Arrays.asList(selectedQuestionsForTest));
	}

	public List<Question> getQuestionsForTest() {
		return questionsForTest;
	}

	public int getRightAnswersCount() {
		return rightAnswersCount;
	}

	public void setRightAnswersCount(int rightAnswersCount) {
		this.rightAnswersCount = rightAnswersCount;
	}

	public int getIndexOfCurrentQuestion() {
		return indexOfCurrentQuestion;
	}

	public void setIndexOfCurrentQuestion(int indexOfCurrentQuestion) {
		this.indexOfCurrentQuestion = indexOfCurrentQuestion;
	}

	public int getTestQuestionsCount() {
		return testQuestionsCount;
	}

	public void setTestQuestionsCount(int testQuestionsCount) {
		this.testQuestionsCount = testQuestionsCount;
	}

	public int getTEST_PASSING_LEVEL_PERSENT() {
		return TEST_PASSING_LEVEL_PERSENT;

	}

	public void createQuestionsForTest() {

		Random random = new Random();
		if (testQuestionsCount > selectedQuestionsForTest.size()) {
			testQuestionsCount = selectedQuestionsForTest.size();
		}
		questionsForTest = new ArrayList<Question>();
		for (int i = 0; i < testQuestionsCount; i++) {
			Question randomElement = selectedQuestionsForTest.get(random.nextInt(selectedQuestionsForTest.size()));
			if (i > 0 && questionsForTest.contains(randomElement)) {
				i--;
				continue;
			}
			questionsForTest.add(randomElement);

		}

	}

	public void resetFlags() {
		for (int i = 0; i < selectedQuestionsForTest.size(); i++) {
			selectedQuestionsForTest.get(i).setAnswered(false);
			for (int j = 0; j < selectedQuestionsForTest.get(i).getAnswers().size(); j++) {
				selectedQuestionsForTest.get(i).getAnswers().get(j).setIsSelected(false);
			}
		}

	}

}
