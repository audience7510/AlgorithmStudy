package 剑指offer.链表.JZ16合并两个排序的链表;

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
     * @Param [list1, list2]
     * @return
     * @Description 递归方式
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val<list2.val){
            ListNode node = Merge(list1.next,list2);
            list1.next = node;
            return list1;
        }else {
            ListNode node = Merge(list1,list2.next);
            list2.next = node;
            return list2;
        }
    }
}
