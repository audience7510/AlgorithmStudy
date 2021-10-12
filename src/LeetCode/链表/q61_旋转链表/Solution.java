package LeetCode.链表.q61_旋转链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：先遍历求得链表总长度count，同时将链表首尾相连成环
 *      再找到原链表的最后节点，该节点next移动length-(k%length)节点，
 *      断开链表尾结点与头节点相连，该节点就是新链表的头结点
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null||k == 0) {
            return head;
        }

        ListNode first = head;
        ListNode last = null;
        int length = 1;
        //遍历结束，first到尾节点
        while (first.next!=null){
            first = first.next;
            length++;
        }
        //尾结点
        last = first;
        //连接成环
        first.next = head;
        //假设链表为12345，k为2，k%length(2%5)，商0余2，loop为3
        int loop = length-(k%length);
//        int loop = k+1;
        first = head;
        for (int i = 0; i < loop; i++) {
            first = first.next;
            last = last.next;
        }
        last.next = null;
        return first;
    }
}
