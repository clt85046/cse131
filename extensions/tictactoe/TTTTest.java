package tictactoe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TTTTest {

	private static String[][] genBoard() {
		return TicTacToe.genBoard();
	}

	@Test
	public void testInitialBoard() {
		String[][] board = genBoard();
		assertEquals(genErr(board, "Wrong number of rows"), 3, board.length);
		for (int r=0; r < 3; ++r) {
			assertEquals(genErr(board, "Wrong number of columns"), 3, board[r].length);
		}
		for (int r=0; r < 3; ++r) {
			for (int c=0; c < 3; ++c) {
				assertEquals(genErr(board, "Each entry must initially be a single blank"), " ", board[r][c]);
			}
		}
	}

	@Test
	public void verifyValidIndexes() {
		try {
			for (int i=0; i < 3; ++i) {
				TicTacToe.verifyValidCol(i);
			}
		} catch(IllegalArgumentException e) {
			fail("Column index 0 through 2 are valid, but you threw an exception");
		}
		try {
			for (int i=0; i < 3; ++i) {
				TicTacToe.verifyValidRow(i);
			}
		} catch(IllegalArgumentException e) {
			fail("Row index 0 through 2 are valid, but you threw an exception");
		}
	}
	
	private void verifyInvalidRow(int i) {
		try {
			TicTacToe.verifyValidRow(i);
			fail("Row " + i + " is invalid but you did not throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// good!
		} catch (Throwable t) {
			fail("Your code threw the wrong exception:  must be IllegalArgumentException");
		}
	}
	
	private void verifyInvalidCol(int i) {
		try {
			TicTacToe.verifyValidCol(i);
			fail("Col " + i + " is invalid but you did not throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// good!
		} catch (Throwable t) {
			fail("Your code threw the wrong exception:  must be IllegalArgumentException");
		}

	}
	
	@Test
	public void verifyInvalidIndexes() {
		for (int i=-100; i < 100; ++i) {
			if (i < 0 || i > 2) {
				verifyInvalidRow(i);
				verifyInvalidCol(i);
			}
		}
	}
	@Test
	public void testWinForX() {
		testWinFor("x");
	}

	@Test
	public void testWinForO() {
		testWinFor("o");
	}

	private static String genErr(String[][] board, String message) {
		String ans = "";
		ans += "Board state:\n";
		ans += TicTacToe.prettyString(board);
		ans += "Error: " + message;
		return ans;
	}

	private void testWinFor(String player) {
		for (int r=0; r < 3; ++r) {
			String[][] board = genBoard();
			assertFalse(genErr(board,"Board is empty, x should not win"), TicTacToe.winFor(player, board));
			for (int c=0; c < 2; ++c) {
				board[r][c] = player;
				assertFalse(genErr(board,"not yet 3 in a row"), TicTacToe.winFor(player, board));
			}
			board[r][2] = player;
			assertTrue(genErr(board,player + " wins on row " + r), TicTacToe.winFor(player, board));
		}

	}

	private List<int[]> genLocs() {
		List<int[]> ans = new ArrayList<int[]>(9);
		for (int r=0; r < 3; ++r) {
			for (int c=0; c < 3; ++c) {
				ans.add(new int[] { r, c });
			}
		}
		return ans;
	}

	@Test
	public void testMoveX() {
		String[][] board = genBoard();
		List<int[]> locs = genLocs();
		Collections.shuffle(locs);
		System.out.println("Filling with x");
		for (int[] loc : locs) {
			int row = loc[0];
			int col = loc[1];
			boolean move = TicTacToe.makeMove("x", board, row, col);
			assertTrue(genErr(board,"Move at row " + row + " and col " + col + " should work"),move);
			move = TicTacToe.makeMove("x", board, row, col);
			System.out.println("After one move by x");
			System.out.println(TicTacToe.prettyString(board));
			assertFalse(genErr(board,"Move at row " + row + " and col " + col + " should fail"),move);
			move = TicTacToe.makeMove("o", board, row, col);
			assertFalse(genErr(board,"Move at row " + row + " and col " + col + " should fail"),move);
		}
		assertTrue(genErr(board,"Board should be full"), TicTacToe.boardFull(board));
	}
	@Test
	public void testMoveAndBoardFull() {
		String[][] board = genBoard();
		List<int[]> locs = genLocs();
		Collections.shuffle(locs);
		int num=0;
		for (int[] loc : locs) {
			++num;
			String player = Math.random() < 0.5 ? "x" : "o";
			int row = loc[0];
			int col = loc[1];
			assertFalse(genErr(board,"Board should not yet be full"), TicTacToe.boardFull(board));
			boolean move = TicTacToe.makeMove(player, board, row, col);
			assertTrue(genErr(board,"Move at row " + row + " and col " + col + " should work"),move);
			move = TicTacToe.makeMove(player, board, row, col);
			assertFalse(genErr(board,"Move at row " + row + " and col " + col + " should fail"),move);
			String other = player.equals("x") ? "o" : "x";
			move = TicTacToe.makeMove(other, board, row, col);
			assertFalse(genErr(board,"Move at row " + row + " and col " + col + " should fail"),move);
			if (num == 9) {
				assertTrue(genErr(board,"Board should be full"), TicTacToe.boardFull(board));
			}
			else {
				assertFalse(genErr(board,"Board should not yet be full"), TicTacToe.boardFull(board));
			}
			System.out.println("After random move");
			System.out.println(TicTacToe.prettyString(board));
		}
	}

}
