package by.bobruisk.trainingmanual.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import by.bobruisk.trainingmanual.data.QuestionsDataBase;
import by.bobruisk.trainingmanual.listener.selectionthemspanel.ResetOrSelectAllButtonListener;
import by.bobruisk.trainingmanual.listener.selectionthemspanel.SaveCurrentValuesButtonListener;
import by.bobruisk.trainingmanual.listener.selectionthemspanel.TreeMouseListener;
import by.bobruisk.trainingmanual.model.Section;

public class SelectionThemesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	private JScrollPane scrollPane;
	public JTree themsTree;
	private DefaultTreeModel model;
	private JButton saveCurrentValuesButton;
	private JButton selectAllButton;
	private JButton resetAllSelectionsButton;
	public QuestionsDataBase questionsDataBase;
	public DefaultMutableTreeNode rootNode;
	private DefaultMutableTreeNode sectionNode;
	private DefaultMutableTreeNode topicNode;

	public SelectionThemesPanel(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		questionsDataBase = mainWindow.questionsDataBase;
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Выбор тем для теста"));
		rootNode = new DefaultMutableTreeNode("Язык программирования JAVA");
		createThemsTree();
		scrollPane = new JScrollPane(themsTree);
		createButtons();
		add(scrollPane, new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
		add(selectAllButton, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 5, 5), 0, 0));
		add(resetAllSelectionsButton, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 5, 5), 0, 0));
		add(saveCurrentValuesButton, new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 5, 5), 0, 0));
		sectionNode = null;
		topicNode = null;
	}

	private void createButtons() {
		saveCurrentValuesButton = new JButton("Сохранить");
		saveCurrentValuesButton.addActionListener(new SaveCurrentValuesButtonListener(mainWindow));
		selectAllButton = new JButton("Выделить все");
		selectAllButton.addActionListener(new ResetOrSelectAllButtonListener(this, true));
		resetAllSelectionsButton = new JButton("Сбросить все");
		resetAllSelectionsButton.addActionListener(new ResetOrSelectAllButtonListener(this, false));

	}

	public void createThemsTree() {

		createNodes(questionsDataBase.getSections(), rootNode);
		model = new DefaultTreeModel(rootNode);
		themsTree = new JTree(model);
		themsTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
		themsTree.setCellRenderer(renderer);
		themsTree.setEditable(false);
		themsTree.addMouseListener(new TreeMouseListener(this));
	}

	private void createNodes(List<Section> sections, DefaultMutableTreeNode Node) {

		if (sections != null) {
			for (int i = 0; i < sections.size(); i++) {
				sectionNode = new DefaultMutableTreeNode(sections.get(i).getSectionName());
				Node.add(sectionNode);
				if (sections.get(i).getTopics() != null && !sections.get(i).getTopics().isEmpty()) {

					for (int j = 0; j < sections.get(i).getTopics().size(); j++) {
						boolean isSelected = sections.get(i).getTopics().get(j).isSelectedInTree();
						topicNode = new DefaultMutableTreeNode(
								new CheckBoxNode(sections.get(i).getTopics().get(j).getTopicName(), isSelected));
						sectionNode.add(topicNode);
					}
				}
				if (sections.get(i).getSubSections() != null && !sections.get(i).getSubSections().isEmpty()) {
					createNodes(sections.get(i).getSubSections(), sectionNode);

				}

			}
		}
	}

}
