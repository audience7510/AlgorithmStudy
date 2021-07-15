package 双指针.q633_平方数之和;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/12
 * @Version 1.0
 * @Description
 * 思路：与q167类似，双指针，一个指针 i 指向开始位置，另一个指针 j 指向c开方的位置
 *      当 i 为0时，如果满足，那么c的开方就是 j 的最大值
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0){
            return false;
        }
        int i = 0;
        int j = (int)Math.sqrt(c);
        while (i <= j){
            int sum = i*i + j*j;
            if (sum == c){
                return true;
            }else if (sum < c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
