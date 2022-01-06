package LeetCode.搜索.回溯.q22_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience7510
 * @Date 2022/1/6
 * @Description
 * 思路：回溯，方法传入左右括号的数量，左括号小于n，回溯，右括号小于n，回溯
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        //注意传入左右括号的数量
        backtrack(n,list,0,0,new StringBuilder());
        return list;
    }

    private void backtrack(int n, List<String> list, int open, int close, StringBuilder stringBuilder) {
        //当拼接的左右括号为n的2倍时，加入集合
        if (stringBuilder.length() == n*2){
            list.add(stringBuilder.toString());
        }
        //左括号不够n个回溯
        if (open<n){
            stringBuilder.append('(');
            backtrack(n,list,open+1,close,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        //右括号不够n个回溯
        if (close<open){
            stringBuilder.append(')');
            backtrack(n,list,open,close+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
