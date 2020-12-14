package lab3.main;
/**
 * @author Sofia Ågren
 * @version 2020-12-10
 *
 * @param <T>
 */
public interface PriorityQueue<T extends Comparable<? super T>> {
	/**
	 * Removes all element in queue.
	 */
	public void clear();

	/**
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * 
	 * @return true if full, false otherwise.
	 */
	public boolean isFull();

	/**
	 * @throws QueueEmptyException if empty.
	 * @return size of queue.
	 */
	public int size();

	/**
	 * Adds an element in heap.
	 * @param element
	 */
	public void enqueue(T element);

	/**
	 * Removes the last element.
	 * @return new last element.
	 * @throws QueueEmptyException if empty queue.
	 */
	public T dequeue();

	/**
	 * @throws QueueEmptyException if empty.
	 * @return root/biggest element without removing it.
	 */
	public T getFront();
	/**
	 * Prints the heap queue.
	 */
	public void print();
}
