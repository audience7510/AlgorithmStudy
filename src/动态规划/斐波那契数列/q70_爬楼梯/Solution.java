package 动态规划.斐波那契数列.q70_爬楼梯;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/16
 * @Version 1.0
 * @Description
 * 思路：第n个楼梯，可以从第n-1和n-2的楼梯一步到达，走到n其实是
 *      走到n-1和走到n-2的和
 */
public class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        if (n ==1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
