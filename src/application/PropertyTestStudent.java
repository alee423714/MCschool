package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
    Property prop1, prop2, propCopy;

    @BeforeEach
    void setUp() throws Exception {
        prop1 = new Property("Test House", "Test City", 1000.0, "Test Owner", 2, 2, 6, 6);
        prop2 = new Property("No Plot House", "Another City", 1500.0, "Other Owner");
    }

    @AfterEach
    void tearDown() throws Exception {
        prop1 = prop2 = propCopy = null;
    }

    @Test
    void testDefaultConstructor() {
        Property prop = new Property();
        assertEquals("", prop.getPropertyName());
        assertEquals("", prop.getCity());
        assertEquals(0.0, prop.getRentalAmount());
        assertEquals("", prop.getOwner());
        assertNotNull(prop.getPlot());
    }

    @Test
    void testParamConstructorWithPlot() {
        assertEquals("Test House", prop1.getPropertyName());
        assertEquals("Test City", prop1.getCity());
        assertEquals(1000.0, prop1.getRentalAmount());
        assertEquals("Test Owner", prop1.getOwner());
        assertEquals("2,2,6,6", prop1.getPlot().toString());
    }
    
    @Test
    void testParamConstructorNoPlot() {
        assertEquals("No Plot House", prop2.getPropertyName());
        assertEquals("Another City", prop2.getCity());
        assertEquals(1500.0, prop2.getRentalAmount());
        assertEquals("Other Owner", prop2.getOwner());
        assertEquals("0,0,1,1", prop2.getPlot().toString()); // Should have default plot
    }

    @Test
    void testCopyConstructor() {
        propCopy = new Property(prop1);
        assertEquals("Test House", propCopy.getPropertyName());
        assertEquals(1000.0, propCopy.getRentalAmount());
        assertEquals("2,2,6,6", propCopy.getPlot().toString());
        
        // Test that it is a deep copy
        assertNotSame(prop1, propCopy);
        assertNotSame(prop1.getPlot(), propCopy.getPlot());
        
        // Change original, copy should not change
        prop1.setPropertyName("Changed");
        prop1.getPlot().setX(99);
        assertEquals("Test House", propCopy.getPropertyName());
        assertEquals(2, propCopy.getPlot().getX());
    }

    @Test
    void testGettersSetters() {
        prop1.setPropertyName("New Name");
        assertEquals("New Name", prop1.getPropertyName());
        
        prop1.setCity("New City");
        assertEquals("New City", prop1.getCity());
        
        prop1.setRentalAmount(2000.0);
        assertEquals(2000.0, prop1.getRentalAmount());
        
        prop1.setOwner("New Owner");
        assertEquals("New Owner", prop1.getOwner());
        
        Plot newPlot = new Plot(1,1,1,1);
        prop1.setPlot(newPlot);
        assertSame(newPlot, prop1.getPlot());
    }

    @Test
    void testToString() {
        assertEquals("Test House,Test City,Test Owner,1000.0", prop1.toString());
        assertEquals("No Plot House,Another City,Other Owner,1500.0", prop2.toString());
    }
}
