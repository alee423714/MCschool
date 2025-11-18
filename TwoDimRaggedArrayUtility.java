package assignment5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: A utility class to manipulate 2D ragged arrays of doubles.
 * Due: 11/17/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Adam Lee
 */
public class TwoDimRaggedArrayUtility {

    /**
     * Reads sales data from a file and returns a 2D ragged array of doubles.
     * Each line in the file represents a row, and numbers on the line
     * (separated by spaces) represent columns.
     *
     * @param file The file to read from.
     * @return A 2D ragged array of doubles, or null if the file is not found.
     * @throws FileNotFoundException If the specified file does not exist.
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        // Use an ArrayList to temporarily store lines, as we don't know the row count
        ArrayList<String> lines = new ArrayList<>();
        Scanner fileScanner = new Scanner(file);
        
        while (fileScanner.hasNextLine()) {
            lines.add(fileScanner.nextLine());
        }
        fileScanner.close();
        
        // Create the 2D array with the known number of rows
        double[][] data = new double[lines.size()][];
        
        // Iterate through each line to create the inner arrays
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            // Use a second scanner to read numbers from the line string
            Scanner lineScanner = new Scanner(line);
            ArrayList<Double> values = new ArrayList<>();
            while (lineScanner.hasNextDouble()) {
                values.add(lineScanner.nextDouble());
            }
            lineScanner.close();
            
            // Create the inner array with the exact number of columns
            data[i] = new double[values.size()];
            
            //Copy values from the ArrayList to the inner array
            for (int j = 0; j < values.size(); j++) {
                data[i][j] = values.get(j);
            }
        }
        
        return data;
    }

    /**
     * Writes the given 2D ragged array data to a file.
     * Each element is separated by a space, and each row is on a new line.
     *
     * @param data The 2D ragged array of doubles to write.
     * @param file The file to write to.
     * @throws FileNotFoundException If the file cannot be created or written to.
     */
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                writer.print(data[i][j] + " ");
            }
            writer.println(); // New line for the next row
        }
        
        writer.close();
    }

    /**
     * Calculates the total of all elements in the 2D ragged array.
     *
     * @param data The 2D ragged array.
     * @return The sum of all elements.
     */
    public static double getTotal(double[][] data) {
        double total = 0.0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        return total;
    }

    /**
     * Calculates the average of all elements in the 2D ragged array.
     *
     * @param data The 2D ragged array.
     * @return The average (total / number of elements).
     */
    public static double getAverage(double[][] data) {
		double total = 0.0;
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
				count++;
			}
		}
		if (count == 0) {
			return 0.0;
		}
		return total / count;
	}

    /**
     * Calculates the total of all elements in a specified row.
     *
     * @param data The 2D ragged array.
     * @param row The index of the row to total.
     * @return The sum of the elements in that row.
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0.0;
        // Check if row is valid
        if (row >= 0 && row < data.length) {
            for (int j = 0; j < data[row].length; j++) {
                total += data[row][j];
            }
        }
        return total;
    }

    /**
     * Calculates the total of all elements in a specified column.
     * This method accounts for the ragged nature of the array.
     *
     * @param data The 2D ragged array.
     * @param col The index of the column to total.
     * @return The sum of the elements in that column.
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;
        for (int i = 0; i < data.length; i++) {
            // Check if the current row HAS this column
            if (col >= 0 && col < data[i].length) {
                total += data[i][col];
            }
        }
        return total;
    }

    /**
     * Finds the highest element in a specified row.
     *
     * @param data The 2D ragged array.
     * @param row The index of the row.
     * @return The highest value in that row.
     */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = Double.NEGATIVE_INFINITY;
		if (row >= 0 && row < data.length) {
			for (int j = 0; j < data[row].length; j++) {
				if (data[row][j] > highest) {
					highest = data[row][j];
				}
			}
		}
		return highest;
	}

    /**
     * Finds the index of the highest element in a specified row.
     *
     * @param data The 2D ragged array.
     * @param row The index of the row.
     * @return The index of the highest value in that row.
     */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = Double.NEGATIVE_INFINITY;
		int index = -1;
		if (row >= 0 && row < data.length) {
			for (int j = 0; j < data[row].length; j++) {
				if (data[row][j] > highest) {
					highest = data[row][j];
					index = j;
				}
			}
		}
		return index;
	}

    /**
     * Finds the lowest element in a specified row.
     *
     * @param data The 2D ragged array.
     * @param row The index of the row.
     * @return The lowest value in that row.
     */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = Double.POSITIVE_INFINITY;
		if (row >= 0 && row < data.length) {
			for (int j = 0; j < data[row].length; j++) {
				if (data[row][j] < lowest) {
					lowest = data[row][j];
				}
			}
		}
		return lowest;
	}

    /**
     * Finds the index of the lowest element in a specified row.
     *
     * @param data The 2D ragged array.
     * @param row The index of the row.
     * @return The index of the lowest value in that row.
     */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = Double.POSITIVE_INFINITY;
		int index = -1;
		if (row >= 0 && row < data.length) {
			for (int j = 0; j < data[row].length; j++) {
				if (data[row][j] < lowest) {
					lowest = data[row][j];
					index = j;
				}
			}
		}
		return index;
	}

    /**
     * Finds the highest element in a specified column.
     *
     * @param data The 2D ragged array.
     * @param col The index of the column.
     * @return The highest value in that column.
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY; // Start with the smallest possible value
        
        for (int i = 0; i < data.length; i++) {
            if (col >= 0 && col < data[i].length) {
                if (data[i][col] > highest) {
                    highest = data[i][col];
                }
            }
        }
        return highest;
    }

    /**
     * Finds the index of the highest element in a specified column.
     *
     * @param data The 2D ragged array.
     * @param col The index of the column.
     * @return The index (row) of the highest value in that column.
     */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = Double.NEGATIVE_INFINITY;
		int index = -1;
		for (int i = 0; i < data.length; i++) {
			if (col >= 0 && col < data[i].length) {
				if (data[i][col] > highest) {
					highest = data[i][col];
					index = i;
				}
			}
		}
		return index;
	}

    /**
     * Finds the lowest element in a specified column.
     *
     * @param data The 2D ragged array.
     * @param col The index of the column.
     * @return The lowest value in that column.
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY; // Start with the largest possible value
        
        for (int i = 0; i < data.length; i++) {
            if (col >= 0 && col < data[i].length) {
                if (data[i][col] < lowest) {
                    lowest = data[i][col];
                }
            }
        }
        return lowest;
    }

    /**
     * Finds the index of the lowest element in a specified column.
     *
     * @param data The 2D ragged array.
     * @param col The index of the column.
     * @return The index (row) of the lowest value in that column.
     */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = Double.POSITIVE_INFINITY;
		int index = -1;
		for (int i = 0; i < data.length; i++) {
			if (col >= 0 && col < data[i].length) {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
					index = i;
				}
			}
		}
		return index;
	}

    /**
     * Finds the highest element in the entire 2D ragged array.
     *
     * @param data The 2D ragged array.
     * @return The highest value in the array.
     */
	public static double getHighestInArray(double[][] data) {
		double highest = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		return highest;
	}

    /**
     * Finds the lowest element in the entire 2D ragged array.
     *
     * @param data The 2D ragged array.
     * @return The lowest value in the array.
     */
	public static double getLowestInArray(double[][] data) {
		double lowest = Double.POSITIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}
}