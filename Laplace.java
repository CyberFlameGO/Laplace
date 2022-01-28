class Laplace {
	
	public static void main(String[] args) {
		Out.print("Wie viele Zeilen/Spalten hat die Matrix? ");
		int n = In.readInt();
		if (n < 1) {
			Out.println("Bitte gib eine valide Größe an!");
		}
		int[][] matrix = new int[n][n];
		for (int row = 0; row < n; row++) {
			Out.print("Gib Zeile " + row + " an: ");
			for (int column = 0; column < n; column++) {
				matrix[column][row] = In.readInt();
			}
		}
		
		Out.println("Die Determinante beträgt: " + det(matrix));
	}
	
	static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				Out.print(matrix[column][row] + " ");
			}
			Out.println();
		}
	}
	
	static int det(int[][] matrix) {
		if (matrix.length == 1) {
			return matrix[0][0];
		}
		if (matrix.length == 2) {
			return (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]);
		}
		
		int mult = 1;
		int det = 0;
		for (int column = 0; column < matrix.length; column++) {
			mult = (column % 2 == 0 ? 1 : -1);
			det += mult * matrix[column][0] * det(getNewMatrix(matrix, column));
		}
		
		return det;
	}
	
	static int[][] getNewMatrix(int[][] old, int element) {
		int n = old.length - 1;
		int[][] matrix = new int[n][n];
		for (int row = 1; row < old.length; row++) {
			int newColumn = 0;
			for (int column = 0; column < old.length; column++) {
				if (column == element)
					continue;
				matrix[newColumn][row - 1] = old[column][row];
				newColumn++;
			}
		}
		return matrix;
	}
	
	
}