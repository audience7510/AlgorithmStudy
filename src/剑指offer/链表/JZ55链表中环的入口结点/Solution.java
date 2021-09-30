package 剑指offer.链表.JZ55链表中环的入口结点;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/30
 * @Version 1.0
 * @Description
 */
public class Solution {
    /**
     * @Date 2021/9/30
     * @Param [pHead]
     * @return
     * @Description 牛客网通过用例五组
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while (slow!=fast){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast;
    }
}
