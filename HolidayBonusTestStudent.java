package assignment5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent {

    private double[][] dataSetStudent = {
        {100, 200, 300},
        {400, 500},
        {600, 700, 800, 900}
    };
    
    private double[][] dataSetStudentNegative = {
        {100, -200, 300},
        {400, 500},
        {-600, 700, 800, -900}
    };
    
    private double[][] dataSetStudentSingle = {
        {100},
        {200},
        {300}
    };

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] expectedBonuses = {3000.0, 4000.0, 20000.0};
        double[] bonuses = HolidayBonus.calculateHolidayBonus(dataSetStudent);
        assertEquals(3, bonuses.length);
        assertArrayEquals(expectedBonuses, bonuses, .001);
        
        double[] expectedBonusesNegative = {2000.0, 6000.0, 10000.0};
        bonuses = HolidayBonus.calculateHolidayBonus(dataSetStudentNegative);
        assertEquals(3, bonuses.length);
        assertArrayEquals(expectedBonusesNegative, bonuses, .001);
    }
    
    @Test
    public void testCalculateHolidayBonusSingle() {
        double[] expectedBonuses = {1000.0, 2000.0, 5000.0};
        double[] bonuses = HolidayBonus.calculateHolidayBonus(dataSetStudentSingle);
        assertEquals(3, bonuses.length);
        assertArrayEquals(expectedBonuses, bonuses, .001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        assertEquals(27000.0, HolidayBonus.calculateTotalHolidayBonus(dataSetStudent), .001);
        assertEquals(18000.0, HolidayBonus.calculateTotalHolidayBonus(dataSetStudentNegative), .001);
        assertEquals(8000.0, HolidayBonus.calculateTotalHolidayBonus(dataSetStudentSingle), .001);
    }
}