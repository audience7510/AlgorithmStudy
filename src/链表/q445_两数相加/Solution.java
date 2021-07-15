package 链表.q445_两数相加;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：不能修改原始链表
 *      1、将两个链表压入栈中
 *      2、while循环判断栈是否为空，并弹栈
 *      3、弹栈的数字相加sum，创建链表，sum%10，与10取余得到该链表
 *      4、将该链表放到链表前，并将head赋值为该链表
 *      5、定义一个int 保存sum/10 进一位
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //将两个链表值压入栈中
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        //用于保存满十进一
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0){
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            //这里要加上满十进一
            int sum = x + y + carry;
            ListNode node = new ListNode(sum%10);
            //个位靠右，十位、百位、千位依次往左
            //所以先把head.next赋给node，因为node是从个位 往十位、百位变化的
            //低位拼接到高位后面
            node.next = head.next;
            //高位拼接到头节点后
            head.next = node;
            //保存满十进一
            carry = sum/10;
        }
        return head.next;
    }

    //将链表值压入栈中
    public Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack();
        while (l != null){
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
