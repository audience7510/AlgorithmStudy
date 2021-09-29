package LeetCode.栈和队列.q496_下一个更大元素I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/16
 * @Version 1.0
 * @Description
 * 思路：1、暴力匹配时间复杂度O(n^2)
 *      2、单调栈，时间复杂度O(N+M)，nums1和nums2各遍历一次
 *         找到nums2中每个元素右边比自己大的数，存放到map中，键存放本身，
 *         值存放比自己大的数，找不到不存放，然后遍历nums1寻找
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        //遍历nums2
        for (int i = 0; i < len2; i++) {
            //栈顶元素小于nums2遍历的当前元素
            while (!stack.isEmpty()&&stack.peek()<nums2[i]){
                //放入map键值
                map.put(stack.peek(),nums2[i]);
                //栈顶出栈
                stack.pop();
            }
            //nums2元素入栈
            stack.push(nums2[i]);
        }
        int[] num = new int[len1];
        //遍历nums1从map中取值
        for (int i = 0; i < len1; i++) {
            num[i] = map.getOrDefault(nums1[i],-1);
        }
        return num;
    }
}
