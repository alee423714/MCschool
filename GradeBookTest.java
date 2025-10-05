package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	
	private GradeBook book1;
	private GradeBook book2;

	@Before
	public void setUp() throws Exception {
		book1 = new GradeBook(5);
		book1.addScore(80.0);
		book1.addScore(95.0);
		
		book2 = new GradeBook(5);
		book2.addScore(75.0);
		book2.addScore(85.0);
		book2.addScore(60.0);
		book2.addScore(90.0);
		book2.addScore(100.0);
	}

	@After
	public void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}

	@Test
	public void testAddScore() {
		assertTrue(book1.addScore(70.0));
		assertEquals(3, book1.scoresSize());
		assertFalse(book2.addScore(100.0));
		assertEquals(5, book2.scoresSize());
	}
	
	@Test
	public void testSum() {
		assertEquals(175.0, book1.sum(), .0001);
		assertEquals(410.0, book2.sum(), .0001);
	}

	@Test
	public void testMinimum() {
		assertEquals(80.0, book1.minimum(), .0001);
		assertEquals(60.0, book2.minimum(), .0001);
	}

	@Test
	public void testFinalScore() {
		assertEquals(95.0, book1.finalScore(), .0001);
		assertEquals(350.0, book2.finalScore(), .0001);
	}
}