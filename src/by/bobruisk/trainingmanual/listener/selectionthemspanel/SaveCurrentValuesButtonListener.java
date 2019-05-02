package by.bobruisk.trainingmanual.listener.selectionthemspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import by.bobruisk.trainingmanual.data.QuestionsDataBase;
import by.bobruisk.trainingmanual.gui.MainWindow;
import by.bobruisk.trainingmanual.model.Question;

public class SaveCurrentValuesButtonListener implements ActionListener {
	private MainWindow mainWindow;
	private QuestionsDataBase questionsDataBase;
	private DefaultMutableTreeNode rootNode;

	public SaveCurrentValuesButtonListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		questionsDataBase = mainWindow.questionsDataBase;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		rootNode = mainWindow.selectionThemesPanel.rootNode;
		questionsDataBase.setQuestionsForTest(new ArrayList<Question>());
		questionsDataBase.setSelectedTopics(new ArrayList<String>());
		questionsDataBase.createQuestionsForTest(rootNode, null);
		if (questionsDataBase.getQuestionsForTest().isEmpty()) {
			JOptionPane.showMessageDialog(mainWindow.selectionThemesPanel,
					"Для сохранения должна быть выбрана хотя бы одна тема!");
			return;
		}
		mainWindow.remove(mainWindow.selectionThemesPanel);
		mainWindow.selectionThemesPanel = null;
		mainWindow.activateMenu();
		mainWindow.createMainPanel();
		mainWindow.repaint();

	}

}
