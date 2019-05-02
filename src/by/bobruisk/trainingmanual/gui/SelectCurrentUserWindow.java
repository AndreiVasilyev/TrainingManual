package by.bobruisk.trainingmanual.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import by.bobruisk.trainingmanual.listener.selectCurrentUserWindow.SelectCurrentUserWindowListener;

public class SelectCurrentUserWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	public GroupsPanel groupsPanel;
	public StudentsPanel studentsPanel;
	public MainWindow mainWindow;

	public SelectCurrentUserWindow(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
		setWindowParameters();
		createGroupsPanel();
		createStudentsPanel();
		pack();

	}

	private void createStudentsPanel() {
		studentsPanel = new StudentsPanel(this);
		getContentPane().add(studentsPanel, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 0, 5, 5), 0, 0));
		validate();

	}

	private void createGroupsPanel() {
		groupsPanel = new GroupsPanel(this);
		getContentPane().add(groupsPanel, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		validate();

	}

	private void setWindowParameters() {
		setSize(600, 400);
		setResizable(true);
		setLayout(new GridBagLayout());
		setLocationRelativeTo(null);
		addWindowListener(new SelectCurrentUserWindowListener(mainWindow));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
