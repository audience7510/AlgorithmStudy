package LeetCode.链表.q2_两数相加;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：两个链表节点求和，定义int类型k，接收求和的满十进一，
 *      创建root头节点，将求和的值跟10取余，放到root节点的next
 *      头节点后移，两个链表的节点后移
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        int sum = 0;
        while (l1!=null || l2!=null || sum!=0){
            int v1 = l1!=null?l1.val:0;
            int v2 = l2!=null?l2.val:0;
            //求和，并加上了上次求和的满十进一
            int val = v1+v2+sum;
            //满十进一  567 776
            sum = val/10;

            //与10取余得到当前位
            ListNode node = new ListNode(val%10);
            //当前位放到链表后面
            cur.next = node;
            //后移
            cur = node;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        //返回next原因是把第一个0给去掉
        return root.next;
    }
}
