package by.bobruisk.trainingmanual.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import by.bobruisk.trainingmanual.exceptionHandling.FileLoaderException;
import by.bobruisk.trainingmanual.listener.mainPanel.SelectUserButtonListener;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	private Image image = null;
	private JLabel titleLable;
	private JLabel currentUserLable;
	public JLabel currentUserNameLable;
	public JButton selectUserButton;
	private String currentUserName;

	public MainPanel(MainWindow mainWindow) throws FileLoaderException {

		this.mainWindow = mainWindow;
		if (mainWindow.usersDataBase.getCurrentUser() != null) {
			currentUserName = mainWindow.usersDataBase.getCurrentUser().getSurname() + " "
					+ mainWindow.usersDataBase.getCurrentUser().getName();
		} else {
			currentUserName = mainWindow.usersDataBase.getDEFAULT_USER();
		}

		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder()));
		try {

			image = ImageIO.read(new File("res/java.jpg"));

		} catch (IOException currentException) {

			throw new FileLoaderException("Сбой загрузки фонового изображения!", currentException);
		}
		createComponents();
		add(titleLable, new GridBagConstraints(0, 0, 2, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.CENTER,
				new Insets(15, 5, 5, 5), 0, 0));
		add(currentUserLable, new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		add(currentUserNameLable, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 15, 5, 5), 0, 0));
		add(selectUserButton, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 15, 5), 0, 0));

	}

	@Override
	public void paintComponent(Graphics backgroundImage) {

		super.paintComponent(backgroundImage);

		backgroundImage.drawImage(image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0,
				this);

	}

	private void createComponents() {

		selectUserButton = new JButton("Выбрать студента");
		selectUserButton.setForeground(Color.DARK_GRAY);
		selectUserButton.setFont(new Font("Arial", Font.BOLD, 14));
		selectUserButton.setPreferredSize(new Dimension(180, 40));
		selectUserButton.addActionListener(new SelectUserButtonListener(mainWindow));
		titleLable = new JLabel("Проверка знаний по курсу \"Язык программирования JAVA\"");
		titleLable.setFont(new Font("Arial Black", Font.BOLD, 16));
		titleLable.setForeground(Color.DARK_GRAY);
		currentUserLable = new JLabel("Текущий пользователь:");
		currentUserLable.setForeground(Color.DARK_GRAY);
		currentUserNameLable = new JLabel(currentUserName);
		currentUserNameLable.setForeground(Color.DARK_GRAY);
	}

}
