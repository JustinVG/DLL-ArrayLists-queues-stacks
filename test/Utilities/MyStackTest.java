package Utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utility.ListADT;
import Utility.MyStackImplemented;

public class MyStackTest {
	MyStackImplemented<String> list1;
	MyStackImplemented<String> list2;
	MyStackImplemented<String> list3;
	@Before
	public void setUp() throws Exception {
		list1 = new MyStackImplemented<>();
		list2 = new MyStackImplemented<>();
		list3 = new MyStackImplemented<>();
	}

	@After
	public void tearDown() throws Exception {
		list1 = null;
		list2 = null;
		list3 = null;
	}
	@Test
	public void testMyStack() {
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	@Test
	public void testSizeEmpty() {
		assertEquals(0, list1.size());
	}
	@Test
	public void testSizeNotEmpty() {
		list1.push("A");
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
		list1.push("A");
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	@Test
	public void testPushAndPopEmpty() {
		list1.push("A");
		assertEquals(1,list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A", list1.pop());
	}
	@Test
	public void testPopNotEmpty() {
		list1.push("A");
		list1.push("B");
		list1.push("C");
		assertEquals(3,list1.size());
		assertTrue(list1.contains("C"));
		assertEquals("C", list1.pop());
		assertEquals("B", list1.peek());
	}
	@Test
	public void testPeek() {
		list1.push("A");
		assertEquals(1,list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A", list1.peek());
	}
	@Test
	public void testSearch() {
		list1.push("A");
		list1.push("B");
		list1.push("C");
		assertEquals(1,list1.search("B"));
		assertEquals(0,list1.search("A"));
		assertEquals(2,list1.search("C"));
		
	}
	@Test
	public void testIsEmpty() {
		assertTrue(list1.isEmpty());
	}
	


	@Test
	public void testEqualsStack() {
		list1.push("A");
		list1.push("B");
		list1.push("C");
		list3.push("A");
		list3.push("B");
		list3.push("C");
		assertTrue(list1.equals(list3));
	}
	@Test
	public void testNotEqualsStack() {
		list1.push("A");
		list1.push("B");
		list1.push("C");
		list3.push("A");
		list3.push("B");
		list3.push("C");
		list3.push("D");
		assertFalse(list1.equals(list3));
	}
	@Test
	public void testToArray() {
		list1.push("A");
		list1.push("B");
		list1.push("C");
		list1.push("D");
		list1.toArray();
		assertEquals("D", list1.pop());
		assertEquals("C", list1.pop());
		assertEquals("B", list1.pop());
		assertEquals("A", list1.pop());
	}
	@Test
	public void testToArrayEArray() {
		list1.push("A");
		list1.push("B");
		list1.push("C");
		list1.push("D");
		String[] arr = new String[3];
		arr = (String[]) list1.toArray(arr);
		assertEquals("A", arr[0]);
		assertEquals("B", arr[1]);
		assertEquals("C", arr[2]);
		assertEquals("D", arr[3]);
	}

}
