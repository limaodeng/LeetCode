package com.leetcode.array;

/**
 * @Auther: dlm
 * @Date: 2020/11/2 09:03
 * @Description:
 */
public class SearchA2DMatrix_74 {

    /**
     *
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     *
     * This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     *
     * The first integer of each row is greater than the last integer of the previous row.
     *
     *
     * Example 1:
     *
     *
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
     * Output: true
     * Example 2:
     *
     *
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
     * Output: false
     * Example 3:
     *
     * Input: matrix = [], target = 0
     * Output: false
     *
     *
     * Constraints:
     *
     * m == matrix.length
     * n == matrix[i].length
     * 0 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     *
     */
    public static void main(String[] args) {

    }

    //二分查找
    public boolean searchMatrix0(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int left = 0;
        int right = matrix.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] <= target) left = mid + 1;
            else right = mid;
        }
        int tmp = (right > 0) ? (right - 1) : right;
        left = 0;
        right = matrix[tmp].length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[tmp][mid] == target) return true;
            if (matrix[tmp][mid] < target) left = mid + 1;
            else right = mid;
        }
        return false;
    }

    //看成一维数组
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid / n][mid % n] == target) return true;
            if (matrix[mid / n][mid % n] < target) left = mid + 1;
            else right = mid;
        }
        return false;
    }

    //用两个指针
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0, j = (int)matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) --j;
            else ++i;
        }
        return false;
    }

}
