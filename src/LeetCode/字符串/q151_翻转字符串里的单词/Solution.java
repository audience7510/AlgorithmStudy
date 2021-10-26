package LeetCode.字符串.q151_翻转字符串里的单词;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/15
 * @Version 1.0
 * @Description
 * 思路：双端队列，字符头尾去空格，遍历字符，拼接字符，遇到空格则之前拼接的字符为一个单词，
 *      将单词加入到双向队列的头，实现翻转
 */
public class Solution {

    public String reverseWords(String s) {
        int left = 0;
        int right = s.length()-1;
        //去除开头空格
        while (left<=right && s.charAt(left)== ' '){
            left++;
        }

        //去除末尾空格
        while (left<=right && s.charAt(right)== ' '){
            right--;
        }
        //创建双向队列
        Deque<String> deque = new ArrayDeque();
        StringBuilder word = new StringBuilder();

        while (left<=right){
            char c = s.charAt(left);
            //如果word长度不为空，说明已经拼接过字符了，并且又遇到了空格，说明word已经是一个单词了
            if (word.length()!=0 && c==' '){
                //将单词加入到队列头
                deque.offerFirst(word.toString());
                //将StringBuilder长度置为0
                word.setLength(0);
            }else if (c!=' '){
                //其他情况，将字符拼接到StringBuilder后
                word.append(c);
            }
            //右移
            left++;
        }
        //遍历结束，将最后一个单词放入队列头
        deque.offerFirst(word.toString());
        //join方法给队列里的单词中间拼接上空格
        return String.join(" ",deque);
    }

    /**
     * @Date 2021/10/26
     * @Param [s]
     * @return
     * @Description String方法
     */
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = split.length-1; i >=0; i--) {
            if (split[i].length()>0){
                sb.append(split[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
