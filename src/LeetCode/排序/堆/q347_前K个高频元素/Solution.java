package LeetCode.排序.堆.q347_前K个高频元素;

import java.util.*;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/14
 * @Version 1.0
 * @Description
 * 思路：小顶堆，map存储元素和出现的次数，然后遍历map，如果小顶堆size小于k，
 *      那么继续添加元素，如果遍历出来的次数，大于小顶堆最小的次数，移除小顶堆最小的，
 *      并加入遍历出来的
 */
public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            //getOrDefault，获取到，出现次数加1，获取不到出现次数0+1=1
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for (Integer key : map.keySet()) {
            if (priorityQueue.size()<k){
                //小于k，加到小顶堆中
                priorityQueue.add(key);
            }else if (map.get(key)>map.get(priorityQueue.peek())){
                //如果遍历出来的key，map.get(key)，得到次数，大于小顶堆中的，移除小顶堆中的一个元素
                priorityQueue.remove();
                //移除后加入遍历的
                priorityQueue.add(key);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            list.add(priorityQueue.poll());
        }
        //若严格按照力扣返回int数组，那么翻转集合，并转为数组
        Collections.reverse(list);
        int[] s = list.stream().mapToInt(Integer::valueOf).toArray();
        return s;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,2,2,3};
        int[] ints = topKFrequent(arr, 2);
    }
}
