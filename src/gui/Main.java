package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.InsertionSort;
import sortingAlgorithms.SelectionSort;
import sortingTasks.SortingTask;

public class Main {
	
	public static void main (String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		for(int i = 0; i < 20; i++) {
			Integer e = (int)(Math.random() * 50 + 1);
			list1.add(e);
		}
		List<Integer> list2 = new ArrayList<Integer>(list1);
		List<Integer> list3 = new ArrayList<Integer>(list1);
		SortingAnimationPanel bubbleSortPanel = new SortingAnimationPanel(list1, "Bubble sort");
		SortingAnimationPanel selectionSortPanel = new SortingAnimationPanel(list2, "Selection sort");
		SortingAnimationPanel insertionSortPanel = new SortingAnimationPanel(list3, "Insertion sort");
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel outerPanel = new JPanel();
		outerPanel.add(bubbleSortPanel);
		outerPanel.add(selectionSortPanel);
		outerPanel.add(insertionSortPanel);
		frame.add(outerPanel);
		frame.pack();
		frame.setVisible(true);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new SortingTask(new BubbleSort(list1, bubbleSortPanel)));
		executor.execute(new SortingTask(new SelectionSort(list2, selectionSortPanel)));
		executor.execute(new SortingTask(new InsertionSort(list3, insertionSortPanel)));
		executor.shutdown();
		System.out.println("The list: " + list1.toString());
	}

}
