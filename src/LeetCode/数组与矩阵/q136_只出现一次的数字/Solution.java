package LeetCode.数组与矩阵.q136_只出现一次的数字;

/**
 * @ClassName Solution
 * @Author audience7510
 * @Date 2022/1/4
 * @Description
 * 思路：遍历nums，使用集合存储遍历的数字，加入集合前，判断集合中是否存在该数字，
 *      如果不存在，加入集合，如果存在，从集合中删除。最后集合中剩余的数字就是只出现一次的。
 *      时间复杂度O(n)，空间复杂度O(n)
 *
 *      使用异或运算 ^  时间复杂度O(n)，空间复杂度O(1)
 *      异或运算三个性质：1、任何数和自身做异或运算，结果是0，即 a ^ a = 0;
 *                     2、任何数和0做异或运算，结果是原来的数，即 a ^ 0 = a;
 *                     3、异或运算满足交换律和结合律，即 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }
}
