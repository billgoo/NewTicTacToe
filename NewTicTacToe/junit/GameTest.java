import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameTest {
	Game game = null;
	Result result = null;
	PrintStream console = null;
	ByteArrayOutputStream bytes = null;
	String sep;

	@org.junit.Before
	public void setUp() throws Exception {
		game = new Game();
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
		sep = System.getProperty("line.separator");
	}

	@org.junit.After
	public void tearDown() throws Exception {
		bytes.close();
		System.setOut(console);
	}

	// 1 step, normal 3
	@org.junit.Test
	public void test1() throws Exception {
		result = game.playGame("00", "A1", 3);
		assertEquals(Result.GAMING, result);
		assertEquals(
				  "  A B C" + sep 
				+ "1 X _ _" + sep 
				+ "2 _ _ _" + sep
				+ "3 _ _ _" + sep, bytes.toString());
	}

	// 6 step, abnormal 5
	@org.junit.Test
	public void test2() throws Exception {
		result = game.playGame("01", "D2,C3,C4,D4,D3,B2", 5);
		assertEquals(Result.GAMING, result);
		assertEquals(
				  "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ _ _ X _" + sep
				+ "3 _ _ _ _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ _ _ X _" + sep
				+ "3 _ _ O _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ _ _ X _" + sep
				+ "3 _ _ O _ _" + sep
				+ "4 _ _ X _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ _ _ X _" + sep
				+ "3 _ _ O _ _" + sep
				+ "4 _ _ X O _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ _ _ X _" + sep
				+ "3 _ _ O X _" + sep
				+ "4 _ _ X O _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ O _ X _" + sep
				+ "3 _ _ O X _" + sep
				+ "4 _ _ X O _" + sep
				+ "5 _ _ _ _ _" + sep, bytes.toString());
	}
	
	// 5 step, normal 4
	@org.junit.Test
	public void test3() throws Exception {
		result = game.playGame("00", "C3,D2,B2,D3,D4", 4);
		assertEquals(Result.X_WIN, result);
		assertEquals(
				  "  A B C D" + sep 
				+ "1 _ _ _ _" + sep 
				+ "2 _ _ _ _" + sep
				+ "3 _ _ X _" + sep
				+ "4 _ _ _ _" + sep
				+ "  A B C D" + sep 
				+ "1 _ _ _ _" + sep 
				+ "2 _ _ _ O" + sep
				+ "3 _ _ X _" + sep
				+ "4 _ _ _ _" + sep
				+ "  A B C D" + sep 
				+ "1 _ _ _ _" + sep 
				+ "2 _ X _ O" + sep
				+ "3 _ _ X _" + sep
				+ "4 _ _ _ _" + sep
				+ "  A B C D" + sep 
				+ "1 _ _ _ _" + sep 
				+ "2 _ X _ O" + sep
				+ "3 _ _ X O" + sep
				+ "4 _ _ _ _" + sep
				+ "  A B C D" + sep 
				+ "1 _ _ _ _" + sep 
				+ "2 _ X _ O" + sep
				+ "3 _ _ X O" + sep
				+ "4 _ _ _ X" + sep, bytes.toString());
	}
	
	// 6 step, abnormal 5
	@org.junit.Test
	public void test4() throws Exception {
		result = game.playGame("01", "C3,D2,B2,D3,D4,D1", 5);
		assertEquals(Result.O_WIN, result);
		assertEquals(
				  "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ _ _ _ _" + sep
				+ "3 _ _ X _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ _ _ O _" + sep
				+ "3 _ _ X _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ X _ O _" + sep
				+ "3 _ _ X _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ X _ O _" + sep
				+ "3 _ _ X O _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ X _ O _" + sep
				+ "3 _ _ X O _" + sep
				+ "4 _ _ _ X _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ O _" + sep 
				+ "2 _ X _ O _" + sep
				+ "3 _ _ X O _" + sep
				+ "4 _ _ _ X _" + sep
				+ "5 _ _ _ _ _" + sep, bytes.toString());
	}
	
	// 9 step, abnormal 3
	@org.junit.Test
	public void test5() throws Exception {
		result = game.playGame("01", "A1,B1,B2,A2,A3,B3,C2,C1,C3", 3);
		assertEquals(Result.DRAW, result);
		assertEquals(
				  "  A B C" + sep 
				+ "1 X _ _" + sep 
				+ "2 _ _ _" + sep
				+ "3 _ _ _" + sep
				+ "  A B C" + sep 
				+ "1 X O _" + sep 
				+ "2 _ _ _" + sep
				+ "3 _ _ _" + sep
				+ "  A B C" + sep 
				+ "1 X O _" + sep 
				+ "2 _ X _" + sep
				+ "3 _ _ _" + sep
				+ "  A B C" + sep 
				+ "1 X O _" + sep 
				+ "2 O X _" + sep
				+ "3 _ _ _" + sep
				+ "  A B C" + sep 
				+ "1 X O _" + sep 
				+ "2 O X _" + sep
				+ "3 X _ _" + sep
				+ "  A B C" + sep 
				+ "1 X O _" + sep 
				+ "2 O X _" + sep
				+ "3 X O _" + sep
				+ "  A B C" + sep 
				+ "1 X O _" + sep 
				+ "2 O X X" + sep
				+ "3 X O _" + sep
				+ "  A B C" + sep 
				+ "1 X O O" + sep 
				+ "2 O X X" + sep
				+ "3 X O _" + sep
				+ "  A B C" + sep 
				+ "1 X O O" + sep 
				+ "2 O X X" + sep
				+ "3 X O X" + sep, bytes.toString());
	}
	
	// 8 step, normal 5
	@org.junit.Test
	public void test6() throws Exception {
		result = game.playGame("10", "B2,D1,D2,C2,D4,D3,A5,C3", 5);
		assertEquals(Result.GAMING, result);
		assertEquals(
				  "  A B C D E" + sep 
				+ "1 _ _ _ _ _" + sep 
				+ "2 _ X _ _ _" + sep
				+ "3 _ _ _ _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ O _" + sep 
				+ "2 _ X _ _ _" + sep
				+ "3 _ _ _ _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ O _" + sep 
				+ "2 _ X _ X _" + sep
				+ "3 _ _ _ _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ O _" + sep 
				+ "2 _ X O X _" + sep
				+ "3 _ _ _ _ _" + sep
				+ "4 _ _ _ _ _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ O _" + sep 
				+ "2 _ X O X _" + sep
				+ "3 _ _ _ _ _" + sep
				+ "4 _ _ _ X _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ O _" + sep 
				+ "2 _ X O X _" + sep
				+ "3 _ _ _ O _" + sep
				+ "4 _ _ _ X _" + sep
				+ "5 _ _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ O _" + sep 
				+ "2 _ X O X _" + sep
				+ "3 _ _ _ O _" + sep
				+ "4 _ _ _ X _" + sep
				+ "5 X _ _ _ _" + sep
				+ "  A B C D E" + sep 
				+ "1 _ _ _ O _" + sep 
				+ "2 _ X O X _" + sep
				+ "3 _ _ O O _" + sep
				+ "4 _ _ _ X _" + sep
				+ "5 X _ _ _ _" + sep, bytes.toString());
	}
	
	// 9 step, normal 6
	@org.junit.Test
	public void test7() throws Exception {
		result = game.playGame("10", "A1,C2,B2,D1,C3,D3,D4,A5,E5", 6);
		assertEquals(Result.X_WIN, result);
		assertEquals(
				  "  A B C D E F" + sep 
				+ "1 X _ _ _ _ _" + sep 
				+ "2 _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _" + sep
				+ "  A B C D E F" + sep 
				+ "1 X _ _ _ _ _" + sep 
				+ "2 _ _ O _ _ _" + sep
				+ "3 _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _" + sep
				+ "  A B C D E F" + sep 
				+ "1 X _ _ _ _ _" + sep 
				+ "2 _ X O _ _ _" + sep
				+ "3 _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _" + sep
				+ "  A B C D E F" + sep 
				+ "1 X _ _ O _ _" + sep 
				+ "2 _ X O _ _ _" + sep
				+ "3 _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _" + sep
				+ "  A B C D E F" + sep 
				+ "1 X _ _ O _ _" + sep 
				+ "2 _ X O _ _ _" + sep
				+ "3 _ _ X _ _ _" + sep
				+ "4 _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _" + sep
				+ "  A B C D E F" + sep 
				+ "1 X _ _ O _ _" + sep 
				+ "2 _ X O _ _ _" + sep
				+ "3 _ _ X O _ _" + sep
				+ "4 _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _" + sep
				+ "  A B C D E F" + sep 
				+ "1 X _ _ O _ _" + sep 
				+ "2 _ X O _ _ _" + sep
				+ "3 _ _ X O _ _" + sep
				+ "4 _ _ _ X _ _" + sep
				+ "5 _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _" + sep
				+ "  A B C D E F" + sep 
				+ "1 X _ _ O _ _" + sep 
				+ "2 _ X O _ _ _" + sep
				+ "3 _ _ X O _ _" + sep
				+ "4 _ _ _ X _ _" + sep
				+ "5 O _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _" + sep
				+ "  A B C D E F" + sep 
				+ "1 X _ _ O _ _" + sep 
				+ "2 _ X O _ _ _" + sep
				+ "3 _ _ X O _ _" + sep
				+ "4 _ _ _ X _ _" + sep
				+ "5 O _ _ _ X _" + sep
				+ "6 _ _ _ _ _ _" + sep, bytes.toString());
	}
	
	// 10 step, abnormal 7
	@org.junit.Test
	public void test8() throws Exception {
		result = game.playGame("11", "A1,F1,B2,F2,C3,F3,D4,F4,E5,F5", 7);
		assertEquals(Result.O_WIN, result);
		assertEquals(
				  "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ _ _" + sep 
				+ "2 _ _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ X _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ X _ _ _ O _" + sep
				+ "3 _ _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ X _ _ _ O _" + sep
				+ "3 _ _ X _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ X _ _ _ O _" + sep
				+ "3 _ _ X _ _ O _" + sep
				+ "4 _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ X _ _ _ O _" + sep
				+ "3 _ _ X _ _ O _" + sep
				+ "4 _ _ _ X _ _ _" + sep
				+ "5 _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ X _ _ _ O _" + sep
				+ "3 _ _ X _ _ O _" + sep
				+ "4 _ _ _ X _ O _" + sep
				+ "5 _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ X _ _ _ O _" + sep
				+ "3 _ _ X _ _ O _" + sep
				+ "4 _ _ _ X _ O _" + sep
				+ "5 _ _ _ _ X _ _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G" + sep 
				+ "1 X _ _ _ _ O _" + sep 
				+ "2 _ X _ _ _ O _" + sep
				+ "3 _ _ X _ _ O _" + sep
				+ "4 _ _ _ X _ O _" + sep
				+ "5 _ _ _ _ X O _" + sep
				+ "6 _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _" + sep, bytes.toString());
	}
	
	// 10 step, abnormal 8
	@org.junit.Test
	public void test9() throws Exception {
		result = game.playGame("11", "A1,F1,B2,F2,F3,C3,D4,F4,E5,F5", 8);
		assertEquals(Result.GAMING, result);
		assertEquals(
				  "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ _ _ _" + sep 
				+ "2 _ _ _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ _ _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ _ _ _ _ _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ _ _ _ X _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ O _ _ X _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ O _ _ X _ _" + sep
				+ "4 _ _ _ X _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ O _ _ X _ _" + sep
				+ "4 _ _ _ X _ O _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ O _ _ X _ _" + sep
				+ "4 _ _ _ X _ O _ _" + sep
				+ "5 _ _ _ _ X _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ O _ _ X _ _" + sep
				+ "4 _ _ _ X _ O _ _" + sep
				+ "5 _ _ _ _ X O _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep, bytes.toString());
	}
	
	// Attention
	// 11 step, normal 8
	@org.junit.Test
	public void test10() throws Exception {
		result = game.playGame("10", "F3,F1,A1,F2,B2,F4,C3,F5,D4,F6,E5", 8);
		assertEquals(Result.X_WIN, result);
		assertEquals(
				  "  A B C D E F G H" + sep 
				+ "1 _ _ _ _ _ _ _ _" + sep 
				+ "2 _ _ _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ X _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 _ _ _ _ _ O _ _" + sep 
				+ "2 _ _ _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ X _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ _ _ _ _ _ _ _" + sep
				+ "3 _ _ _ _ _ X _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ _ _ _ _ O _ _" + sep
				+ "3 _ _ _ _ _ X _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ _ _ _ X _ _" + sep
				+ "4 _ _ _ _ _ _ _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ _ _ _ X _ _" + sep
				+ "4 _ _ _ _ _ O _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ X _ _ X _ _" + sep
				+ "4 _ _ _ _ _ O _ _" + sep
				+ "5 _ _ _ _ _ _ _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ X _ _ X _ _" + sep
				+ "4 _ _ _ _ _ O _ _" + sep
				+ "5 _ _ _ _ _ O _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ X _ _ X _ _" + sep
				+ "4 _ _ _ X _ O _ _" + sep
				+ "5 _ _ _ _ _ O _ _" + sep
				+ "6 _ _ _ _ _ _ _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ X _ _ X _ _" + sep
				+ "4 _ _ _ X _ O _ _" + sep
				+ "5 _ _ _ _ _ O _ _" + sep
				+ "6 _ _ _ _ _ O _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep
				+ "  A B C D E F G H" + sep 
				+ "1 X _ _ _ _ O _ _" + sep 
				+ "2 _ X _ _ _ O _ _" + sep
				+ "3 _ _ X _ _ _ _ _" + sep
				+ "4 _ _ _ X _ O _ _" + sep
				+ "5 _ _ _ _ X O _ _" + sep
				+ "6 _ _ _ _ _ O _ _" + sep
				+ "7 _ _ _ _ _ _ _ _" + sep
				+ "8 _ _ _ _ _ _ _ _" + sep, bytes.toString());
	}
}
