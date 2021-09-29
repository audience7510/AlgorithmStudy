package LeetCode.数组与矩阵.q240_搜索二维矩阵II;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/19
 * @Version 1.0
 * @Description
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //行
        int row = matrix.length;
        //列
        int line = matrix[0].length;
        //索引从0开始
        int i = 0;
        //索引从数组长度减1开始
        int j = line-1;
        while (i<row && j>=0){
            if (target == matrix[i][j]){
                return true;
            }else if (target > matrix[i][j]){
                //如果小于目标值，往右移动
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
