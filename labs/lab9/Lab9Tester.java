package lab9;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;

public class Lab9Tester {

	private Random random = new Random(0);
	
	/**
	 * Generates a linked list with random values of length l for testing purposes
	 * @param l desired length of list
	 * @return linked list of length l
	 */
	private ListItem generateList(int l) {
		
		if (l == 0)
			return null;
		
		ListItem nextItem = new ListItem(random.nextInt(101), null);//tail of the list
		ListItem currentItem = nextItem;
		
		//make the rest of it
		for(int i = l - 1; i > 0; i--) {
			currentItem = new ListItem(random.nextInt(101), nextItem);
			nextItem = currentItem;
		}
		
		//return head of list
		return currentItem;
	}
	
	@Test
	public void testDuplicate() {
		ListItem original, duplicate, originalCurr, duplicateCurr;
		for(int i = 0; i < 100; i ++)
		{
			int length = random.nextInt(100) + 1;
			original = generateList(length);
			duplicate = original.duplicate();//make a duplicate
			originalCurr = original;
			duplicateCurr = duplicate;
			
			//check to make sure its actually copying the list
			while (originalCurr != null && duplicateCurr!= null) {
				assertFalse("you must copy the list", originalCurr == duplicateCurr);
				originalCurr = originalCurr.next;
				duplicateCurr = duplicateCurr.next;
			}
			
			assertEquals(original.toString(), duplicate.toString());//make sure list values are equal
		}
	}
	
	@Test
	public void testLength() {
		for(int i = 0; i < 100; i++) {
			int length = random.nextInt(100) + 1;
			ListItem list = generateList(length);//make a list of random length
			
			assertEquals(length, list.length());//make sure the lengths match
		}
	}
	
	@Test
	public void testStretch() {
		ListItem original, stretch, originalCurr, stretchCurr;
		for(int i = 0; i < 100; i ++)
		{
			int length = random.nextInt(100) + 1;
			int stretchAmt = random.nextInt(10) + 1; //set stretch factor between 1 and 10
			original = generateList(length);
			stretch = original.stretch(stretchAmt); //stretch it
			originalCurr = original;
			stretchCurr = stretch;
			
			for(int j = 0; j < length; j++)
			{
				for(int k = 0; k < stretchAmt; k++) //check that each value has been stretched
				{
					assertEquals(originalCurr.number, stretchCurr.number);
					stretchCurr = stretchCurr.next;
				}
				originalCurr = originalCurr.next;
			}
			
			//check to see if we've hit the end of the lists
			assertEquals(stretchCurr, null);
			assertEquals(originalCurr, null);
		}
	}
	
	@Test
	public void testFind() {
		ListItem original, find, originalCurr, findCurr;
		for(int i = 0; i < 100; i++)
		{
			int length = random.nextInt(100) + 1;
			int findVal = random.nextInt(101); //the value we're trying to find
			original = generateList(length);
			find = original.find(findVal);
			originalCurr = original;
			findCurr = find;
			
			while(originalCurr != null)
			{
				if(originalCurr.number == findVal)
					break;
				originalCurr = originalCurr.next;
			}
			
			if(originalCurr == null) //value not found
			{
				assertEquals(find, null);
			}
			else //value found, make sure lists are the same
			{
				assertEquals(originalCurr.toString(), findCurr.toString());
			}
		}
	}
	
	@Test
	public void testMax()
	{
		ListItem original, originalPtr;
		for(int i = 0; i < 10; i++)
		{
			int length = random.nextInt(10) + 1;
			original = generateList(length);
			originalPtr = original;
			
			int max = 0;
			
			//find the max
			while(originalPtr != null)
			{
				if(originalPtr.number > max)
					max = originalPtr.number;
				originalPtr = originalPtr.next;
			}
			
			//make sure the function returns the same value we found
			assertEquals(max, original.max());
		}
	}
	
	@Test
	public void testEvens() {
		ListItem original, evens, originalCurr, evensCurr;
		for(int i = 0; i < 100; i++)
		{
			int length = random.nextInt(100) + 1;
			original = generateList(length);
			evens = ListItem.evenElements(original); //find even elements
			originalCurr = original;
			evensCurr = evens;

			int cnt = 0;
			for(int j = 0; j < original.length(); j++)
			{
				//found an even number
				if(originalCurr.number % 2 == 0)
				{
					assertEquals(originalCurr.number, evensCurr.number); //make sure it's in the list
					evensCurr = evensCurr.next;
					cnt++;
				}
				originalCurr = originalCurr.next;
			}
			
			//check to make sure we've reached the end of both lists
			assertEquals(originalCurr, null);
			assertEquals(evensCurr, null);
			
			//no evens in the list
			if(cnt == 0)
				assertEquals(null, evens);
			
		}
	}
}
