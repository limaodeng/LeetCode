package com.leetcode.array;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/20 23:31
 * @Version 1.0
 */
public class Search2DMatrixII_240 {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * <p>
     * This matrix has the following properties:
     * <p>
     * Integers in each row are sorted in ascending from left to right.
     * <p>
     * Integers in each column are sorted in ascending from top to bottom.
     * <p>
     * Example:
     * <p>
     * Consider the following matrix:
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * Given target = 5, return true.
     * <p>
     * Given target = 20, return false.
     */
    public static void main(String[] args) {
        int[][] matrix = {
                            {1, 4, 7, 11, 15},
                            {2, 5, 8, 12, 19},
                            {3, 6, 9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}
                        };
        int target = 44;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length - 1])
            return false;
        int row = matrix.length - 1;
        int col = 0;
        while (true){
            if(matrix[row][col] > target){
                row--;
            }else if(matrix[row][col] < target){
                col++;
            }else {
                return true;
            }
            if(row < 0 || col > matrix[0].length -1 ){
                break;
            }
        }
        return false;
    }

}
