package 栈和队列.q155_最小栈;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Author audience
 * @Date 2021/8/12
 * @Version 1.0
 * @Description
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        dataStack.add(val);
        min = Math.min(min, val);
        minStack.add(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
