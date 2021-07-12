package 链表.q61_旋转链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：先遍历求得链表总长度count，同时将链表首尾相连
 *      再找到原链表的倒数第k+1个节点，该节点的next就是新链表的头结点
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (head.next!=null){
            length++;
            head = head.next;
        }

        return null;
    }
}
