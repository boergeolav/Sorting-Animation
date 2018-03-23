package sortingAlgorithms;

import java.util.List;

import gui.SortingAnimationPanel;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort(List<Integer> list, SortingAnimationPanel saPanel) {
		super(list, saPanel);
	}

	@Override
	public void sort() throws InterruptedException {
		for(int j = 1; j < list.size(); j++) {
			Integer key = list.get(j);
			int i = j - 1;
			while(i >= 0 && list.get(i) > key) {
				list.set(i + 1, list.get(i--));
			}
			list.set(i + 1, key);
			Thread.sleep(delayBetweenSwaps);
			saPanel.removeAll();
			saPanel.getParent().repaint();
//			saPanel.repaint();
//			System.out.println("The list after an insertion sort swap:" + list.toString());
		}
	}

}
