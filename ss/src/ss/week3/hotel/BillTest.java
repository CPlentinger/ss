package ss.week3.hotel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BillTest {
	
	public Bill bill1;
	public Bill bill2;
	public Bill.Item item1;
	public Bill.Item item2;	
	
	@Before
	public void setUp(){
		bill1 = new Bill(System.out);
		bill2 = new Bill(null);
		item1 = new Item("item1", 1);
		item2 = new Item("item2", 2);
		
	}

	@Test
	public void newItemTest() {
		bill1.newItem(item1);
		assertTrue(item1.getAmount() == 1);
		assertTrue(bill1.getSum() == 1);
		bill1.sum = 0;
	}
	
	@Test
	public void getSumTest(){
		bill1.newItem(item1);
		bill1.newItem(item2);
		assertTrue(bill1.getSum() == 3);
	}
	
}
