package MercadoLibre.src.com.company;

public class Mutant {

    public static void main(String[] args) {
        String[] dna = {"ATGCCA", "AAGTGC", "CTATGT", "AACAGG", "GGCCTA", "TCACTG"};
        boolean mutant = isMutant(dna);

        if (mutant) System.out.println("\n\n:::: MUTANTE DETECTADO ::::");
        else System.out.println("\n\nEste humano no es mutante");
    }

    /**
     * @param dna
     * @return boolean
     * Valida que el ADN corresponda a un mutante
     */
    private static boolean isMutant(String[] dna) {
        boolean vertical = validateVertical(dna);
        if (vertical) return true;

        for (int i = 0; dna.length > i; i++) {
            boolean horizontal = validateHorizontal(dna[i]);
            if (horizontal) return true;
        }
        return false;
    }

    /**
     * @param dna
     * @return boolean
     * Valida que un ADN coincida en forma horizontal
     */
    private static boolean validateHorizontal(String dna) {
        int contador = 1;
        char[] dnaChars = dna.toCharArray();

        for (int i = 0; i < dnaChars.length; i++) {
            if (i == 0) continue;
            if (dnaChars[i] == dnaChars[i - 1]) contador++;
            else contador = 1;
            if (contador == 4) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param dna
     * @return boolean
     * Valida que un ADN coincida en forma vertical
     */
    public static boolean validateVertical(String[] dna) {
        char[][] matrix = createMatrix(dna);
        int letterCounter = 1;

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                if (j == 0) continue;
                if (matrix[j][i] == matrix[j - 1][i]) letterCounter++;
                else letterCounter = 1;


                if (letterCounter == 4) {
                    return true;
                }

            }
        }
        return false;
    }


    /**
     * @param dna
     * @return char[][]
     * Crea una matriz con los datos ingresados
     */
    private static char[][] createMatrix(String[] dna) {
        char[][] matrix = new char[dna.length][dna.length];

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[0].length(); j++) {
                matrix[i][j] = dna[i].toCharArray()[j];
            }
        }
        printMatrix(dna, matrix);
        return matrix;

    }


    /**
     * @param dna
     * @param matrix
     * imprime matriz
     */
    private static void printMatrix(String[] dna, char[][] matrix) {
        System.out.println("\n Matriz analizada: ");
        for (int i = 0; i < dna.length; i++) {
            System.out.println("");
            for (int j = 0; j < dna[0].length(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}

