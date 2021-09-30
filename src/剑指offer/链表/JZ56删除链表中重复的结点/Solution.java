package 剑指offer.链表.JZ56删除链表中重复的结点;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/30
 * @Version 1.0
 * @Description
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode next = pHead.next;
        //先校验重复
        if (next.val == pHead.val){
            //去重
            while (next!=null && next.val == pHead.val){
                next = next.next;
            }
            //不重复的值赋给pHead
            pHead = deleteDuplication(next);
        }else {
            //校验不重复直接加到next
            pHead.next = deleteDuplication(next);
        }
        return pHead;
    }
}
