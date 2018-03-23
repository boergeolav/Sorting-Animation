package sortingAlgorithms;

import java.util.List;

import gui.SortingAnimationPanel;

public abstract class SortingAlgorithm {
	
	protected final static long delayBetweenSwaps = 10;
	
	protected List<Integer> list;
	protected SortingAnimationPanel saPanel;
	
	protected SortingAlgorithm(List<Integer> list, SortingAnimationPanel saPanel) {
		super();
		this.list = list;
		this.saPanel = saPanel;
	}
	
	public abstract void sort() throws InterruptedException;

}
