package MercadoLibre.src.com.company;

import java.util.Scanner;

public class Mutant {

    public static void main(String[] args) {
       // String[] dna = {"ATGCCA", "AAGTAC", "CTACGT", "AACAGG", "GGCCCA", "TCCATG"};
        String[] dna = getDna();

        //imprime matriz generada
        char[][] matrix = createMatrix(dna);
        printMatrix(dna, matrix);

        //valida el dna ingresado
        boolean mutant = isMutant(dna);
        if (mutant) System.out.println("\n\n:::: MUTANTE DETECTADO ::::");
        else System.out.println("\n\nEste humano no es mutante");
    }

    /**
     * @return String
     * recibe el dna y lo envia como String
     */
    private static String[] getDna() {
        System.out.println("Ingrese secuencia ADN...");
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();
        return inputString.split(",");
    }

    /**
     * @param dna
     * @return boolean
     * Valida que el ADN corresponda a un mutante
     */
    private static boolean isMutant(String[] dna) {
        //verifica hallazgo vertical
        boolean vertical = validateVertical(dna);
        if (vertical) return true;
        //verifica hallazgo horizontal
        for (int i = 0; dna.length > i; i++) {
            boolean horizontal = validateHorizontal(dna[i]);
            if (horizontal) return true;
        }
        //verifica hallazgo oblicuo
        boolean diagonal = validateDiagonal(dna);
        if (diagonal)return true;

        return false;
    }

    /**
     * @param dna
     * @return boolean
     * Valida que un ADN coincida en forma horizontal
     */
    private static boolean validateHorizontal(String dna) {
        int letterCounter = 1;
        char[] dnaChars = dna.toCharArray();

        for (int i = 0; i < dnaChars.length; i++) {
            //compara consecutivas desde la segunda posición
            if (i == 0) continue;
            //resetea contado si la letra de la derecha no es igual a la de la izquierda
            if (dnaChars[i] == dnaChars[i - 1]) letterCounter++; else letterCounter = 1;
            //finaliza como verdadero si hay 4 letras iguales consecutivas
            if (letterCounter == 4) return true;
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
                //compara consecutivas desde la segunda posición
                if (j == 0) continue;
                //resetea contado si la letra de arriba no es igual a la de abajo
                if (matrix[j][i] == matrix[j - 1][i]) letterCounter++; else letterCounter = 1;
                //finaliza como verdadero si hay 4 letras iguales consecutivas
                if (letterCounter == 4) return true;
            }
        }
        return false;
    }

    /**
     * @param dna
     * @return boolean
     * Valida que un ADN coincida en forma oblicua
     */
    public static boolean validateDiagonal(String[] dna) {
        char[][] matrix = createMatrix(dna);
        int letterCounter = 1;

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                if (j == 0) continue;
                if (i == 0) continue;
                //compara con la posicion superior izquierda
                if (matrix[i - 1][j - 1] == matrix[i][j]) letterCounter++; else letterCounter = 1;
                //compara con la posicion superior derecha
                //if (matrix[i + 1][j + 1] == matrix[i][j])letterCounter++; else letterCounter = 1;
                //finaliza como verdadero si hay 4 letras iguales consecutivas
                if (letterCounter == 4) return true;

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
        //crea una matriz cuadrada
        char[][] matrix = new char[dna.length][dna.length];
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[0].length(); j++) {
                //completa la matriz con el dna
                matrix[i][j] = dna[i].toCharArray()[j];
            }
        }
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
                //imprime matriz generada
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}

