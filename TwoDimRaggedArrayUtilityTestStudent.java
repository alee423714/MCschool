package assignment5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] dataSetStudent = {
        {10.5, 20.0, 15.0},
        {5.0},
        {30.0, 40.0, -10.0, 50.0}
    };

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetTotal() {
        assertEquals(160.5, TwoDimRaggedArrayUtility.getTotal(dataSetStudent), .001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(20.0625, TwoDimRaggedArrayUtility.getAverage(dataSetStudent), .001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(45.5, TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent, 0), .001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent, 1), .001);
        assertEquals(110.0, TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent, 2), .001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(45.5, TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent, 0), .001);
        assertEquals(60.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent, 1), .001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent, 2), .001);
        assertEquals(50.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent, 3), .001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(20.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSetStudent, 0), .001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSetStudent, 1), .001);
        assertEquals(50.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSetStudent, 2), .001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSetStudent, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSetStudent, 1));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSetStudent, 2));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(10.5, TwoDimRaggedArrayUtility.getLowestInRow(dataSetStudent, 0), .001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSetStudent, 1), .001);
        assertEquals(-10.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSetStudent, 2), .001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSetStudent, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSetStudent, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSetStudent, 2));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(30.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSetStudent, 0), .001);
        assertEquals(40.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSetStudent, 1), .001);
        assertEquals(15.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSetStudent, 2), .001);
        assertEquals(50.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSetStudent, 3), .001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSetStudent, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSetStudent, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSetStudent, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSetStudent, 3));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(5.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSetStudent, 0), .001);
        assertEquals(20.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSetStudent, 1), .001);
        assertEquals(-10.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSetStudent, 2), .001);
        assertEquals(50.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSetStudent, 3), .001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSetStudent, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSetStudent, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSetStudent, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSetStudent, 3));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(50.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSetStudent), .001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(-10.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSetStudent), .001);
    }
}