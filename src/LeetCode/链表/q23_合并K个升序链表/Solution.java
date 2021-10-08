package LeetCode.链表.q23_合并K个升序链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/8
 * @Version 1.0
 * @Description
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = merge(lists,0,lists.length-1);
        return listNode;
    }
    //TODO
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r){
            return lists[l];
        }
        if (l>r){
            return null;
        }

        return null;
    }
}
