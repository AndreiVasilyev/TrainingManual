package by.bobruisk.trainingmanual.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.AdminModeButtonListener;
import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.DeleteStudentButtonListener;
import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.NewStudentButtonListener;
import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.RandomStudentButtonListener;
import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.RemoveStudentButtonListener;
import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.SelectStudentButtonListener;
import by.bobruisk.trainingmanual.model.Group;
import by.bobruisk.trainingmanual.model.Student;

public class StudentsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private SelectCurrentUserWindow selectCurrentUserWindow;
	public JList<String> studentsList;
	private DefaultListModel<String> listModel;
	private JLabel newStudentLabel;
	private JLabel nameLabel;
	private JLabel surnameLabel;
	public JTextField nameTextField;
	public JTextField surnameTextField;
	private JButton newStudentButton;
	private JButton removeStudentButton;
	private JButton deleteStudentButton;
	private JButton selectStudentButton;
	private JButton randomStudentButton;
	private JButton adminModeButton;
	private JScrollPane listScrollPane;
	public Group currentGroup;
	public List<Student> studentsForModel;

	public StudentsPanel(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Студенты"));
		createComponents();
		add(listScrollPane, new GridBagConstraints(0, 0, 1, 6, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
		add(newStudentLabel, new GridBagConstraints(1, 0, 2, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
		add(nameLabel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		add(surnameLabel, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		add(nameTextField, new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(surnameTextField, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(newStudentButton, new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 20, 5), 0, 0));
		add(deleteStudentButton, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(20, 0, 5, 5), 0, 0));
		add(removeStudentButton, new GridBagConstraints(1, 5, 2, 1, 0, 0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 0, 30, 5), 0, 0));
		add(selectStudentButton, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.NORTHEAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(randomStudentButton, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.NORTHEAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(adminModeButton, new GridBagConstraints(1, 7, 2, 1, 0, 1, GridBagConstraints.SOUTHEAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

	}

	private void createComponents() {

		studentsList = new JList<String>();
		listModel = new DefaultListModel<String>();
		refreshStudentsModel();
		studentsList.setModel(listModel);
		studentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentsList.setLayoutOrientation(JList.VERTICAL);
		studentsList.setVisibleRowCount(10);
		newStudentLabel = new JLabel("Новый студент:");
		nameLabel = new JLabel("Имя:");
		surnameLabel = new JLabel("Фамилия:");
		nameTextField = new JTextField();
		surnameTextField = new JTextField();
		newStudentButton = new JButton("Добавить");
		newStudentButton.addActionListener(new NewStudentButtonListener(selectCurrentUserWindow));
		removeStudentButton = new JButton("Убрать из списка");
		removeStudentButton.addActionListener(new RemoveStudentButtonListener(selectCurrentUserWindow));
		deleteStudentButton= new JButton("Удалить");
		deleteStudentButton.addActionListener(new DeleteStudentButtonListener(selectCurrentUserWindow));
		selectStudentButton = new JButton("Выбрать выделенного");
		selectStudentButton.addActionListener(new SelectStudentButtonListener(selectCurrentUserWindow));
		randomStudentButton = new JButton("Выбрать случайно из списка");
		randomStudentButton.addActionListener(new RandomStudentButtonListener(selectCurrentUserWindow));
		listScrollPane = new JScrollPane(studentsList);
		adminModeButton = new JButton("Выбрать administrator");
		adminModeButton.addActionListener(new AdminModeButtonListener(selectCurrentUserWindow));
	}

	public void refreshStudentsModel() {

		studentsForModel = new ArrayList<Student>();
		String currentGroupName = (String) selectCurrentUserWindow.groupsPanel.allGroupsComboBox.getSelectedItem();
		if (currentGroupName != null && !currentGroupName.isEmpty()) {
			currentGroup = selectCurrentUserWindow.mainWindow.usersDataBase.getGroups().stream()
					.filter(group -> group.getGroupName().equals(currentGroupName)).findFirst().get();
			if (!currentGroup.getStudents().isEmpty()) {
				for (Student student : currentGroup.getStudents()) {
					studentsForModel.add(student);
				}

			}
		}
		refreshStudentsList();
	}

	public void refreshStudentsList() {

		listModel.removeAllElements();
		for (Student student : studentsForModel) {

			listModel.addElement(student.toString());
		}

	}

}
