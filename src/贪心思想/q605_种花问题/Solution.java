package 贪心思想.q605_种花问题;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路：遍历数组，判断该位置是否为0，并且前、后位置是否是0，如果是则可以种花
 *      数组0索引的pre和末尾索引的next手动置为0
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1){
                continue;
            }
            //判断数组开头，如果是头，那么将pre置为0
            int pre = i ==0 ? 0: flowerbed[i-1];
            //判断数组末尾，如果是末尾，那么将next置为0
            int next = i == flowerbed.length-1 ? 0:flowerbed[i+1];
            //现在是当前索引为0，判断前、后是否为0
            if(pre ==0 && next == 0){
                //前后为0，自增
                count++;
                //将当前位置改为1
                flowerbed[i] = 1;
            }

        }
        return count>=n;
    }
}
