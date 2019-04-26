package by.bobruisk.trainingmanual.listener.selectionthemspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import by.bobruisk.trainingmanual.gui.CheckBoxNode;
import by.bobruisk.trainingmanual.gui.SelectionThemesPanel;

public class TreeMouseListener implements MouseListener {
	private SelectionThemesPanel selectionThemesPanel;

	public TreeMouseListener(SelectionThemesPanel selectionThemesPanel) {
		this.selectionThemesPanel = selectionThemesPanel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		TreePath path = selectionThemesPanel.themsTree.getClosestPathForLocation(e.getX(), e.getY());
		if (path == null)
			return;
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
		if (node.getUserObject() instanceof CheckBoxNode) {
			CheckBoxNode element = (CheckBoxNode) node.getUserObject();
			element.setSelected(!element.isSelected());
			selectionThemesPanel.themsTree.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
