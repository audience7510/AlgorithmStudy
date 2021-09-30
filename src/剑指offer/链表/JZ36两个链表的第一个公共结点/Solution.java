package 剑指offer.链表.JZ36两个链表的第一个公共结点;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/30
 * @Version 1.0
 * @Description
 */
public class Solution {
    /**
     * @Date 2021/9/30
     * @Param [pHead1, pHead2]
     * @return
     * @Description 使用if判断形式
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode h1 = pHead1;
        ListNode h2 = pHead2;
        while (pHead1!=pHead2){
            //使用if判断形式
            if (pHead1!=null){
                pHead1 = pHead1.next;
            }else {
                pHead1 = h2;
            }

            if (pHead2!=null){
                pHead2 = pHead2.next;
            }else {
                pHead2 = h1;
            }
        }
        return pHead1;
    }

    /**
     * @Date 2021/9/30
     * @Param [pHead1, pHead2]
     * @return
     * @Description 使用三元表达式
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode h1 = pHead1;
        ListNode h2 = pHead2;
        while (pHead1!=pHead2){
            pHead1 = (pHead1 == null) ? h2:pHead1.next;
            pHead2 = (pHead2 == null) ? h1:pHead2.next;
        }
        return pHead1;
    }
}
