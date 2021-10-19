package LeetCode.二分查找.q744_寻找比目标字母大的最小字母;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/16
 * @Version 1.0
 * @Description
 * 思路：二分查找，进行判断，找到后不返回，继续缩小查找范围
 *      最后返回判断l是否大于数组长度，超过数组长度说明没找到，返回头字符
 */
public class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length-1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (letters[mid] <= target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }

        return l<letters.length? letters[l]:letters[0];
    }

    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        char target = 'j';
        char c = nextGreatestLetter(arr, target);
    }
}
