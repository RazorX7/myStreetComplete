package de.westnordost.streetcomplete.debug;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SampleActivityTest {
	private SampleActivity example;

	@Before
	public  void setUp() throws Exception {
		example = new SampleActivity();
		example.init_to();
	}

	@Test
	public void init_to() throws  Exception{
		List<String> reslist=new LinkedList<>();
		reslist.clear();
		for(int i=0;i<8;i++){
			reslist.add(i+" record_item");
		}
		assertEquals(example.mlist.get(0),reslist.get(0));
	}
	@Test
	public void init_to1() throws  Exception{
		List<String> reslist=new LinkedList<>();
		reslist.clear();
		for(int i=0;i<8;i++){
			reslist.add(i+" record_item");
		}
		assertEquals(example.mlist.get(1),reslist.get(1));
	}
	@Test
	public void init_to2() throws  Exception{
		List<String> reslist=new LinkedList<>();
		reslist.clear();
		for(int i=0;i<8;i++){
			reslist.add(i+" record_item");
		}
		assertEquals(example.mlist.get(6),reslist.get(7));
	}

	@Test
	public void delete()throws Exception{
		List<String> reslist=new LinkedList<>();
		reslist.clear();
		for(int i=0;i<8;i++){
			reslist.add(i+" record_item");
		}
		example.delete(2);
		assertNotEquals(example.mlist.get(2),reslist.get(2));
	}
	@Test
	public void delete1()throws Exception{
		List<String> reslist=new LinkedList<>();
		reslist.clear();
		for(int i=0;i<8;i++){
			reslist.add(i+" record_item");
		}
		example.delete(3);
		assertNotEquals(example.mlist.get(3),reslist.get(3));
	}
	@Test
	public void delete2()throws Exception{
		List<String> reslist=new LinkedList<>();
		reslist.clear();
		for(int i=0;i<8;i++){
			reslist.add(i+" record_item");
		}
		example.delete(1);
		assertNotEquals(example.mlist.get(1),reslist.get(1));
	}
}
