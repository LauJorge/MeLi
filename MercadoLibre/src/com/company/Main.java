package com.company;

public class Main {

    public static void main(String[] args) {
        String[] dna = {"ATJCGA", "CAGTAAD", "TTATGT", "AGAAGG", "CCACTA", "TCACTG"};
        isMutant(dna);
    }


    /**
     * @param dna
     * @return boolean
     * Valida que un adn corresponda a un mutante
     */
    public static int isMutant(String[] dna) {

        char[][] matrix = createMatrix(dna);
        int contadorVertical = 1;
        int contadorHorizontal = 1;
        int contadorOblicuo = 0;

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                char ver = matrix[i][j];
                if (i == 0) continue;
                if (j == 0) continue;
                if (matrix[i][j] == matrix[i - 1][j]) contadorVertical++;
                else contadorVertical = 1;
                if (matrix[j][i] == matrix[j - 1][i]) contadorHorizontal++;
                else contadorHorizontal = 1;
                if (matrix[j][i] == matrix[j - 1][i - 1]) contadorOblicuo++;
                else contadorHorizontal = 1;


                //if (contadorVertical == 4) {
                //System.out.println("Es Mutanteeeeeeeeeeeeeeeeeeeeeee Vertical");
                //  return contadorVertical;
                //}

                // if (contadorHorizontal == 4) {
                // System.out.println("Es Mutanteeeeeeeeeeeeeeeeeeeeeee Horizontal!");
                //   return contadorHorizontal;
                // }

                if (contadorOblicuo == 4) {
                    System.out.println("Es Mutanteeeeeeeeeeeeeeeeeeeeeee oblicuo!");
                    return contadorOblicuo;
                }

            }
        }

        return 0;
    }

    /**
     * @param dna
     * @return
     * Crea una matriz con los datos ingresados
     */
    private static char[][] createMatrix(String[] dna) {
        char[][] matrix = new char[dna.length][dna.length];

        for (int i = 0; i < dna.length; i++) {
            if (dna.length != dna[i].length()){
                System.out.println("tamaño de matrix invalido");
                break;
            }
            else{
            for (int j = 0; j < dna[0].length(); j++) {
                if ((dna[i].toCharArray()[j] == 'A' || dna[i].toCharArray()[j] == 'T' || dna[i].toCharArray()[j] == 'C' || dna[i].toCharArray()[j] == 'G')){
                    System.out.println("caracter invalido");
                    break;
                }
                matrix[i][j] = dna[i].toCharArray()[j];
            }
                printMatrix(dna, matrix);

            }
        }
        return matrix;
    }

    private static void printMatrix(String[] dna, char[][] matrix) {
        for (int i = 0; i < dna.length; i++) {
            System.out.println("");
            for (int j = 0; j < dna[0].length(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}