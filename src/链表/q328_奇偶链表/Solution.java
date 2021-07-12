package 链表.q328_奇偶链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：第一个节点作为奇数节点，第二个节点作为偶数节点，遍历奇数节点相连，偶数节点相连，
 *      最后奇数节点的最后一位指向偶数节点的头节点，并且需要一个临时变量存储偶数节点的头节点
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        //奇数节点的头节点
        ListNode node1 = head;
        //偶数节点的头节点
        ListNode node2 = head.next;
        //保存偶数节点的头节点
        ListNode temp = head.next;
        while (node2!=null && node2.next!=null){
            //奇数节点相连
            node1.next = node1.next.next;
            //奇数节点后移
            node1 = node1.next;
            //偶数节点相连
            node2 = node2.next.next;
            //偶数节点后移
            node2 = node2.next;
        }
        //奇数节点末尾next指向偶数节点的头节点
        node1.next = temp;
        return head;
    }
}
