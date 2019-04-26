package by.bobruisk.trainingmanual.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import by.bobruisk.trainingmanual.data.QuestionsDataBase;
import by.bobruisk.trainingmanual.listener.mainwindowelements.AdministrationModeItemListener;
import by.bobruisk.trainingmanual.listener.mainwindowelements.ExitMenuItemListener;
import by.bobruisk.trainingmanual.listener.mainwindowelements.RunTestMenuItemListener;
import by.bobruisk.trainingmanual.listener.mainwindowelements.SelectionThemesMenuItemListener;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	public JMenuBar menuBar;
	public JMenu menu;
	public JMenuItem menuItem;
	public SelectionThemesPanel selectionThemesPanel;
	public RunTestPanel runTestPanel;
	public ResultTestInformationPanel resultTestInformationPanel;
	public QuestionsDataBase questionsDataBase;
	public LoginDialog loginDialog;
	public InputNewQuestionPanel inputNewQuestionPanel;
	public MainPanel mainPanel;

	public MainWindow(QuestionsDataBase questionsDataBase) {

		setMainWindowParameters();
		createMenu();
		createMainPanel();
		packDefaultComponents();
		this.questionsDataBase = questionsDataBase;

	}

	private void packDefaultComponents() {
		menuBar.add(menu);
		setJMenuBar(menuBar);

	}

	public void createLoginDialog() {
		loginDialog = new LoginDialog(this);
		loginDialog.setVisible(true);
		if (loginDialog.isSucceeded()) {
			loginDialog.setSucceeded(false);
		}
	}
	
	public void createMainPanel() {
		mainPanel = new MainPanel(this);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		validate();
	}

	public void createInputNewQuestionPanel() {
		inputNewQuestionPanel = new InputNewQuestionPanel(this);
		getContentPane().add(inputNewQuestionPanel, BorderLayout.CENTER);
		validate();
	}

	public void createSelectionThemesPanel() {
		selectionThemesPanel = new SelectionThemesPanel(this);
		getContentPane().add(selectionThemesPanel, BorderLayout.CENTER);
		validate();
	}

	public void createRunTestPanel() {
		runTestPanel = new RunTestPanel(this);
		getContentPane().add(runTestPanel, BorderLayout.CENTER);
		validate();
	}

	public void createResultTestInformationPanel() {
		resultTestInformationPanel = new ResultTestInformationPanel(this);
		getContentPane().add(resultTestInformationPanel, BorderLayout.CENTER);
		validate();
	}

	public void createMenu() {
		menuBar = new JMenuBar();
		menu = new JMenu("Меню");
		menu.setMnemonic(KeyEvent.VK_V);
		menu.setDisplayedMnemonicIndex(0);
		createRunTestMenuItem();
		menu.add(menuItem);
		createChooseSectionMenuItem();
		menu.add(menuItem);
		menu.addSeparator();
		createAdministrationModeItem();
		menu.add(menuItem);
		menu.addSeparator();
		createExitMenuItem();
		menu.add(menuItem);

	}

	private void createAdministrationModeItem() {
		menuItem = new JMenuItem("Режим администрирования", KeyEvent.VK_F);
		menuItem.setDisplayedMnemonicIndex(6);
		AdministrationModeItemListener administrationModeItemListener = new AdministrationModeItemListener(this);
		menuItem.addActionListener(administrationModeItemListener);
	}

	private void createExitMenuItem() {
		menuItem = new JMenuItem("Выход", KeyEvent.VK_S);
		menuItem.setDisplayedMnemonicIndex(1);
		ExitMenuItemListener exitMenuItemListener = new ExitMenuItemListener();
		menuItem.addActionListener(exitMenuItemListener);
	}

	private void createChooseSectionMenuItem() {
		menuItem = new JMenuItem("Выбрать темы для теста", KeyEvent.VK_D);
		menuItem.setDisplayedMnemonicIndex(0);
		menuItem.getAccessibleContext().setAccessibleDescription("Позволяет выбрать возможные темы");
		SelectionThemesMenuItemListener selectionThemesMenuItemListener = new SelectionThemesMenuItemListener(this);
		menuItem.addActionListener(selectionThemesMenuItemListener);
	}

	private void createRunTestMenuItem() {
		menuItem = new JMenuItem("Запустить тест", KeyEvent.VK_P);
		menuItem.setDisplayedMnemonicIndex(0);
		menuItem.getAccessibleContext().setAccessibleDescription("Запускает тест");
		RunTestMenuItemListener runTestMenuItemListener = new RunTestMenuItemListener(this);
		menuItem.addActionListener(runTestMenuItemListener);
	}

	private void setMainWindowParameters() {
		setSize(700, 500);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void deactivateMenu() {
		getJMenuBar().getMenu(0).setEnabled(false);
		getJMenuBar().validate();
		getJMenuBar().repaint();
	}
	
	public void activateMenu() {
		getJMenuBar().getMenu(0).setEnabled(true);
		getJMenuBar().validate();
		getJMenuBar().repaint();
	}

}