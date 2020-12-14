package lab3.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test class for an heap queue
 * @author Sofia Ågren
 * @version 2020-12-14
 *
 */
class PriorityQueueTest {

	static PriorityQueue<Integer> pQueue;
	static PriorityQueue<String> stringPQueue;
	private static final int size = 30;
	private static final String[] ALFABETET = {"a","b","c","d","e","f","g","h","i",
            					"j","k","l","m","n","o","p","q","r","s","t","u","v",
            					"w","x","y","z"};
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		pQueue = null;
		stringPQueue = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		pQueue = new HeapPriorityQueue<Integer>();
		stringPQueue = new HeapPriorityQueue<String>();
		for(int i = 0; i < size; i++) {
			pQueue.enqueue(i);
		}
		for(String a : ALFABETET) {
			stringPQueue.enqueue(a);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		pQueue.clear();
		stringPQueue.clear();
	}

	@Test
	void testPrint() {
		pQueue.print(); 
	}
	@Test
	void testClear() {
		pQueue.clear();
		assertTrue(pQueue.isEmpty());
		stringPQueue.clear();
		assertTrue(stringPQueue.isEmpty());
	}
	@Test
	void testIsFull() {
		assertTrue(pQueue.isFull());
		assertFalse(stringPQueue.isFull());
	}
	@Test
	void testIsEmpty() {
		assertFalse(pQueue.isEmpty());
		assertFalse(stringPQueue.isEmpty());
	}
	@Test
	void testsize() {
		assertEquals(30, pQueue.size());
		assertEquals(26, stringPQueue.size());
	}
	@Test
	void testSizeEmptyQueue() {
		pQueue.clear();
		assertTrue(pQueue.isEmpty());
		assertThrows(QueueEmptyException.class, () -> pQueue.size());
	}
	@Test
	void testEnqueue() {
		pQueue.clear();
		pQueue.enqueue(3);
		pQueue.enqueue(2);
		assertEquals(2, pQueue.size());
		stringPQueue.clear();
		stringPQueue.enqueue("s");
		stringPQueue.enqueue("a");
		assertEquals(2, stringPQueue.size());

	}
	@Test
	void testDequeue() {
		assertEquals(30, pQueue.size());
		pQueue.dequeue();
		assertEquals(29, pQueue.size());
		pQueue.dequeue();
		assertEquals(28, pQueue.size());
		pQueue.dequeue();
		assertEquals(27, pQueue.size());
	}
	@Test
	void testDequeueEmptyQueue() {
		pQueue.clear();
		assertTrue(pQueue.isEmpty());
		assertThrows(QueueEmptyException.class, () -> pQueue.dequeue());
		stringPQueue.clear();
		assertTrue(stringPQueue.isEmpty());
		assertThrows(QueueEmptyException.class, () -> stringPQueue.dequeue());
	}
	@Test
	void testGetFront() {
		assertEquals(29, pQueue.getFront());
		pQueue.dequeue();
		assertEquals(28, pQueue.getFront());
		assertEquals("z", stringPQueue.getFront());
		stringPQueue.dequeue();
		assertEquals("y", stringPQueue.getFront());
	}
	@Test
	void testGetFrontEmptyQueue() {
		pQueue.clear();
		assertTrue(pQueue.isEmpty());
		assertThrows(QueueEmptyException.class, () -> pQueue.getFront());
		stringPQueue.clear();
		assertTrue(stringPQueue.isEmpty());
		assertThrows(QueueEmptyException.class, () -> stringPQueue.getFront());
	}

}
