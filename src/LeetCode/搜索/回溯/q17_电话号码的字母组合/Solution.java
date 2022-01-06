package LeetCode.搜索.回溯.q17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author audience7510
 * @Date 2022/1/6
 * @Description
 * 思路：回溯，map中定义数字字符与字符串，通过遍历digits，得到map中的字符串，运用回溯模板
 *      当digits的索引与digits长度相等时，加入集合
 *      注意 1要定义map，2加入集合的时机
 */
public class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits ==null || digits.length()==0){
            return list;
        }
        Map<Character,String> map = new HashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        back(digits,map,list,0,new StringBuilder());
        return list;
    }

    private static void back(String digits, Map<Character, String> map, List<String> list,int index,StringBuilder sb) {
        //digits的长度，组合字符串的长度，即输入"23"，组合字符串长度为2，输入"456"，组合字符串长度为3
        if (index == digits.length()){
            list.add(sb.toString());
        }else {
            char c = digits.charAt(index);
            String s = map.get(c);
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                back(digits,map,list,index+1,sb);
                //回溯完成之后删除，删除索引为index的，其实index就是最后一位，也可以写成下面这种方式
                //sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(index);

            }
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
