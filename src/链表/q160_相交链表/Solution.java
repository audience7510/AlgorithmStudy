package 链表.q160_相交链表;

/**
 * @ClassName Program
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
 *      同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。
 *      这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //存储一下头节点，因为头节点还需要第二次使用
        ListNode la = headA;
        ListNode lb = headB;

        //循环判断两节点是否相等
        while (la!=lb){
            //la是否遍历到了末尾，是则再从B链表头开始遍历
            la = (la == null) ? headB : la.next;
            //lb是否遍历到了末尾，是则再从A链表头开始遍历
            lb = (lb == null) ? headA : lb.next;
        }
        return la;
    }
}
