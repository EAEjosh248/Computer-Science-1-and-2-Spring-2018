
import java.io.*;

import java.util.Scanner;

/**
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows
 * and 10 columns This utility works with negative and positive numbers
 * 
 * @author Rajashow
 * 
 */
public class TwoDimRaggedArrayUtility {
	public TwoDimRaggedArrayUtility() {

	}

	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is
	 * 10 and the maximum columns for each row is 10 Each row in the file is
	 * separated by a new line Each element in the row is separated by a space
	 * Suggestion: You need to know how many rows and how many columns there are for
	 * each row to create a ragged array.
	 * 
	 * @param file
	 *            : File
	 * @return sales : double[][]
	 */
	
	public static double[][] readFile(File file) throws FileNotFoundException {
        double[][] arr = null;
        try {
            Scanner in = new Scanner(file);
            int rows = 0;
            while (in.hasNextLine()) {
                ++rows;
                in.nextLine();
            }
            in.close();
            in = new Scanner(file);
            String line;
            arr = new double[rows][];
            for (int i = 0; i < arr.length; ++i) {
                line = in.nextLine();
                String[] nums = line.split(" ");
                arr[i] = new double[nums.length];
                for (int j = 0; j < arr[i].length; ++j) {
                    arr[i][j] = Double.valueOf(nums[j]);
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

	/**
	 * Returns the total of the selected row in the two dimensional array index 0
	 * refers to the first row.
	 * 
	 * @return total : double
	 * @param sales
	 *            : double[][]
	 * @param row
	 *            : int
	 * 
	 */
	public static double getRowTotal(double[][] sales, int row) {
		double total = 0;

		for (int i = 0; i < sales[row].length; i++) {
			total += sales[row][i];
		}

		return total;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array index 0
	 * refers to the first column.
	 * 
	 * @return total : double
	 * @param sales
	 *            : double[][]
	 * @param col
	 *            : int
	 * 
	 */
	public static double getColumnTotal(double[][] sales, int col) {
		double total = 0;

		for (int i = 0; i < sales.length; i++) {
			if (col < sales[i].length)
				total += sales[i][col];
		}

		return total;
	}

	/**
	 * Returns the largest element of the selected column in the two dimensional
	 * array index 0 refers to the first row.
	 * 
	 * @return highest : double
	 * @param sales
	 *            : double[][]
	 * @param col
	 *            : int
	 * 
	 */
	public static double getHighestInColumn(double[][] sales, int col) {
		double highest = Double.MIN_VALUE;

		for (int i = 0; i < sales.length; i++) {
			if (col < sales[i].length)
				if (sales[i][col] > highest)
					highest = sales[i][col];
		}

		return highest;
	}

	/**
	 * Returns the smallest element of the selected column in the two dimensional
	 * array index 0 refers to the first row.
	 * 
	 * @return lowest : double
	 * @param sales
	 *            : double[][]
	 * @param col
	 *            : int
	 * 
	 */
	public static double getLowestInColumn(double[][] sales, int col) {
		double lowest = Double.MAX_VALUE;

		for (int i = 0; i < sales.length; i++) {
			if (col < sales[i].length)
				if (sales[i][col] < lowest)
					lowest = sales[i][col];
		}

		return lowest;
	}

	/**
	 * Writes the ragged array of doubles into the file.
	 * 
	 * @param selectedFile
	 *            : File
	 * @param sales
	 *            : double[][]
	 */
	public static void writeToFile(double[][] sales, File selectedFile) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile));
            for (int i = 0; i < sales.length; ++i) {
                for (int j = 0; j < sales[i].length; ++j) {
                    bw.write(sales[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**
	 * Returns the total of all the elements of the two dimensional array
	 * 
	 * @return Total : double
	 * @param dataSet
	 *            : double[][]
	 */
	public static double getTotal(double[][] dataSet) {
		double total = 0;
		for (int i = 0; i < dataSet.length; i++) {
			for (int j = 0; j < dataSet[i].length; j++) {
				total += dataSet[i][j];
			}

		}
		return total;
	}

	/**
	 * Returns the average of the elements in the two dimensional array
	 * 
	 * @return Average : double
	 * @param dataSet
	 *            : double[][]
	 */
	public static double getAverage(double[][] dataSet) {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < dataSet.length; i++) {
			for (int j = 0; j < dataSet[i].length; j++) {
				sum += dataSet[i][j];
				count++;
			}

		}
		return sum / count;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @return highest : double
	 * @param dataSet
	 *            : double[][]
	 * @param row
	 *            : int
	 * 
	 */

	public static double getHighestInRow(double[][] dataSet, int row) {
		double highest = Double.MIN_VALUE;

		for (int i = 0; i < dataSet[row].length; i++) {
			if (dataSet[row][i] > highest)
				highest = dataSet[row][i];
		}

		return highest;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @return lowest : double
	 * @param dataSet
	 *            : double[][]
	 * @param row
	 *            : int
	 * 
	 */
	public static double getLowestInRow(double[][] dataSet, int row) {
		double lowest = Double.MAX_VALUE;

		for (int i = 0; i < dataSet[row].length; i++) {
			if (dataSet[row][i] < lowest)
				lowest = dataSet[row][i];
		}

		return lowest;
	}

	/**
	 * Returns the Largest element in the two dimensional array
	 * 
	 * @return highest : double
	 * @param dataSet
	 *            : double[][]
	 * 
	 */
	public static double getHighestInArray(double[][] dataSet) {
		double highest = Double.MIN_VALUE;

		for (int i = 0; i < dataSet.length; i++) {
			for (int j = 0; j < dataSet[i].length; j++)
				if (dataSet[i][j] > highest)
					highest = dataSet[i][j];
		}

		return highest;
	}

	/**
	 * Returns the smallest element in the two dimensional array
	 * 
	 * @return lowest : double
	 * @param dataSet
	 *            : double[][]
	 * 
	 */
	public static double getLowestInArray(double[][] dataSet) {
		double lowest = Double.MAX_VALUE;

		for (int i = 0; i < dataSet.length; i++) {
			for (int j = 0; j < dataSet[i].length; j++)
				if (dataSet[i][j] < lowest)
					lowest = dataSet[i][j];
		}

		return lowest;
	}

}
