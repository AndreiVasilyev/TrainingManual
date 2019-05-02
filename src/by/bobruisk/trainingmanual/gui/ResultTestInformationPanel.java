package by.bobruisk.trainingmanual.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import by.bobruisk.trainingmanual.data.Test;
import by.bobruisk.trainingmanual.listener.runtestpanel.CloseInformationPanelButtonListener;
import by.bobruisk.trainingmanual.model.Result;
import by.bobruisk.trainingmanual.model.Student;

public class ResultTestInformationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	private Test test;
	private JLabel mainTextLabel;
	private JLabel currentStudentLabel;
	private JLabel statusLabel;
	private JLabel statusValue;
	private JLabel correctAnswersLabel;
	private JLabel correctAnswersValue;
	private JLabel persentsLabel;
	private JLabel persentsValue;
	private JButton closeInformationPanelButton;
	private String currentUser;
	private int testPassingPersent;

	public ResultTestInformationPanel(MainWindow mainWindow) {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Результаты теста"));
		this.mainWindow = mainWindow;
		test = mainWindow.questionsDataBase.test;
		testPassingPersent = (int) ((float) test.getRightAnswersCount() / (float) test.getTestQuestionsCount()
				* 100);
		if(mainWindow.usersDataBase.getCurrentUser()!=null) {
			currentUser=mainWindow.usersDataBase.getCurrentUser().toString();
			saveResults();
		} else {
			currentUser=mainWindow.usersDataBase.getDEFAULT_USER();
			
		}
		createPanelElements();

		
	}

	
	private void createPanelElements() {

		
		String status = (testPassingPersent >= test.getTEST_PASSING_LEVEL_PERSENT()) ? "СДАН" : "НЕ СДАН";
		mainTextLabel = new JLabel("ТЕСТ ЗАВЕРШЕН");
		mainTextLabel.setFont(mainTextLabel.getFont().deriveFont(Font.BOLD, 35f));
		mainTextLabel.setForeground(Color.BLUE);
		currentStudentLabel = new JLabel(currentUser);
		statusLabel = new JLabel("Статус: ");
		statusValue = new JLabel(status);
		correctAnswersLabel = new JLabel("Количество правильных ответов: ");
		correctAnswersValue = new JLabel(test.getRightAnswersCount() + "/" + test.getTestQuestionsCount());
		persentsLabel = new JLabel("Набрано проценов: ");
		persentsValue = new JLabel(testPassingPersent + "% / 100%");
		closeInformationPanelButton = new JButton("OK");
		closeInformationPanelButton.setPreferredSize(new Dimension(100, 30));
		closeInformationPanelButton.addActionListener(new CloseInformationPanelButtonListener(mainWindow));
		add(mainTextLabel, new GridBagConstraints(0, 0, 4, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 5, 5), 0, 0));
		add(currentStudentLabel, new GridBagConstraints(0, 1, 4, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(20, 5, 5, 5), 0, 0));
		add(statusLabel, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(40, 5, 5, 5), 0, 0));
		add(statusValue, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(40, 0, 5, 5), 0, 0));
		add(correctAnswersLabel, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 50, 5, 5), 0, 0));
		add(correctAnswersValue, new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		add(persentsLabel, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 40, 5), 0, 0));
		add(persentsValue, new GridBagConstraints(2, 4, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 0, 40, 5), 0, 0));
		add(closeInformationPanelButton, new GridBagConstraints(0, 5, 4, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(40, 5, 5, 5), 0, 0));

	}
	
	private void saveResults() {
		
		Student student=mainWindow.usersDataBase.getCurrentUser();
		List<String> topics = mainWindow.questionsDataBase.getSelectedTopics();
		if(student.getPassedTests()==null) {
			List<Result> results=new ArrayList<Result>();
			student.setPassedTests(results);
		}
		Result result=new Result();
		result.setTopics(topics);
		result.setDate(LocalDateTime.now().toString());
		result.setPersents(testPassingPersent);
		result.setCountAnswers(test.getRightAnswersCount() + "/" + test.getTestQuestionsCount());
		student.getPassedTests().add(result);
		mainWindow.usersDataBase.saveChanges();
	}
}
