package Utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utility.ListADT;
import Utility.MyStackImplemented;

public class MyQueueTests {
	MyQueueImplemented<String> list1;
	MyQueueImplemented<String> list2;
	MyQueueImplemented<String> list3;
	@Before
	public void setUp() throws Exception {
		list1 = new MyQueueImplemented<>();
		list2 = new MyQueueImplemented<>();
		list3 = new MyQueueImplemented<>();
	}

	@After
	public void tearDown() throws Exception {
		list1 = null;
		list2 = null;
		list3 = null;
	}
	@Test
	public void testMyQueue() {
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	@Test
	public void testSizeEmpty() {
		assertEquals(0, list1.size());
	}
	@Test
	public void testSizeNotEmpty() {
		list1.enqueue("A");
		assertEquals(1, list1.size());
	}
	@Test
	public void testClearEmpty() {
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	@Test
	public void testClearNotEmpty() {
		list1.enqueue("A");
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	@Test
	public void testQueueAndEnqueueEmpty() {
		list1.enqueue("A");
		assertEquals(1,list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A", list1.dequeue());
	}
	@Test
	public void testPeek() {
		list1.enqueue("A");
		assertEquals(1,list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A", list1.peek());
	}
	@Test
	public void testToArray() {
		list1.enqueue("A");
		list1.enqueue("B");
		list1.enqueue("C");
		list1.enqueue("D");
		list1.toArray();
		assertEquals("A", list1.dequeue());
		assertEquals("B", list1.dequeue());
		assertEquals("C", list1.dequeue());
		assertEquals("D", list1.dequeue());
	}
	@Test
	public void testToArrayEArray() {
		list1.enqueue("A");
		list1.enqueue("B");
		list1.enqueue("C");
		list1.enqueue("D");
		String[] arr = new String[3];
		arr = (String[]) list1.toArray(arr);
		assertEquals("A", arr[3]);
		assertEquals("B", arr[2]);
		assertEquals("C", arr[1]);
		assertEquals("D", arr[0]);
	}
	@Test
	public void testFirst() {
		list1.enqueue("A");
		list1.enqueue("B");
		list1.enqueue("C");
		list1.enqueue("D");
		assertEquals("A", list1.first());
		
	}

}