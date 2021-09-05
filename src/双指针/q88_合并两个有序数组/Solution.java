package 双指针.q88_合并两个有序数组;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/13
 * @Version 1.0
 * @Description
 * 思路：双指针i,j从两个数组的末尾遍历，k为两个数组的索引和
 *      遍历判断两个数组元素的大小，并赋值到k为索引的位置
 *      当遍历结束之后，nums2可能没遍历完，需要再遍历nums2
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        //两个数组的长度和
        int k = m+n-1;
        //从两个数组的末尾开始遍历
        while (i>=0 && j>=0){
            //第一次循环，当nums1中最后一个元素小于nums2中的最后一个元素
            //之后的循环，跟第一次循环同理，从后往前遍历，i和j都比较过之后，比较i-1和j-1，放置的位置就是k-1
            //这样把nums1或者nums2中较大的值放在末尾，避免了nums1在取出之前值被覆盖
            if (nums1[i]<nums2[j]){
                //把nums2最后一个元素放在末尾
                nums1[k--] = nums2[j--];
            }else {
                //第一次循环，当大于时
                //把nums1最后一个元素放在末尾
                nums1[k--] = nums1[i--];
            }
        }
        //当nums1中的元素遍历完之后，即nums1中的值都比nums2中的大，nums1的值都放在了末尾
        //但是nums2还未放到nums1中，所以继续排序nums2
        while (j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}
