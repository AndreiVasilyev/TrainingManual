package by.bobruisk.trainingmanual.listener.statisticsPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import by.bobruisk.trainingmanual.gui.ViewStatisticPanel;

public class StudentsListMouseListener implements MouseListener {

	private ViewStatisticPanel viewStatisticPanel;

	public StudentsListMouseListener(ViewStatisticPanel viewStatisticPanel) {

		this.viewStatisticPanel = viewStatisticPanel;

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			viewStatisticPanel.refreshStatisticsTextArea();
		}
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
