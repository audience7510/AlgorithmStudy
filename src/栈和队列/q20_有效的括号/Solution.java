package 栈和队列.q20_有效的括号;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/12
 * @Version 1.0
 * @Description
 * 思路：遍历字符串，三种括号，左半部分入栈，遍历到右半部分
 *      后进先出，出栈判断是否对称
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                //左半部分入栈
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                //右半部分出栈，并挨个判断
                Character pop = stack.pop();
                if (c == ')'){
                    if (pop!='('){
                        return false;
                    }
                }else if (c == ']'){
                    if (pop!='['){
                        return false;
                    }
                }else {
                    if (pop!= '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
