package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
    ManagementCompany company;
    Property prop1, prop2, prop3, prop4, prop5, prop6;

    @BeforeEach
    void setUp() throws Exception {
        company = new ManagementCompany("Test Co", "12345", 10.0);
        
        prop1 = new Property("Prop1", "CityA", 1000, "OwnerA", 1, 1, 2, 2);
        prop2 = new Property("Prop2", "CityB", 2000, "OwnerB", 4, 4, 2, 2);
        prop3 = new Property("Prop3", "CityC", 3000, "OwnerC", 7, 7, 2, 2);
        prop4 = new Property("Prop4", "CityD", 4000, "OwnerD", 1, 5, 2, 2);
        prop5 = new Property("Prop5", "CityE", 5000, "OwnerE", 5, 1, 2, 2);
        
        // Property 6 will be used to test failures
        prop6 = new Property("Prop6 Full", "CityF", 6000, "OwnerF", 1, 1, 1, 1); // Overlaps prop1
    }

    @AfterEach
    void tearDown() throws Exception {
        company = null;
        prop1 = prop2 = prop3 = prop4 = prop5 = prop6 = null;
    }

    @Test
    void testAddPropertySuccess() {
        assertEquals(0, company.addProperty(prop1));
        assertEquals(1, company.addProperty(prop2));
        assertEquals(2, company.addProperty(prop3));
        assertEquals(3, company.addProperty(prop4));
        assertEquals(4, company.addProperty(prop5));
        assertEquals(5, company.getPropertiesCount());
    }

    @Test
    void testAddPropertyOverloaded() {
        assertEquals(0, company.addProperty("Overload1", "City", 100, "Owner", 2, 2, 2, 2));
        assertEquals(1, company.addProperty("Overload2", "City", 200, "Owner")); // Default plot 0,0,1,1
        assertEquals(2, company.getPropertiesCount());
    }

    @Test
    void testAddPropertyFailureCodes() {
        // -1: Full
        company.addProperty(prop1);
        company.addProperty(prop2);
        company.addProperty(prop3);
        company.addProperty(prop4);
        company.addProperty(prop5);
        assertEquals(-1, company.addProperty(prop6)); // Array is full
        
        // Reset company
        company = new ManagementCompany("Test Co", "12345", 10.0);
        
        // -2: Null
        assertEquals(-2, company.addProperty(null));
        
        // -3: Not Encompassed
        Property outsidePlot = new Property("Outside", "City", 100, "Owner", 10, 10, 1, 1); // Mgmt plot is 0,0,10,10
        assertEquals(-3, company.addProperty(outsidePlot));
        
        // -4: Overlaps
        company.addProperty(prop1);
        Property overlappingPlot = new Property("Overlap", "City", 100, "Owner", 1, 1, 1, 1);
        assertEquals(-4, company.addProperty(overlappingPlot));
    }
    
    @Test
    void testCopyConstructor() {
        company.addProperty(prop1);
        company.addProperty(prop2);
        
        ManagementCompany copy = new ManagementCompany(company);
        
        assertNotSame(company, copy);
        assertEquals(company.getPropertiesCount(), copy.getPropertiesCount());
        assertNotSame(company.getProperties(), copy.getProperties()); // Check array is new
        assertNotSame(company.getProperties()[0], copy.getProperties()[0]); // Check property is new
        assertEquals(company.getProperties()[0].getPropertyName(), copy.getProperties()[0].getPropertyName());
    }

    @Test
    void testGetTotalRent() {
        company.addProperty(prop1); // 1000
        company.addProperty(prop2); // 2000
        company.addProperty(prop3); // 3000
        assertEquals(6000.0, company.getTotalRent());
    }

    @Test
    void testGetHighestRentPropperty() {
        company.addProperty(prop1); // 1000
        company.addProperty(prop3); // 3000
        company.addProperty(prop2); // 2000
        Property highest = company.getHighestRentProperty();
        assertNotNull(highest);
        assertEquals("Prop3", highest.getPropertyName());
        assertEquals(3000.0, highest.getRentalAmount());
    }

    @Test
    void testRemoveLastProperty() {
        company.addProperty(prop1);
        company.addProperty(prop2);
        assertEquals(2, company.getPropertiesCount());
        
        company.removeLastProperty();
        assertEquals(1, company.getPropertiesCount());
        assertEquals("Prop1", company.getProperties()[0].getPropertyName());
        assertNull(company.getProperties()[1]);
    }

    @Test
    void testIsPropertiesFull() {
        assertFalse(company.isPropertiesFull());
        company.addProperty(prop1);
        company.addProperty(prop2);
        company.addProperty(prop3);
        company.addProperty(prop4);
        company.addProperty(prop5);
        assertTrue(company.isPropertiesFull());
    }

    @Test
    void testIsMangementFeeValid() {
        assertTrue(company.isManagementFeeValid()); // 10.0
        
        ManagementCompany invalid1 = new ManagementCompany("Bad", "1", -1.0);
        assertFalse(invalid1.isManagementFeeValid());
        
        ManagementCompany invalid2 = new ManagementCompany("Bad", "1", 101.0);
        assertFalse(invalid2.isManagementFeeValid());
    }
}
