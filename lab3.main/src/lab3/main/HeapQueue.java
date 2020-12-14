package lab3.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.hig.aod.lab3.DuplicateItemException;
import se.hig.aod.lab3.EmptyQueueException;
import se.hig.aod.lab3.HeapPriorityQueue;

/**
 * A Heap Priority Queue that counts milli seconds to enqueue and dequeue.
 * 
 * @author Sofia Ågren
 * @version 2020-12-10
 */
public class HeapQueue {

	private static HeapPriorityQueue<Integer> heap = new HeapPriorityQueue<>();
	private static final String DATA_6400 = "data/data_6400.txt";
	private static final String DATA_64000 = "data/data_640000.txt";
	private static int IN_ELEMENTS_FIRST = 10000;
	private static int ELEMENT_TO_ADD = 1000;

	public static void main(String[] args) {

		List<Integer> inData = new ArrayList<Integer>();
		List<Integer> testData = new ArrayList<Integer>();
		long t0;
		long exeTime;

		for (String arg : args) {
			switch (arg) {
			case "--sorted":
				Collections.sort(inData);
				break;
			case "--unsorted":
				break;
			case "--reversed_sorted":
				Collections.sort(inData, Collections.reverseOrder());
			default:
				throw new IllegalArgumentException();

			}
		}

		try {
			inData = loadListFromFile(DATA_64000, IN_ELEMENTS_FIRST);
			testData = loadListFromFile(DATA_6400, ELEMENT_TO_ADD);

			for (int i = 0; i < IN_ELEMENTS_FIRST; i++) {
				heap.enqueue(inData.get(i));
			}

			t0 = System.currentTimeMillis();// exekvera det som skall matas tid på - enqueue resp. dequeue
			for (int i = 0; i < ELEMENT_TO_ADD; i++) {
				heap.enqueue(testData.get(i));
			}
			exeTime = System.currentTimeMillis() - t0;
			System.out.println("Time for enqueue: " + exeTime + " ms");

			t0 = 0;
			exeTime = 0;

			t0 = System.currentTimeMillis();
			for (int i = 0; i < ELEMENT_TO_ADD; i++) {
				heap.dequeue();
			}
			exeTime = System.currentTimeMillis() - t0;
			System.out.println("Time for dequeue: " + exeTime + " ms");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(inData.size());
	}

	/**
	 * 
	 * @param path
	 * @param size
	 * @return list
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static List<Integer> loadListFromFile(String path, int size) throws FileNotFoundException, IOException {
		List<Integer> list = new ArrayList<Integer>();
		int cnt = 0;
		String l;
		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			while ((l = in.readLine()) != null && cnt < size) {
				list.add(Integer.parseInt(l));
				cnt++;
			}
		} // här har in.close() garanterat anropats
		return list;
	}
}
