package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int x = intArrayTri.length;
        int y = intArrayTri[0].length;
        int z = intArrayTri[0][0].length;

        int[][] arr = new int[y][z];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    arr[j][k] += intArrayTri[i][j][k];
                }
            }
        }
        return arr;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++){
            if (i < intArrayBi.length - 1) {
                builder.append(stringFlatMatrixRow(intArrayBi, i)).append("\n");
            } else {
                builder.append(stringFlatMatrixRow(intArrayBi, i));
            }
        }
        return builder.toString();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            if (i < uniArray.length - 1) {
                builder.append(uniArray[i]).append(" ");
            } else {
                builder.append(uniArray[i]);
            }
        }
        return builder.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] arr = new int[columns];
        int elemento = 0;
        for (int i = 0; i < columns; i++) {
            elemento++;
            arr[i] = elemento;
        }
        return arr;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] arr = new int[rows][columns];
        int elemento = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                elemento++;
                arr[i][j] = elemento;
            }
        }
        return arr;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] arr = new int[depth][rows][columns];
        int elemento = 0;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    elemento++;
                    arr[i][j][k] = elemento;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(3, 3);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(2, 2, 2);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
