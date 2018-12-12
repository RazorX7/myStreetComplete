package de.westnordost.streetcomplete.debug;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchTest {
	private Search example;

	@Before
	public  void setUp() throws Exception {
		example = new Search();
	}

	@Test
	public void add() throws  Exception{
		assertEquals(6,example.add(2,4));
	}

	@Test
	public void add1() throws Exception{
		assertEquals(6,example.add(2,3));
	}

	@Test
	public void add2() throws Exception{
		assertEquals(7,example.add(4,3));
	}

	@Test
	public void SearchItem1() throws Exception{
		assertEquals("0 record_item",example.SearchItem("re"));
	}
	@Test
	public void SearchItem2() throws Exception{
		assertEquals("1 record_item",example.SearchItem("1"));
	}
	@Test
	public void SearchItem3() throws Exception{
		assertEquals("3 record_item",example.SearchItem("2"));
	}

	@Test
	public void FindItem1() throws Exception{
		assertEquals("0 record_item",example.FindItem(0));
	}
	@Test
	public void FindItem2() throws Exception{
		assertEquals("1 record_item",example.FindItem(1));
	}
	@Test
	public void FindItem3() throws Exception{
		assertEquals("3 record_item",example.FindItem(3));
	}
}
