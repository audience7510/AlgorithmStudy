package LeetCode.链表.q82_删除排序链表中的重复元素II;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/17
 * @Version 1.0
 * @Description
 * 思路：与q83_删除排序链表中的重复元素 不同的是，q83留下了一个重复元素，q82没有留下重复元素
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        //如果元素重复
        if (head.val == next.val){
            //找到不重复的next为止
            while (next!=null && head.val == next.val){
                next = next.next;
            }
            //重复的元素不再要了，head赋值为不重复的next
            head = deleteDuplicates(next);
        }else {
            //如果不重复，直接加到head的后面
            head.next = deleteDuplicates(next);
        }
        return head;
    }
}
