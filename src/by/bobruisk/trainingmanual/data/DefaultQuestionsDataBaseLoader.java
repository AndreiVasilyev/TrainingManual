package by.bobruisk.trainingmanual.data;

import java.util.ArrayList;
import java.util.List;
import by.bobruisk.trainingmanual.exceptionHandling.FileLoaderException;
import by.bobruisk.trainingmanual.model.Answer;
import by.bobruisk.trainingmanual.model.Question;
import by.bobruisk.trainingmanual.model.Section;
import by.bobruisk.trainingmanual.model.Topic;

public class DefaultQuestionsDataBaseLoader {

	private FileLoader fileLoader;
	private List<Section> sections;
	private List<Topic> topics;
	private List<Question> questions;
	private List<Answer> answers;

	public DefaultQuestionsDataBaseLoader(FileLoader fileLoader) {
		this.fileLoader = fileLoader;
	}

	public void loadDefaultDataToFile() throws FileLoaderException {

		sections = new ArrayList<Section>();
		topics = new ArrayList<Topic>();
		questions = new ArrayList<Question>();
		answers = new ArrayList<Answer>();

		newAnswers(3, "процедура взаимодействия между объектами", "отношение между методами",
				"механизм, которые объединяет данные и методы",
				"отношение между классами, при котором класс преобретает структуру и поведение другого класса");
		newQuestion("Что такое наследование?", (ArrayList<Answer>) answers);

		newAnswers(0, "для получения ссылки на объект текущего метода", "для получения ссылки на объект суперкласса",
				"для указания на текущий метод", "для указания на текущее поле");
		newQuestion("Для чего используется ключевое слово this?", (ArrayList<Answer>) answers);

		newAnswers(2, "для получения ссылки на объект текущего метода", "для получения ссылки на любой объект",
				"для получения ссылки на поля и методы суперкласса", "для получения ссылки на класс Object");
		newQuestion("Для чего используется ключевое слово super?", (ArrayList<Answer>) answers);

		newAnswers(0, "преобразование от суперкласса к подклассу", "преобразование от подкласса к суперклассу",
				"изменение типа текущего объекта");
		newQuestion("Что такое понижающее преобразование", (ArrayList<Answer>) answers);

		newTopic("Наследование", questions);

		newAnswers(1, "изменение содержания объекта",
				"способность объектов одного типа вести себя подобно объектам другого типа",
				"способность объектов работать с разными типами данных");
		newQuestion("Что такое полиморфизм?", (ArrayList<Answer>) answers);

		newAnswers(3, "это класс с полями private", "это класс, экземпляр которого можно создать один раз",
				"это класс без методов", "это класс, экземпляр которого невозможно создать");
		newQuestion("Что такое абстрактный класс?", (ArrayList<Answer>) answers);

		newAnswers(2, "использование методов в наследуемых классах с одинаковими именами и разными сигнатурами",
				"использование методов в одном классе с одинаковими именами и разными сигнатурами",
				"использование методов в наследуемых классах с одинаковими именами и сигнатурами");
		newQuestion("Что такое переопределение?", (ArrayList<Answer>) answers);

		newAnswers(1, "использование методов в одном классе с одинаковими именами и сигнатурами",
				"использование методов в одном классе с одинаковими именами и разными сигнатурами",
				"использование методов в наследуемых классах с одинаковими именами и разными сигнатурами");
		newQuestion("Что такое перегрузка?", (ArrayList<Answer>) answers);

		newTopic("Полиморфизм", questions);

		newAnswers(1, "механизм, который архивирует данные", "механизм, которые объединяет данные и методы",
				"механизм взаимодействия данных и методов");
		newQuestion("Что такое инкапсуляция?", (ArrayList<Answer>) answers);

		newAnswers(2, "public", "private", "package-private", "protected");
		newQuestion("Какой модификатор доступа используется по умолчанию?", (ArrayList<Answer>) answers);

		newAnswers(2, "статические поля и блоки подкласса", "выполняется конструктор",
				"статические поля и блоки суперкласса", "нестатические поля и блоки суперкласса",
				"нестатические поля и блоки подкласса");
		newQuestion("При создании объекта что инициализируется в первую очередь?", (ArrayList<Answer>) answers);

		newTopic("Инкапсуляция", questions);

		newSection("ООП", topics);

		newAnswers(2, "примитивный тип данных", "ключевое слово", "ссылочный тип данных");
		newQuestion("Что  такое String в JAVA?", (ArrayList<Answer>) answers);

		newAnswers(0, "последовательность символов, заключенная в двойные кавычки",
				"последовательность символов, заключенная в одинарные кавычки", "тип данных", "массив символов");
		newQuestion("Что такое \"строковый литерал\"?", (ArrayList<Answer>) answers);

		newAnswers(0, "length()", "append()", "charAt()", "trim()", "contain()");
		newQuestion("Какой метод не используется с типом String?", (ArrayList<Answer>) answers);

		newTopic("Строки", questions);

		newAnswers(1, "динамическая", "статическая");
		newQuestion("Какая типизация используется в JAVA?", (ArrayList<Answer>) answers);

		newAnswers(4, "byte", "short", "long", "int", "list");
		newQuestion("Какой тип не является примитивным?", (ArrayList<Answer>) answers);

		newTopic("Примитивные типы", questions);

		newAnswers(2, "size", "volume", "length");
		newQuestion("Какой метод позволяет узнать размер массива?", (ArrayList<Answer>) answers);

		newTopic("Массивы", questions);

		newSection("Типы данных", topics);

		fileLoader.saveData((ArrayList<Section>) sections);

	}

	private void newSection(String sectionName, List<Topic> topics) {
		Section section = new Section();
		section.setSectionName(sectionName);
		section.setTopics(topics);
		sections.add(section);
		this.topics = new ArrayList<Topic>();
		this.questions = new ArrayList<Question>();
		this.answers = new ArrayList<Answer>();
	}

	private void newTopic(String topicName, List<Question> questions) {

		Topic topic = new Topic();
		topic.setTopicName(topicName);
		topic.setQuestions(questions);
		topic.setSelectedInTree(true);
		topics.add(topic);
		this.questions = new ArrayList<Question>();
		this.answers = new ArrayList<Answer>();

	}

	private void newQuestion(String questionText, ArrayList<Answer> answers) {

		Question question = new Question();
		question.setAnswers(answers);
		question.setQuestionText(questionText);
		question.setAnswered(false);
		questions.add(question);
		this.answers = new ArrayList<Answer>();

	}

	private void newAnswers(int correctAnswer, String... answersText) {
		Answer answer;
		for (int i = 0; i < answersText.length; i++) {
			answer = new Answer();
			answer.setAnswerText(answersText[i]);
			answer.setIsSelected(false);
			if (i == correctAnswer) {
				answer.setIsCorrect(true);
			} else {
				answer.setIsCorrect(false);
			}
			answers.add(answer);
		}

	}

}
