package 剑指offer.链表.JZ14链表中倒数最后k个结点;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/30
 * @Version 1.0
 * @Description
 */
public class Solution {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode nodek = pHead;
        //后移k个节点
        for (int i = 0; i < k; i++) {
            if (nodek == null){
                return null;
            }
            nodek = nodek.next;
        }
        ListNode nodeHead = pHead;
        //迭代到nodek为null
        while (nodek!=null){
            nodeHead = nodeHead.next;
            nodek = nodek.next;
        }
        return nodeHead;
    }
}
