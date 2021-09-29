package LeetCode.字符串.q415_字符串相加;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/5
 * @Version 1.0
 * @Description
 * 思路：从后向前遍历，遍历得到的字符转int相加，并加上之前满十进一
 */
public class Solution {
    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0 || add !=0){
            int x = i>=0? num1.charAt(i)-'0' : 0;
            int y = j>=0? num2.charAt(j)-'0' : 0;
            //得到字符的int类型相加，并加上上次遍历满十进一的一个值
            int result = x+y+add;
            //用和取余，得到余数，拼接上sb上，从个位往十位、百位拼接，最后要翻转
            sb.append(result%10);
            //本次遍历满十进一的值
            add = result/10;
            //向前
            i--;
            j--;
        }
        //翻转
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = addStrings("123", "456");
        System.out.println(s);
    }
}
