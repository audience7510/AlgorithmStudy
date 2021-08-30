package 双指针.q349_两个数组的交集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/26
 * @Version 1.0
 * @Description
 * 思路：双指针+set集合
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i<nums1.length && j<nums2.length){
            //谁小谁的索引增大
            if (nums1[i]>nums2[j]){
                j++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else {
                //相等时加入set集合，保证唯一
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        //最后把set集合数据放到数组中
        int[] arr = new int[set.size()];
        int n = 0;
        for (Integer integer : set) {
            arr[n++] = integer;
        }
        return arr;
    }
}
