package 数组与矩阵.q1_两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/30
 * @Version 1.0
 * @Description
 * 思路：不能使用Arrays.sort()排序和双指针，因为会改变原来数组的索引位置
 *      使用map，key存储数组中的值，value存储该值的索引
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
