public class SudokuValidator {

    public static void main(String[] args) {

        int[][] sudoku = {
            {5, 3, 4, 6, 7, 8, 9, 1, 10},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        boolean[][] errores = new boolean[9][9];

       System.out.println("Tablero de Sudoku:");

for (int fila = 0; fila < 9; fila++) {
    for (int columna = 0; columna < 9; columna++) {
        System.out.print(sudoku[fila][columna] + " ");
    }
    System.out.println();
}

if (!validarValores(sudoku, errores)) {
    System.out.println("El Sudoku contiene valores inválidos.");
    return;
}

System.out.println("Todos los valores son válidos.");

if (validarFilas(sudoku)) {
    System.out.println("Las filas son válidas.");
} else {
    System.out.println("El Sudoku tiene errores en las filas.");
}

if (validarColumnas(sudoku)) {
    System.out.println("Las columnas son válidas.");
} else {
    System.out.println("El Sudoku tiene errores en las columnas.");
}

if (validarBloques(sudoku)) {
    System.out.println("Los bloques son válidos.");
} else {
    System.out.println("El Sudoku tiene errores en los bloques.");
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
   

    public static boolean validarColumnas(int[][] sudoku) {

    for (int columna = 0; columna < 9; columna++) {

        boolean[] usado = new boolean[10];

        for (int fila = 0; fila < 9; fila++) {

            int numero = sudoku[fila][columna];

            if (usado[numero]) {
                System.out.println("Error: número repetido en la columna " + (columna + 1));
                return false;
            }

            usado[numero] = true;
        }
    }
    return true;
}
public static boolean validarBloques(int[][] sudoku) {

    for (int filaInicio = 0; filaInicio < 9; filaInicio += 3) {

        for (int columnaInicio = 0; columnaInicio < 9; columnaInicio += 3) {

            boolean[] usado = new boolean[10];

            for (int fila = filaInicio; fila < filaInicio + 3; fila++) {

                for (int columna = columnaInicio; columna < columnaInicio + 3; columna++) {

                    int numero = sudoku[fila][columna];

                    if (usado[numero]) {
                        System.out.println(
                            "Error: número repetido en el bloque 3x3."
                        );
                        return false;
                    }

                    usado[numero] = true;
                }
            }
        }
    }

    return true;
}
public static boolean validarValores(int[][] sudoku, boolean[][] errores) {

    boolean valido = true;

    for (int fila = 0; fila < 9; fila++) {

        for (int columna = 0; columna < 9; columna++) {

            int numero = sudoku[fila][columna];

            if (numero < 1 || numero > 9) {

                System.out.println(
                    "Error: valor inválido en fila " + (fila + 1)
                    + ", columna " + (columna + 1)
                    + ": " + numero
                );

                errores[fila][columna] = true;
                valido = false;
            }
        }
    }

    return valido;
}
}