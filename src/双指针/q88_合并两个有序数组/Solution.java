package 双指针.q88_合并两个有序数组;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/13
 * @Version 1.0
 * @Description
 * 思路：双指针i,j从两个数组的末尾遍历，k为两个数组的索引和
 *      当nums2索引大于等于0时，判断nums1索引和nums2索引小于0，
 *      并且判断两个数组的值大小
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = m -1;
//        int j = n -1;
//        int k = m + n -1;
//        while (i>=0 && j>=0){
//            if (nums1[i]>nums2[j]){
//                nums1[k--] = nums1[i--];
//            }else {
//                nums1[k--] = nums2[j--];
//            }
//        }
//        while (j > 0){
//            nums1[k--] = nums2[j--];
//        }
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            } else if (j < 0) {
                nums1[k--] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
