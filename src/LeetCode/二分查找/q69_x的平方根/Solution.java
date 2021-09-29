package LeetCode.二分查找.q69_x的平方根;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/16
 * @Version 1.0
 * @Description
 * 思路：二分查找法，mid乘以mid是否小于等于x，是则暂存一下
 *      当循环退出时，达到最大值
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        int l = 1;
        int r = x;
        int ans = -1;
        while (l <= r){
            int mid = l +(r-l)/2;
            if ((long)mid*mid<=x){
                ans = mid;
                l = mid +1;
            }else {
                r = mid -1;
            }
        }
        return ans;
    }
}
