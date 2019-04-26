package by.bobruisk.trainingmanual.listener.selectionthemspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import by.bobruisk.trainingmanual.gui.CheckBoxNode;
import by.bobruisk.trainingmanual.gui.SelectionThemesPanel;

public class ResetOrSelectAllButtonListener implements ActionListener {
	private SelectionThemesPanel selectionThemesPanel;
	private DefaultMutableTreeNode rootNode;
	private boolean value;

	public ResetOrSelectAllButtonListener(SelectionThemesPanel selectionThemesPanel, boolean value) {
		this.selectionThemesPanel = selectionThemesPanel;
		rootNode = selectionThemesPanel.rootNode;
		this.value = value;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		resetNode(rootNode);
		selectionThemesPanel.themsTree.repaint();
	}

	private void resetNode(DefaultMutableTreeNode node) {
		DefaultMutableTreeNode currentNode;
		for (int i = 0; i < node.getChildCount(); i++) {
			currentNode = (DefaultMutableTreeNode) node.getChildAt(i);
			if (currentNode.getUserObject() instanceof CheckBoxNode) {
				CheckBoxNode currentCheckBoxNode = (CheckBoxNode) currentNode.getUserObject();
				currentCheckBoxNode.setSelected(value);
			} else {
				resetNode(currentNode);
			}

		}
	}
}
