package lab3.main;
/**
 * Creates a heap queue
 * 
 * @author Sofia Ågren
 * @version 2020-12-10
 *
 * @param <T>
 */

public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {

	private static final int DEFAULT_SIZE = 30;
	private int maxIndex;
	private T[] heap;

	@SuppressWarnings("unchecked")
	public HeapPriorityQueue() {
		this.maxIndex = 0;
		this.heap = (T[]) (new Comparable[DEFAULT_SIZE]);
	}

	/**
	 * Removes all element in queue.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		heap = null;
		heap = (T[]) (new Comparable[DEFAULT_SIZE]);
		maxIndex = 0;
	}
	/**
	 *@return true if queue is empty, false otherwise. 
	 */
	@Override
	public boolean isEmpty() {
		if (maxIndex == 0) {
			return true;
		}
		return false;
	}
	/**
	 * @return true if queue is full, false otherwise.
	 */
	@Override
	public boolean isFull() {
		if (maxIndex == DEFAULT_SIZE) {
			return true;
		}
		return false;
	}

	/**
	 * @throws QueueEmptyException if empty queue.
	 * @return size of heap queue.
	 */
	@Override
	public int size() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		return maxIndex;
	}

	/**
	 * Adds an element in heap.
	 */
	@Override
	public void enqueue(T element) {

		heap[maxIndex] = element;
		reHeapUp(maxIndex);
		maxIndex++;

	}

	/**
	 * Bubble up element to its right place.
	 * 
	 * @param index
	 */
	private void reHeapUp(int index) {

		int child = index;
		int parent = (child - 1) / 2;

		if (index < 1) {
			return;
		}
		if (heap[child].compareTo(heap[parent]) > 0) {
			T t1 = heap[child];
			T t2 = heap[parent];
			heap[child] = t2;
			heap[parent] = t1;

		}
		reHeapUp(index - 1);
	}

	/**
	 * Removes the last element.
	 * @return new last element.
	 * @throws QueueEmptyException if empty queue.
	 */
	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		T index = heap[0];
		T lastIndex = heap[maxIndex - 1];
		heap[0] = lastIndex;
		heap[maxIndex - 1] = null;
		maxIndex--;
		reHeapDown(0);
		return index;
	}

	/**
	 * Bubble down an element to its right place.
	 * @param index
	 */
	private void reHeapDown(int index) {
		int parent = index;
		int leftChild = (index * 2) + 1;
		int rightChild = (index * 2) + 2;

		if (rightChild > maxIndex) {
			return;
		}

		if (heap[rightChild] == null && heap[leftChild] == null || heap[rightChild] == null) {
			return;
		}
		if (heap[parent].compareTo(heap[rightChild]) < 0) {
			T t1 = heap[parent];
			T t2 = heap[rightChild];
			heap[parent] = t2;
			heap[rightChild] = t1;
		}
		if (heap[parent].compareTo(heap[leftChild]) < 0) {
			T t1 = heap[parent];
			T t2 = heap[leftChild];
			heap[parent] = t2;
			heap[leftChild] = t1;
		}
		reHeapDown(index + 1);
	}

	/**
	 * @throws QueueEmptyException if empty queue.
	 * @return root/biggest element without removing it.
	 */
	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		return heap[0];
	}

	/**
	 * Prints the heap queue.
	 */
	public void print() {
		for (int i = 0; i <= heap.length / 2; i++) {
			for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) <= heap.length; j++) {
				System.out.print(heap[j + (int) Math.pow(2, i) - 1]+ " " );
				
			}
			System.out.println();
			//System.out.println("/" + "\\ ");
		}
	}

}