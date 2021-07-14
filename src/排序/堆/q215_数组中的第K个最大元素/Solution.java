package 排序.堆.q215_数组中的第K个最大元素;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/14
 * @Version 1.0
 * @Description
 * 思路：使用小顶堆(小顶堆，小值在上) 不断地往小顶堆中插入新元素，当堆中元素的数量大于 k 时，
 *      移除堆顶元素，也就是当前堆中最小的元素，剩下的元素都为当前添加过的元素中最大的 K 个元素
 *      时间复杂度 O(NlogK)，空间复杂度 O(K)
 */
public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        //构造小顶堆
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }


    public static void main(String[] args) {
        int [] arr = {3,2,1,5,6,4};
        int kthLargest = findKthLargest(arr, 2);
    }
}
