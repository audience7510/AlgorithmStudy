package LeetCode.字符串.q14_最长公共前缀;

/**
 * @ClassName Solution
 * @Author audience7510
 * @Date 2022/1/5
 * @Description
 * 思路：纵向扫描，取出第一个字符串遍历，然后for循环嵌套，遍历数组中剩下的字符串
 *      判断外层循环i位置的字符，与内层循环j位置字符串的i位置字符是否相等，
 *      或者外层遍历长度与内层字符串长度相同，则截取第一个字符串的(0,i)
 *      时间复杂度O(mn)，空间复杂度O(1)
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs[0].length() ==0){
            return "";
        }
        //String数组中的第一个字符串长度
        int length = strs[0].length();
        //String数组字符串的个数
        int size = strs.length;
        //遍历第一个字符串
        for (int i = 0; i < length; i++) {
            //拿到字符
            char c = strs[0].charAt(i);
            //从第二个开始遍历所有的字符串
            for (int j = 1; j < size; j++) {
                //第一个字符串遍历到的长度i，与后面的字符串长度相等了，说明后面的字符串长度为i，再往后就没有公共部分了
                //或者第一个字符串i位置的字符，与后面的字符串i位置的字符不相等
                //截取0到i即为最长公共前缀
                if (i == strs[j].length() || c != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        //若没数显上述情况，那么第一个字符就是最长公共前缀
        return strs[0];
    }
}
