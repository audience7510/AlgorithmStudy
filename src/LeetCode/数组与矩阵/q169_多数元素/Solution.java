package LeetCode.数组与矩阵.q169_多数元素;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/12
 * @Version 1.0
 * @Description
 */
public class Solution {
    public int majorityElement(int[] nums) {
        //多数元素出现次数(多数元素出现次数，比其他元素多，满足大于n/2)
        int count = 0;
        //多数元素
        Integer temp = null;
        for (int num : nums) {
            //只有第一次遍历，以及num不是多数元素时，count才会为0
            if (count == 0){
                temp = num;
            }
            //相等次数加，不等次数减，最终多数元素的次数肯定大于0
            count += (temp == num)? 1:-1;
        }
        return temp;
    }
}
