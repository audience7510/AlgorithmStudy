package 链表.q206_翻转链表;

/**
 * @ClassName Solution1
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：使用递归，获取到最后一个节点，最后一个节点的next指向前一个节点，
 *      前一个节点的next置为null
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        //递归到末尾时，方法出栈
        ListNode listNode = reverseList(head.next);
        //此时head.next是最后一个链表，最后一个的下一个，指向前一个
        head.next.next = head;
        //断开前一个与最后一个的引用
        head.next = null;
        return listNode;
    }
}
