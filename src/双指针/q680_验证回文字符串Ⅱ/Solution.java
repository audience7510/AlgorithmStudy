package 双指针.q680_验证回文字符串Ⅱ;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/13
 * @Version 1.0
 * @Description
 * 思路：双指针，开头索引i和结尾索引j，遍历进行判断是否相等，不相等，则i+1，或者j-1
 *      相当于删除该位，再进行遍历
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            //第一次遍历，从头和尾判断是否相等
            if (s.charAt(i) != s.charAt(j)){
                //不相等时，i加一位，或者j减一位，再遍历进行判断是否相等
                return isValid(s,i+1,j)||isValid(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isValid(String s, int i, int j){
        while (i < j){
            if (s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
