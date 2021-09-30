package 剑指offer.链表.JZ3从尾到头打印链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/29
 * @Version 1.0
 * @Description
 */
public class Solution {

    ArrayList<Integer> list = new ArrayList<>();
    Stack<ListNode> stack = new Stack();

    /**
     * @Date 2021/9/30
     * @Param
     * @return
     * @Description 递归写法，牛客网运行会报栈内存溢出
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * @Date 2021/9/30
     * @Param [listNode]
     * @return
     * @Description 栈写法
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        while (listNode!=null){
            stack.push(listNode);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            list.add(pop.val);
        }
        return list;
    }

}
