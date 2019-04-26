package by.bobruisk.trainingmanual.gui;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	private Image image = null;

	public MainPanel(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Здеся будет доп функционал"));
		try {

			image = ImageIO.read(new File("res/java.jpg"));

		} catch (IOException e) {

			ExceptionsDialods.showReadExceptionDialog("Ошибка фона", "Сбой загрузки фонового изображения!");
		}
	}

	@Override
	public void paintComponent(Graphics backgroundImage) {

		super.paintComponent(backgroundImage);

		backgroundImage.drawImage(image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0,
				this);

	}

}
