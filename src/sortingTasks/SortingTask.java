package sortingTasks;

import sortingAlgorithms.SortingAlgorithm;

public class SortingTask implements Runnable {

	private SortingAlgorithm sa;

	public SortingTask(SortingAlgorithm sa) {
		this.sa = sa;
	}

	@Override
	public void run() {
		try {
			sa.sort();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
