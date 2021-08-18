package 字符串.q409_最长回文串;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/17
 * @Version 1.0
 * @Description
 * 思路：字符串a出现了n次，如果是偶数，则左右两边各放一半，可以构成回文，
 *      如果是奇数，其中一个放中心，左右两边各放一半，并且奇数 n%2 = 1
 *      最多有一个字符作为回文中心。
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //出现的次数加1
            count[c]++;
        }

        int ans = 0;
        //遍历出现的次数
        for (int i : count) {
            //除以2得到偶数，乘以2两边放的个数一样，那么ans就一直是偶数
            ans += i/2 * 2;
            //如果字符出现次数为奇数，那么ans++，ans就成为奇数
            //后面再出现次数为奇数，ans%2==1，则ans不会不会加1了
            if (i%2 == 1 && ans%2 == 0){
                ans++;
            }

        }
        return ans;
    }
}
