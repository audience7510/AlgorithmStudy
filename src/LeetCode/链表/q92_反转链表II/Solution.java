package LeetCode.链表.q92_反转链表II;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/9
 * @Version 1.0
 * @Description
 * 思路：1、假设没有left和right，翻转整个链表，是q206这道题
 *      2、假设left=1，是反串前right个元素
 *      3、假设left!=1了，head.next索引作为1，那么相对于head.next，反转的区间是
 *         left-1到right-1(right-1是需要保证二者区间不变)，
 *         对于head.next.next，反转区间是left-2到right-2，以此类推
 *         直到left减为1了，head也移动到了left的位置，因为保持的left到right的区间不变
 *         所以已经变成了情况2
 *
 *      方式2使用迭代：切断left左边得到链表1，切断right右边的链表得到链表2，
 *      同时得到left到right的链表3，
 *      翻转链表3，再拼接到链表1和2中间
 */
public class Solution {
    /**
     * 递归方式
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            //此方法是翻转前n个节点
            return reverseN(head,right);
        }
        // 12345
        //left不断减1，直到head移动到left的位置，即left=1了，相当于翻转前n个节点
        //用head.next指向翻转后的节点
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }

    //用于记录递归到right==1 之后的节点
    ListNode res = null;
    private ListNode reverseN(ListNode head, int right) {
        if (right == 1){
            res = head.next;
            return head;
        }
        ListNode listNode = reverseN(head.next, right - 1);
        //翻转
        head.next.next = head;
        //翻转之后，拼接上right==1 之后的节点
        head.next = res;
        return listNode;
    }

    /**
     * 迭代方式
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        //创建虚拟头节点
        ListNode dHead = new ListNode(-1);
        dHead.next = head;
        //创建用于遍历的节点
        ListNode cur = dHead;

        //遍历得到left前一个节点，因为在切断的时候，前一个的next刚好left节点
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }

        //用一个新变量 遍历得到right节点
        ListNode rightNode = cur;
        //为什么是right - left + 1，假设12345，翻转left=3 right=4
        //那么现在cur在位置2，right - left + 1=2，遍历rightNode之后在位置4
        //遍历结束，此时rightNode就是right节点
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        //切断链表，切成三段
        //得到345
        ListNode leftNode = cur.next;
        //得到5，rightNode是由cur赋值，所以leftNode就被分割为34
        ListNode last = rightNode.next;
        cur.next = null;
        rightNode.next = null;
        //切完之后，得到cur、leftNode、last三段链表，leftNode是需要翻转的链表
        //翻转leftNode，得到43
        reverseN2(leftNode);

        //翻转之后再拼接 12435
        //rightNode是4，所以拼接到cur后面
        cur.next = rightNode;
        //leftNode是43，last是5，所以把5拼到43后面
        leftNode.next = last;
        return dHead.next;
    }

    private void reverseN2(ListNode leftNode) {
        ListNode pre = null;
        ListNode cur = leftNode;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }
}
