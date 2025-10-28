package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
    private Plot plot1, plot2, plot3, plot4, plot5;

    @BeforeEach
    void setUp() throws Exception {
        plot1 = new Plot(2, 2, 6, 6); // Main plot
        plot2 = new Plot(3, 3, 2, 2); // Encompassed by plot1
        plot3 = new Plot(5, 5, 4, 4); // Overlaps plot1
        plot4 = new Plot(10, 10, 2, 2); // No overlap with plot1
        plot5 = new Plot(2, 2, 6, 6); // Identical to plot1
    }

    @AfterEach
    void tearDown() throws Exception {
        plot1 = plot2 = plot3 = plot4 = plot5 = null;
    }

    @Test
    void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals(2, plot1.getX());
        assertEquals(2, plot1.getY());
        assertEquals(6, plot1.getWidth());
        assertEquals(6, plot1.getDepth());
    }

    @Test
    void testCopyConstructor() {
        Plot copy = new Plot(plot1);
        assertEquals(2, copy.getX());
        assertEquals(6, copy.getWidth());
        assertNotSame(plot1, copy); // Check that it's a new object
    }

    @Test
    void testOverlaps() {
        assertTrue(plot1.overlaps(plot2)); // plot2 is inside plot1
        assertTrue(plot1.overlaps(plot3)); // plot3 overlaps plot1
        assertFalse(plot1.overlaps(plot4)); // plot4 is separate
        assertTrue(plot1.overlaps(plot5)); // Identical plots overlap
        
        Plot adjacent = new Plot(8, 2, 2, 2); // Adjacent (touching edge), not overlapping
        assertFalse(plot1.overlaps(adjacent));
    }

    @Test
    void testEncompasses() {
        assertTrue(plot1.encompasses(plot2)); // plot2 is inside plot1
        assertFalse(plot1.encompasses(plot3)); // plot3 is only partially inside
        assertFalse(plot1.encompasses(plot4)); // plot4 is separate
        assertTrue(plot1.encompasses(plot5)); // Encompasses itself (inclusive)
    }

    @Test
    void testGetters() {
        assertEquals(2, plot1.getX());
        assertEquals(2, plot1.getY());
        assertEquals(6, plot1.getWidth());
        assertEquals(6, plot1.getDepth());
    }

    @Test
    void testSetters() {
        plot1.setX(10);
        plot1.setY(11);
        plot1.setWidth(12);
        plot1.setDepth(13);
        assertEquals(10, plot1.getX());
        assertEquals(11, plot1.getY());
        assertEquals(12, plot1.getWidth());
        assertEquals(13, plot1.getDepth());
    }

    @Test
    void testToString() {
        assertEquals("2,2,6,6", plot1.toString());
        assertEquals("10,10,2,2", plot4.toString());
    }
}
