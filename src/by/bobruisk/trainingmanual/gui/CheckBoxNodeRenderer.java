package by.bobruisk.trainingmanual.gui;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

class CheckBoxNodeRenderer extends JCheckBox implements TreeCellRenderer {
	private static final long serialVersionUID = 1L;
	private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

	public CheckBoxNodeRenderer() {
		setOpaque(false);

	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {

		if (!(value instanceof DefaultMutableTreeNode)) {

			return nonLeafRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		}
		Object data = ((DefaultMutableTreeNode) value).getUserObject();
		if (data instanceof CheckBoxNode) {
			CheckBoxNode element = (CheckBoxNode) data;
			setSelected(element.isSelected());
			setText(element.getText());
			return this;
		}
		return nonLeafRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
	}

}