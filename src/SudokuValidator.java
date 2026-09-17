public class SudokuValidator {

    public static void main(String[] args) {

        int[][] sudoku = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        System.out.println("Tablero de Sudoku:");

        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                System.out.print(sudoku[fila][columna] + " ");
            }
            System.out.println();
        }

        if (validarFilas(sudoku)) {
            System.out.println("Las filas son válidas.");
        } else {
            System.out.println("El Sudoku tiene errores en las filas.");
        }
    }

    public static boolean validarFilas(int[][] sudoku) {

        for (int fila = 0; fila < 9; fila++) {

            boolean[] usado = new boolean[10];

            for (int columna = 0; columna < 9; columna++) {

                int numero = sudoku[fila][columna];

                if (usado[numero]) {
                    System.out.println("Error: número repetido en la fila " + (fila + 1));
                    return false;
                }

                usado[numero] = true;
            }
        }

        return true;
    }
}