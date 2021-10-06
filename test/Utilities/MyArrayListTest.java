/**
 * 
 */
package Utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utility.Iterator;
import Utility.ListADT;
import Utility.MyArrayList;

/**
 * @author 709488
 *
 */
public class MyArrayListTest {
	ListADT<String> list1;
	ListADT<String> list2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list1 = new MyArrayList<>();
		list2 = new MyArrayList<>(11);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		list1 = null;
		list2 = null;
	}

	/**
	 * Test method for {@link Utility.MyArrayList#MyArrayList()}.
	 */
	@Test
	public void testMyArrayList() {
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}

	/**
	 * Test method for {@link Utility.MyArrayList#MyArrayList(int)}.
	 */
	@Test
	public void testMyArrayListInt() {
		assertEquals(0, list2.size());
		assertTrue(list2.isEmpty());
	}

	/**
	 * Test method for {@link Utility.MyArrayList#size()}.
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(0, list1.size());
	}
	@Test
	public void testSizeNotEmpty() {
		list1.add("A");
		assertEquals(1, list1.size());
	}

	/**
	 * Test method for {@link Utility.MyArrayList#clear()}.
	 */
	@Test
	public void testClearEmpty() {
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	
	@Test
	public void testClearNotEmpty() {
		list1.add("A");
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}

	/**
	 * Test method for {@link Utility.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEEmpty() {
		list1.add(0, "A");
		assertEquals(1,list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A", list1.get(0));
	}
	@Test
	public void testAddIntENotEmpty() {
		list1.add("B");
		list1.add("C");
		list1.add(1, "A");
		assertEquals(3,list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A", list1.get(1));
	}
	
	@Test
	public void testAddIntELowerBound() {
		
		try {
		list1.add(-1, "A");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
		
		
	}
	@Test
	public void testAddIntEUpperBound() {
		
		try {
		list1.add(1, "A");
		fail("IndexOutOfBoundsException wasn't thrown for index of 1");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
		
		
	}
	@Test
	public void testAddIntENull() {
		
		try {
		list1.add(0, null);
		fail("NullPointerException wasn't thrown");
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
		
		
	}

	/**
	 * Test method for {@link Utility.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddEEmpty() {
		list1.add("A");
		assertEquals(1,list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A", list1.get(0));
		
	}

	/**
	 * Test method for {@link Utility.MyArrayList#addAll(Utility.ListADT)}.
	 */
	@Test
	public void testAddAll() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list2.add("E");
		list2.add("T");
		list2.add("R");
		list1.addAll(list2);
		assertEquals(7,list1.size());
		assertEquals("E", list1.get(4));
		assertEquals("T", list1.get(5));
		assertEquals("R", list1.get(6));
	}

	/**
	 * Test method for {@link Utility.MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		list1.add("A");
		assertEquals("A", list1.get(0));
	}

	/**
	 * Test method for {@link Utility.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		list1.add("A");
		list1.add("B");
		list1.remove("B");
		assertEquals(1,list1.size());
		assertTrue(list1.contains("A"));
		assertFalse(list1.contains("B"));
	}

	/**
	 * Test method for {@link Utility.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveE() {
		list1.add("A");
		list1.add("B");
		list1.remove(1);
		assertEquals(1,list1.size());
		assertTrue(list1.contains("A"));
		assertFalse(list1.contains("B"));
	}

	/**
	 * Test method for {@link Utility.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.set(1, "J");
		assertEquals("J", list1.get(1));
	}

	/**
	 * Test method for {@link Utility.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertEquals(0, list1.size());
	}

	/**
	 * Test method for {@link Utility.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		list1.add("A");
		list1.add("B");
		assertTrue(list1.contains("A"));
	}

	/**
	 * Test method for {@link Utility.MyArrayList#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArray() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		String[] arr = new String[3];
		arr = list1.toArray(arr);
		assertEquals("A", arr[0]);
		assertEquals("B", arr[1]);
		assertEquals("C", arr[2]);
		assertEquals("D", arr[3]);
	}

	/**
	 * Test method for {@link Utility.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list1.toArray();
		assertEquals("A", list1.get(0));
		assertEquals("B", list1.get(1));
		assertEquals("C", list1.get(2));
		assertEquals("D", list1.get(3));
	}

	/**
	 * Test method for {@link Utility.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list1.add("E");
		Iterator iterator = list1.iterator();
		assertEquals(iterator.next(), "A");
		assertEquals(iterator.next(), "B");
		assertEquals(iterator.next(), "C");
		assertEquals(iterator.next(), "D");
		assertEquals(iterator.next(), "E");
		
	}

}
