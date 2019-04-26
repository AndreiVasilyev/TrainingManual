package by.bobruisk.trainingmanual.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import by.bobruisk.trainingmanual.listener.DialogWindowListener;
import by.bobruisk.trainingmanual.listener.OkButtonActionListener;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	public JTextField tfUsername;
	public JPasswordField pfPassword;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JButton btnLogin;
	private boolean succeeded;

	public LoginDialog(MainWindow mainWindow) {
		super(mainWindow, "Аутентификация", true);
		this.mainWindow = mainWindow;
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		lbUsername = new JLabel("Имя: ");
		panel.add(lbUsername, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		tfUsername = new JTextField(10);
		panel.add(tfUsername, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		lbPassword = new JLabel("Пароль: ");
		panel.add(lbPassword, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		pfPassword = new JPasswordField(10);
		panel.add(pfPassword, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		panel.setBorder(new LineBorder(Color.GRAY));
		btnLogin = new JButton("OK");
		OkButtonActionListener okButtonActionListener = new OkButtonActionListener(this.mainWindow);
		btnLogin.addActionListener(okButtonActionListener);
		panel.add(btnLogin, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		pack();
		setResizable(false);
		setLocationRelativeTo(this.mainWindow);
		addWindowListener(new DialogWindowListener(this.mainWindow));
	}

	public String getUsername() {

		return tfUsername.getText().trim();
	}

	public String getPassword() {
		return new String(pfPassword.getPassword());
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {

		this.succeeded = succeeded;
	}

}