package LeetCode.双指针.q167_两数之和II_输入有序数组;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/12
 * @Version 1.0
 * @Description
 * 思路：使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。
 *      指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null){
            return numbers;
        }
        //数组开始索引
        int i = 0;
        //数组末尾索引
        int j = numbers.length-1;
        while (i < j){
            int sum = numbers[i]+numbers[j];
            //相等返回
            if (sum == target){
                return new int[]{i+1,j+1};
            }else if (sum < target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }
}
