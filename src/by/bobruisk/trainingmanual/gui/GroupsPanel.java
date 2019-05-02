package by.bobruisk.trainingmanual.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.AllGroupsComboBoxListener;
import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.NewGroupButtonListener;
import by.bobruisk.trainingmanual.model.Group;

public class GroupsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private SelectCurrentUserWindow selectCurrentUserWindow;
	public JComboBox<String> allGroupsComboBox;
	private DefaultComboBoxModel<String> model;
	private JLabel newGroupLabel;
	public JTextField newGroupTextField;
	private JButton newGroupButton;

	public GroupsPanel(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Группы"));
		createComponents();
		add(allGroupsComboBox, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(newGroupLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(15, 5, 0, 5), 0, 0));
		add(newGroupTextField, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(15, 5, 5, 5), 0, 0));
		add(newGroupButton, new GridBagConstraints(1, 2, 1, 1, 0, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

	}

	private void createComponents() {

		model = new DefaultComboBoxModel<>();
		refreshComboBoxModelData();
		allGroupsComboBox = new JComboBox<String>(model);
		allGroupsComboBox.addActionListener(new AllGroupsComboBoxListener(selectCurrentUserWindow));
		newGroupTextField = new JTextField();
		newGroupButton = new JButton("Добавить");
		newGroupButton.addActionListener(new NewGroupButtonListener(selectCurrentUserWindow));
		newGroupLabel = new JLabel("Новая группа:");

	}

	public void refreshComboBoxModelData() {
		model.removeAllElements();
		List<Group> allGroups = selectCurrentUserWindow.mainWindow.usersDataBase.getGroups();
		for (int i = 0; i < allGroups.size(); i++) {
			model.addElement(allGroups.get(i).toString());
		}

	}
}
