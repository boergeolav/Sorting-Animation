package sortingAlgorithms;

import java.util.List;

import gui.SortingAnimationPanel;

public class SelectionSort extends SortingAlgorithm {

	public SelectionSort(List<Integer> list, SortingAnimationPanel saPanel) {
		super(list, saPanel);
	}

	@Override
	public void sort() throws InterruptedException {
		for(int i = 0; i < list.size() - 1; i++) {
			Integer min = list.get(i);
			int indexOfMin = i;
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(j) < min) {
					min = list.get(j);
					indexOfMin = j;
				}
			}
			if(i != indexOfMin) {
				Integer temp = list.get(i);
				list.set(i, min);
				list.set(indexOfMin, temp);
				Thread.sleep(delayBetweenSwaps);
				saPanel.removeAll();
				saPanel.getParent().repaint();
//				saPanel.repaint();
//				System.out.println("The list after a selection sort swap:" + list.toString());
			}
		}

	}

}
