package by.bobruisk.trainingmanual.listener.statisticsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.MainWindow;


public class GroupsComboBoxListener implements ActionListener {

	private MainWindow mainWindow;

	public GroupsComboBoxListener(MainWindow mainWindow) {

		this.mainWindow = mainWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (mainWindow.viewStatisticPanel.groupsComboBox.getSelectedItem() != null
				&& !mainWindow.viewStatisticPanel.groupsComboBox.getSelectedItem().toString().isEmpty()) {
			mainWindow.viewStatisticPanel.refreshStudentsModel();
			mainWindow.viewStatisticPanel.studentStatisticsTextArea.setText("");
		}

	}

}
