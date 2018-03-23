package sortingAlgorithms;

import java.util.List;
import gui.SortingAnimationPanel;

public class BubbleSort extends SortingAlgorithm {

	public BubbleSort(List<Integer> list, SortingAnimationPanel saPanel) {
		super(list, saPanel);
	}

	@Override
	public void sort() throws InterruptedException {
		for(int i = 1; i < list.size() - 1; i++) {
			for(int j = 0; j < list.size() - i; j++) {
				if(list.get(j) > list.get(j + 1)) {
					Integer temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
					Thread.sleep(delayBetweenSwaps);
					saPanel.removeAll();
					saPanel.getParent().repaint();
//					saPanel.repaint();
//					System.out.println("The list after a bubble sort swap:" + list.toString());
				}
			}
		}

	}

}
