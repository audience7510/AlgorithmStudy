package 链表.q206_翻转链表;

/**
 * @ClassName Solution2
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：使用迭代
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        //上一个节点
        ListNode pre = null;
        //当前节点
        ListNode cur = head;
        while (cur!=null){
            ListNode nxt = cur.next;
            cur.next = pre;
            //上一个节点后移
            pre = cur;
            //当前节点后移
            cur = nxt;
        }
        return pre;
    }
}
