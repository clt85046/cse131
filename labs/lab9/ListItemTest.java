package lab9;

import static lab9.ListItem.evenElements;
import junit.framework.TestCase;

import org.junit.Test;

public class ListItemTest extends TestCase {
	
	private ListItem l2 = 
		new ListItem(3, 
				new ListItem(5,
						new ListItem(9,
								new ListItem(3,
										new ListItem(2,
												new ListItem(4,null)
										)
								)
						)
				)
		);
	
	private ListItem l3 =
		new ListItem(6,
				new ListItem(7,
						new ListItem(6,
								new ListItem(9, null)
						)
				)
		);
	
	private ListItem l6 =
		new ListItem(3,
				new ListItem(2,
						new ListItem(6,
								new ListItem(9, null)
						)
				)
		);
	
	private ListItem allOdd =
		new ListItem(1,
				new ListItem(3,
						new ListItem(7,
								new ListItem(5, null)
						)
				)
		);
	
	@Test
	public void testDuplicate() {
		ListItem l2dup = l2.duplicate();
		//
		// Make sure the list returned by duplicate() is indeed a copy
		//   and not the original, throughout
		//
		ListItem l2at    = l2;
		ListItem l2dupat = l2dup;
		while (l2at != null && l2dupat != null) {
			assertFalse("you must copy the list", l2at == l2dupat);
			l2at    = l2at.next;
			l2dupat = l2dupat.next;
		}
		//
		// But they should look the same
		//
		assertEquals(l2.toString(), l2dup.toString());
	}
	
	@Test
	public void testLength() {
		assertEquals(6, l2.length());
		assertEquals(4, l3.length());
		assertEquals(6, l2.duplicate().length());
		assertEquals(4, l3.duplicate().length());
	}
	
	@Test
 	public void testStretch() {
		//
		// Example from web page
		//
		assertEquals("6 6 7 7 6 6 9 9", l3.stretch(2).toString());
		//
		// Stretch a lot of times and make sure each resulting length is right
		//
		for (int i=1; i < 100; ++i) {
			assertEquals(l3.length()*i, l3.stretch(i).length());
		}
		//
		// Stretch of 1 should return same string
		//
		assertEquals(l3.toString(), l3.stretch(1).toString());
	}
	
	@Test
	public void testFind() {
		assertEquals("6 7 6 9", l3.find(6).toString());
		assertEquals("7 6 9", l3.find(7).toString());
		assertEquals(null, l3.find(131));
	}
	
	@Test
	public void testMax() {
		assertEquals(9, l2.max());
		assertEquals(-44, new ListItem(-44, null).max());
	}
		
	@Test
	public void testEvenElements() {
		assertEquals("2 6", evenElements(l6).toString());
		assertEquals(null, evenElements(allOdd));
		assertEquals(null, evenElements(null));
	}
//	@Test
//	public void testReverse() {
//		System.out.println(new ListItem(1, new ListItem(2, new ListItem(3, null))).toString());
//		assertEquals("3 2 1", new ListItem(1, new ListItem(2, new ListItem(3, null))).reverseRecurse().toString());
//	}
}
