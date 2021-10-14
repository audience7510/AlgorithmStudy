package LeetCode.数组与矩阵.q54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/14
 * @Version 1.0
 * @Description
 * 思路：从左到右，再到下，再到左，再到上这样循环遍历
 *      left、right、top、down确定起始点
 *      上边一行，从左到右，这个 "上" 根据top来定，就是行，"左到右" 遍历left到right，就是列
 *
 *      右边一列，从上到下，这个 "右" 根据right来定，就是列，"上到下" 遍历top+1到down，就是行
 *
 *      下边一行，从右到左，这个 "下" 根据down来定，就是行，"右到左" 遍历right-1到left(反向遍历)，就是列
 *
 *      左边一行，从下到上，这个 "左" 根据left来定，就是列，"下到上" 遍历down到top(反向遍历)，就是行
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return list;
        }
        //行
        int rows = matrix.length;
        //列
        int columns = matrix[0].length;
        //左起始
        int left = 0;
        //右起始
        int right = columns-1;
        //上起始
        int top = 0;
        //下起始
        int down = rows-1;
        while (left<=right && top<=down){
            //上边一行，从左到右
            for (int column = left; column <= right; column++) {
                list.add(matrix[top][column]);
            }
            //右边一列，从上到下，第一个节点与从左到右遍历的最后一个节点重复，所以top+1
            for (int row = top+1; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            if (left<right && top<down){
                //下边一行，从右到左。当前遍历第一个节点与从上到下的遍历的最后一个节点重复，所以right-1
                for (int colum = right-1; colum > left; colum--) {
                    list.add(matrix[down][colum]);
                }
                //左边一行，从下到上，这里down不加1的原因是，从右到左没有遍历到left，所以没有重复节点
                for (int row = down; row > top; row--) {
                    list.add(matrix[row][left]);
                }
            }
            //圈收缩
            left++;
            right--;
            top++;
            down--;
        }
        return list;
    }
}
