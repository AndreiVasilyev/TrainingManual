package by.bobruisk.trainingmanual.listener.selectCurrentUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bobruisk.trainingmanual.gui.SelectCurrentUserWindow;

public class AllGroupsComboBoxListener implements ActionListener {

	private SelectCurrentUserWindow selectCurrentUserWindow;

	public AllGroupsComboBoxListener(SelectCurrentUserWindow selectCurrentUserWindow) {

		this.selectCurrentUserWindow = selectCurrentUserWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (selectCurrentUserWindow.groupsPanel.allGroupsComboBox.getSelectedItem() != null
				&& !selectCurrentUserWindow.groupsPanel.allGroupsComboBox.getSelectedItem().toString().isEmpty()) {
			selectCurrentUserWindow.studentsPanel.refreshStudentsModel();
		}

	}

}
