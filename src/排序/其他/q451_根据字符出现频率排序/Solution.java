package 排序.其他.q451_根据字符出现频率排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/14
 * @Version 1.0
 * @Description
 * 思路：遍历字符串，用map的key为字符，value为字符出现的次数
 *      然后用一个list的数组，索引为出现的次数，值为集合add字符
 *      那么，索引越大，字符出现的次数约多
 *      最后反向遍历list数组，遍历出来的每一个集合，再进行遍历，遍历的次数为索引的值
 *      然后拼接字符串
 */
public class Solution {
    public String frequencySort(String s) {
        //map存储遍历的字符和出现的次数
        Map<Character,Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c,0)+1;
            map.put(c,count);
        }

        //list数组，索引为出现的次数，值list，并add字符
        //索引越大，出现的次数越多
        List<Character>[] lists = new ArrayList[s.length()+1];
        for (Character c : map.keySet()) {
            Integer i = map.get(c);
            if (lists[i] == null){
                lists[i] = new ArrayList<>();
            }
            lists[i].add(c);
        }

        StringBuilder sb = new StringBuilder();
        //反向遍历数组
        for (int i = lists.length-1; i >= 0; i--) {
            if (lists[i] == null){
                continue;
            }
            //拿到字符
            for (Character character : lists[i]) {
                //再遍历索引次数，即出现的次数
                for (int j = 0; j < i; j++) {
                    sb.append(character);
                }
            }
        }

        return sb.toString();
    }
}
