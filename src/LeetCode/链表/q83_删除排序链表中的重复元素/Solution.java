package LeetCode.链表.q83_删除排序链表中的重复元素;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：递归 比较当head节点和head.next节点的值是否相等，
 *      相等则返回下一个，不相等返回当前
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val){
            return head.next;
        }else {
            return head;
        }
    }
}
