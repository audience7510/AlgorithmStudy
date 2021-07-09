package 链表.q25_K个一组翻转链表;

/**
 * @ClassName Program
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：先反转以 head 开头的 k 个元素。
 *      将第 k + 1 个元素作为 head 递归调用 reverseKGroup 函数。
 *      将上述两个过程的结果连接起来。
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        //b节点后移k个
        for (int i = 0; i < k; i++) {
            //不够k个直接返回
            if (b == null){
                return null;
            }
            b = b.next;
        }
        //翻转a到b的元素
        ListNode reverse = reverseA2B(a, b);
        //递归继续遍历翻转
        a.next = reverseKGroup(b,k);
        return reverse;
    }

    private ListNode reverseA2B(ListNode a,ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        while (cur != b){
            ListNode nxt = cur.next;
            //指针翻转
            cur.next = pre;
            //上一个节点后移
            pre = cur;
            //当前节点后移
            cur = nxt;
        }
        return pre;
    }
}
