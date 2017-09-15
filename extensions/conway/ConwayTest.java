package conway;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class ConwayTest {


	Random rand = new Random();

	@Test
	public void getRowsAndColumnsTest(){
		for (int i = 0; i < 100; i++){
			int x = rand.nextInt(100);
			int y = rand.nextInt(100);
			Conway conway = new Conway(x, y);
			assertEquals("You did not return the correct number of rows", x, conway.getRows());
			assertEquals("You did not return the correct number of columns", y, conway.getColumns());
		}
	}

	@Test
	public void clearTest(){

		Conway it = new Conway(rand.nextInt(10), rand.nextInt(10));
		for (int r = 0; r < it.getRows(); r++){
			for (int c = 0; c < it.getColumns(); c++){
				it.setLiveness(rand.nextBoolean(), r, c);
			}
		}
		it.clear();
		for (int r = 0; r < it.getRows(); r++){
			for (int c = 0; c < it.getColumns(); c++){
				assertEquals("You are not setting each value of the array to false", false, it.isAlive(r,c));
			}
		}
	}

	@Test
	public void setLivenessTest(){
		Conway it = new Conway(1, 1);
		it.setLiveness(true, 0, 0);
		assertEquals("Your code didnt set the given coordinate to true", true, it.isAlive(0, 0));
		it.setLiveness(false, 0, 0);
		assertEquals("Your code didnt set the given coordinate to false", false, it.isAlive(0, 0));
	}

	@Test
	public void isAliveTest(){
		Conway it = new Conway(10, 10);
		boolean y;
		for (int i = 0; i < 100; i++){
			for (int r = 0; r < 10; r++){
				for (int c = 0; c < 10; c++){
					y = rand.nextBoolean();
					it.setLiveness(y, r, c);
					assertEquals("Your code did not return the correct value for the cell that we asked for", y, it.isAlive(r, c));
				}
			}		

		}
		
		assertEquals("When the we asked for a cell that was out of bounds of the array, you did not return false"
				, false, it.isAlive(-1, 0));
		assertEquals("When the we asked for a cell that was out of bounds of the array, you did not return false"
				, false, it.isAlive(0, 15));
		assertEquals("When the we asked for a cell that was out of bounds of the array, you did not return false"
				, false, it.isAlive(0, -3));
		assertEquals("When the we asked for a cell that was out of bounds of the array, you did not return false"
				, false, it.isAlive(10, 0));
		assertEquals("When the we asked for a cell that was out of bounds of the array, you did not return false"
				, false, it.isAlive(13, 0));

	}

	@Test
	public void countLivingNeighborsTest(){
		Conway it = new Conway(3, 3);
		it.blinker();
		assertEquals("You did not return the correct number", 2, it.countLivingNeighbors(0, 0));
		assertEquals("You did not return the correct number", 1, it.countLivingNeighbors(1, 0));
		assertEquals("You did not return the correct number", 3, it.countLivingNeighbors(0, 1));
	}

	@Test
	public void stepTest(){
		Conway it = new Conway(3, 3);

		it.blinker();
		it.step();

		assertEquals("This dead cell had three neighbors, but it did not become a live cell :(", true, it.isAlive(0, 1));
		assertEquals("This live cell had two neighbors, but it died :(", true, it.isAlive( 1, 1));
		assertEquals("This live cell had one neighbor, but it continued to live :(", false, it.isAlive(1,0));
		assertEquals("This dead cell had two neighbors, but it came back to life :(", false, it.isAlive(0,0));

	}

}



