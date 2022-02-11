package LeetCode.双指针.q15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/26
 * @Version 1.0
 * @Description
 * 思路：排序+双指针。不重复和为0，数组升序排序，不重复本质是在升序数组中(a<=b<=c)
 *      假设用三重循环，第二重循环元素大于第一重循环，第三重循环元素大于第二重循环
 *      第三重循环可以省略，使用指针，从数组末尾开始枚举，因为abc三者中，c是最大的，
 *      让c在第二重循环的时候，从大到小枚举出来
 *      for循环遍历时，相邻两个相等的要跳过
 *      时间复杂度O(n2)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //升序排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //枚举a
        for (int i = 0; i < n; i++) {
            //相邻两个元素相等跳过
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            //c 对应的初始指针，指向数组的最右端
            int k = n-1;
            //当前a的值，加负号是因为a+b+c=0，那么 -a = b+c
            int target = -nums[i];
            //枚举b
            for (int j = i+1; j < n; j++) {
                //相邻跳过
                if (j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                //保证b在c的左侧，如果相加大于target，k左移
                while (j<k && nums[j]+nums[k]>target){
                    k--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (j == k){
                    break;
                }
                //把相等的加到list中
                if (nums[j]+nums[k] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
