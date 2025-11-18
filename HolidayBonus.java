package assignment5;

/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: Calculates holiday bonuses for stores based on sales data.
 * Due: 11/17/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Adam Lee
 */
public class HolidayBonus {

	private static final double HIGH_BONUS = 5000.0;
	private static final double LOW_BONUS = 1000.0;
	private static final double OTHER_BONUS = 2000.0;

	public static double[] calculateHolidayBonus(double[][] data) {
		if (data == null) {
			return new double[0];
		}

		double[] bonuses = new double[data.length];

		int maxCols = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null && data[i].length > maxCols) {
				maxCols = data[i].length;
			}
		}

		for (int col = 0; col < maxCols; col++) {
			
			int highIndex = -1;
			int lowIndex = -1;
			double highest = Double.NEGATIVE_INFINITY;
			double lowest = Double.POSITIVE_INFINITY;

			for (int row = 0; row < data.length; row++) {
				if (data[row] != null && col < data[row].length && data[row][col] > 0) {
					
					if (data[row][col] > highest) {
						highest = data[row][col];
						highIndex = row;
					}
					if (data[row][col] < lowest) {
						lowest = data[row][col];
						lowIndex = row;
					}
				}
			}

			if (highIndex != -1) { 
				
				if (highIndex == lowIndex) {
					bonuses[highIndex] += HIGH_BONUS;
				} else {
					for (int row = 0; row < data.length; row++) {
						if (data[row] != null && col < data[row].length && data[row][col] > 0) {
							
							if (row == highIndex) {
								bonuses[row] += HIGH_BONUS;
							} else if (row == lowIndex) {
								bonuses[row] += LOW_BONUS;
							} else {
								bonuses[row] += OTHER_BONUS;
							}
						}
					}
				}
			}
		}
		return bonuses;
	}

	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] individualBonuses = calculateHolidayBonus(data);
		double total = 0.0;
		for (double bonus : individualBonuses) {
			total += bonus;
		}
		return total;
	}
}