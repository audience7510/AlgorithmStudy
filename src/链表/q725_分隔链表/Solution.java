package 链表.q725_分隔链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：遍历链表，获取长度length。length除以K，得到链表的平均长度m和余数n。
 *      余数n就是有n个(m+1)长度的子链表排在前面。
 */
public class Solution {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        //遍历链表拿到长度
        int length = 0;
        ListNode temp = head;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        //分隔k段，每段有m个节点
        int m = length / k;
        //前n段有m+1个节点
        int n = length % k;
        //定义数组
        ListNode[] nodes = new ListNode[k];
        //当前节点
        ListNode cur = head;
        //遍历赋值
        for (int i = 0; i < k && cur!=null; i++) {
            nodes[i] = cur;
            //前n段，m+1个节点
            int size = m + (n-- > 0 ? 1:0);
            //节点后移
            for (int j = 0; j < size-1; j++) {
                cur = cur.next;
            }
            //移动完毕之后，暂存一下cur.next
            ListNode next = cur.next;
            //切断
            cur.next = null;
            //重新将cur.next赋值给cur，进行下次遍历
            cur = next;
        }
        return nodes;
    }

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        listNode0.next = listNode1;
        ListNode[] nodes = splitListToParts(listNode0, 4);
        System.out.println();
    }
}
