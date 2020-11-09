package com.leetcode.array;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/11/9 22:45
 * @Version 1.0
 */
public class SetMatrixZeroes_73 {

    /**
     *
     *
     *
     */
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length, n = matrix[0].length;

        boolean rowZero = false, colZero = false;

        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0)
                colZero = true;
        }

        for (int i = 0; i < n; ++i) {
            if (matrix[0][i] == 0)
                rowZero = true;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowZero) {
            for (int i = 0; i < n; ++i)
                matrix[0][i] = 0;
        }

        if (colZero) {
            for (int i = 0; i < m; ++i)
                matrix[i][0] = 0;
        }

    }

}
