package 链表.q142_环形链表II;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/7
 * @Version 1.0
 * @Description
 * 思路：哈希表，遍历链表，存到map，一旦遇到遍历过的节点，就有环。时间复杂度O(n)，空间复杂度O(n)
 *      快慢指针，快指针一次两步，满指针一次一步，快慢相遇，则有环，
 *      然后新创建一个节点cur，从头节点开始，之后cur和slow慢节点开始遍历，
 *      直到二者相等，就是入环点的位置(原因：1、可以公式推导，2可以画图)
 *      参考链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null){
            slow = slow.next;
            if (fast.next!=null){
                fast = fast.next.next;
            }else {
                return null;
            }
            //有环
            if (fast == slow){
                ListNode cur = head;
                while (cur!=slow){
                    //从头节点 和 快慢指针相遇节点 开始遍历，直到二者相等就是入环位置
                    cur = cur.next;
                    slow = slow.next;

                }
                return cur;
            }
        }
        return null;
    }
}
