package by.bobruisk.trainingmanual.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import by.bobruisk.trainingmanual.data.Login;
import by.bobruisk.trainingmanual.gui.MainWindow;

public class OkButtonActionListener implements ActionListener {

	private MainWindow mainWindow;

	public OkButtonActionListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (Login.authenticate(mainWindow.loginDialog.getUsername(), mainWindow.loginDialog.getPassword())) {
			this.mainWindow.loginDialog.setSucceeded(true);
			mainWindow.remove(mainWindow.mainPanel);
			mainWindow.mainPanel = null;
			mainWindow.createInputNewQuestionPanel();
			mainWindow.loginDialog.dispose();
		} else {
			JOptionPane.showMessageDialog(mainWindow.loginDialog, "Неправильный логин или пароль!", "Ошибка",
					JOptionPane.ERROR_MESSAGE);

			mainWindow.loginDialog.tfUsername.setText("");
			mainWindow.loginDialog.pfPassword.setText("");
			mainWindow.loginDialog.setSucceeded(false);

		}

	}

}
