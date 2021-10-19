package LeetCode.数组与矩阵.q48_旋转图像;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/19
 * @Version 1.0
 * @Description
 * 思路：翻转代替旋转，水平翻转之后再对角线翻转
 *      水平翻转(上下翻转)，matrix[row][col] = matrix[n-row-1][col]，n为matrix.length
 *
 *      对角线翻转(按照左上到右下的对角线翻转)
 *      matrix[row][col] = matrix[col][row]
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //水平翻转
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        //对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
