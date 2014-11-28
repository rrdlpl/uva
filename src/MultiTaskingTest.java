import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class MultiTaskingTest {

	@Test
	public void canFill() {
		int [] freePlaces = new int[31250];
		int start = 10;
		int end = 20;
		assertTrue(Multitasking.canFill(freePlaces, 0, start, end));
		
	}
	
	@Test
	public void cantFillTaskAt11(){
		int [] freePlaces = new int[31250];		
		int start = 10;
		int end = 20;
		freePlaces[0] |= 1 << 11;
		assertFalse(Multitasking.canFill(freePlaces, 0, start, end));
	}
	@Test
	public void canFillTouchingBegin(){
		int [] freePlaces = new int[31250];		
		int start = 10;
		int end = 20;
		freePlaces[0] |= 1 << 10;
		assertTrue(Multitasking.isTouching(freePlaces, start, end));//(freePlaces, 0, start, end));
	}
	
	@Test
	public void canFillTouchingEnd(){
		int [] freePlaces = new int[31250];		
		int start = 10;
		int end = 19;
		freePlaces[0] |= 1 << 19;
		assertTrue(Multitasking.canFill(freePlaces, 0, start, end));
	}
	
	@Test
	public void canFillTouchingLimits(){
		int [] freePlaces = new int[31250];		
		int start = 31;
		int end = 32;
		freePlaces[0] |= 1 << 31;
		assertTrue(Multitasking.canFill(freePlaces, 0, 1, 10));
	}
	
	@Test
	public void canDoOneTimeTasks(){
		int [] freePlaces = new int[31250];		
		int start = 30;
		int end = 32;
		freePlaces[31] |= 1 << 7;
		int size = (2000-1000)/31;
		assertTrue(Multitasking.canFill(freePlaces, 31, 1000, 2000, size));
	}

}
