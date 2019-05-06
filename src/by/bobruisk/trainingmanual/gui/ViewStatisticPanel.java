package by.bobruisk.trainingmanual.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import by.bobruisk.trainingmanual.listener.statisticsPanel.ClosePanelButtonListener;
import by.bobruisk.trainingmanual.listener.statisticsPanel.GroupsComboBoxListener;
import by.bobruisk.trainingmanual.listener.statisticsPanel.StudentsListMouseListener;
import by.bobruisk.trainingmanual.model.Group;
import by.bobruisk.trainingmanual.model.Student;

public class ViewStatisticPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	private List<Group> groups;
	public JComboBox<String> groupsComboBox;
	private DefaultComboBoxModel<String> model;
	public JList<String> studentsList;
	private DefaultListModel<String> listModel;
	private JScrollPane listScrollPane;
	private JScrollPane textAreaScrollPane;
	public JTextArea studentStatisticsTextArea;
	private JButton closePanelButton;
	private Group currentGroup;

	public ViewStatisticPanel(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		groups = mainWindow.usersDataBase.getGroups();
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Статистика"));
		createGroupsComboBox();
		createStudentsList();
		listScrollPane = new JScrollPane(studentsList);
		createStatisticsTextArea();
		textAreaScrollPane = new JScrollPane(studentStatisticsTextArea);
		createButton();
		add(groupsComboBox, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(listScrollPane, new GridBagConstraints(1, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
		add(textAreaScrollPane, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		add(closePanelButton, new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 5, 5), 0, 0));

	}

	public void refreshComboBoxModelData() {
		model.removeAllElements();
		for (int i = 0; i < groups.size(); i++) {
			model.addElement(groups.get(i).toString());
		}
	}

	public void refreshStudentsModel() {
		listModel.removeAllElements();
		String currentGroupName = (String) groupsComboBox.getSelectedItem();
		if (currentGroupName != null && !currentGroupName.isEmpty()) {
			currentGroup = groups.stream().filter(group -> group.getGroupName().equals(currentGroupName)).findFirst()
					.get();
			if (!currentGroup.getStudents().isEmpty()) {
				for (Student student : currentGroup.getStudents()) {
					listModel.addElement(student.toString());
				}
			}
		}
	}

	public void refreshStatisticsTextArea() {
		studentStatisticsTextArea.setText("");
		if (!studentsList.isSelectionEmpty()) {
			String currentStudentName = studentsList.getSelectedValue();
			Student currentStudent = currentGroup.getStudents().stream()
					.filter(student -> student.toString().equals(currentStudentName)).findFirst().get();
			if (currentStudent.getPassedTests() != null && !currentStudent.getPassedTests().isEmpty()) {
				for (int i = 0; i < currentStudent.getPassedTests().size(); i++) {
					studentStatisticsTextArea.append("Тест " + (i + 1) + "\n\n");
					studentStatisticsTextArea
							.append("Дата: " + currentStudent.getPassedTests().get(i).getDate() + "\n");
					studentStatisticsTextArea
							.append("Набрано: " + currentStudent.getPassedTests().get(i).getPersents() + "%\n");
					studentStatisticsTextArea.append(
							"Правильных ответов: " + currentStudent.getPassedTests().get(i).getResultText() + "\n");
					studentStatisticsTextArea.append("Темы теста: \n");
					for (int j = 0; j < currentStudent.getPassedTests().get(i).getTopics().size(); j++) {
						studentStatisticsTextArea
								.append("\t" + currentStudent.getPassedTests().get(i).getTopics().get(j) + "\n");
					}
					studentStatisticsTextArea.append("\n\n\n-------------------------------------------------------\n");
				}
			} else {
				studentStatisticsTextArea.setText("<пусто>");
			}
		}
	}

	private void createGroupsComboBox() {
		model = new DefaultComboBoxModel<>();
		refreshComboBoxModelData();
		groupsComboBox = new JComboBox<String>(model);
		groupsComboBox.addActionListener(new GroupsComboBoxListener(mainWindow));
		groupsComboBox.setPreferredSize(new Dimension(150, 30));

	}

	private void createStudentsList() {
		studentsList = new JList<String>();
		listModel = new DefaultListModel<String>();
		refreshStudentsModel();
		studentsList.setModel(listModel);
		studentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentsList.setLayoutOrientation(JList.VERTICAL);
		studentsList.setVisibleRowCount(10);
		studentsList.setPreferredSize(new Dimension(200, 200));
		studentsList.addMouseListener(new StudentsListMouseListener(this));

	}

	private void createStatisticsTextArea() {

		studentStatisticsTextArea = new JTextArea("");
		studentStatisticsTextArea.setEditable(false);
		studentStatisticsTextArea.setBorder(BorderFactory.createTitledBorder("Статистика"));

	}

	private void createButton() {
		closePanelButton = new JButton("Закрыть");
		closePanelButton.addActionListener(new ClosePanelButtonListener(mainWindow));

	}

}
