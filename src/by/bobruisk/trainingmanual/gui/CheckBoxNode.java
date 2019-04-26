package by.bobruisk.trainingmanual.gui;

public class CheckBoxNode {
	private String textNode;
	private boolean selectedNode;

	public CheckBoxNode(String textNode, boolean selectedNode) {
		this.textNode = textNode;
		this.selectedNode = selectedNode;

	}

	public boolean isSelected() {
		return selectedNode;
	}

	public void setSelected(boolean newValue) {
		selectedNode = newValue;
	}

	public String getText() {
		return textNode;
	}

	public void setText(String newValue) {
		textNode = newValue;
	}

	public String toString() {
		return getClass().getName() + "[" + textNode + "/" + selectedNode + "]";
	}
}