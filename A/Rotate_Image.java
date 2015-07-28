/*
Rotate Image
*/
public class Rotate_Image {
	public static int[][] rotate(int[][] matrix, int flag) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[][] right = new int[cols][rows];
		int[][] left = new int[cols][rows];
		
		if (flag == 1) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					right[j][rows - 1 - i] = matrix[i][j];
				}
			}
			return right;
		} else if (flag == 0) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					left[cols - 1 - j][i] = matrix[i][j];
				}
			}
			return left;
		}
		return null;	
	}
	
	public static void printMatrix(int[][] test) {
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {		
				System.out.print(" " + test[i][j]);
			}
		    System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] test = {{1, 2, 3, 4, 5}, 
				          {6, 7, 8, 9, 10},
				          {11, 12, 13, 14, 15}};
		
		printMatrix(test);
		printMatrix(rotate(test, 0));
	}
}
