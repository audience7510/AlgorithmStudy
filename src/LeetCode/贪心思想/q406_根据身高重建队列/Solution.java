package LeetCode.贪心思想.q406_根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路；(h,k) h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高
 */
public class Solution {
    public static int[][] reconstructQueue(int[][] people) {
        //根据身高h降序排序，个数k升序(身高越低，排在前面比他高的越多)
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                //身高是否相等，相等，根据k升序排，不相等，根据身高降序排
                return (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            }
        });
        List<int[]> list = new ArrayList<>();
        //遍历数组
        for (int[] person : people) {
            //根据人数插入集合，前面有0和，插入集合索引0处
            //前面有2个，插入集合索引2处，如果此处有值，根据list集合的特点，那么会向后移动
            list.add(person[1],person);
        }
        //将集合转成二维数组
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int [][] arr ={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(arr);
    }
}
