package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SortingAnimationPanel extends JPanel {
	
	private String sortName;
	
	private int max;
	
	private final static int ELEMENT_WIDTH = 8;
	private final static int MAX_ELEMENT_HEIGHT = 180;
	
	private int panelWidth;
	private final static int PADDING = 25;
	private final static int PANEL_HEIGHT = MAX_ELEMENT_HEIGHT + 2 * PADDING;
	
	
	private List<Integer> model;
	
	public SortingAnimationPanel(List<Integer> model, String sortName) {
		super();
		setBorder(BorderFactory.createTitledBorder(sortName));
		this.sortName = sortName;
		this.model = model;
		this.max = findMax(model).intValue();
//		System.out.println("The list: " + model.toString());
//		System.out.println("Max number in the list is: " + max);
		this.panelWidth = ELEMENT_WIDTH * model.size() + 2 * PADDING;
		setPreferredSize(new Dimension(panelWidth, PANEL_HEIGHT));
	}
	
	private static Integer findMax(List<Integer> list) {
		if(list != null && list.size() > 0) {
			Integer max = list.get(0);
			for(int i = 1; i < list.size(); i++) {
				if(list.get(i).compareTo(max) > 0)
					max = list.get(i);
			}
			return max;
		}
		else {
			return null;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		for(int i = 0; i < model.size(); i++) {
			Integer element = model.get(i);
			int elementHeight = (int)(element.intValue() * ((double)MAX_ELEMENT_HEIGHT / max));
			g.drawRect(PADDING + ELEMENT_WIDTH * i, PADDING + MAX_ELEMENT_HEIGHT - elementHeight, ELEMENT_WIDTH, elementHeight);
		}
	}
}
