import java.util.Stack;

class MinStack {

    // Main stack
    Stack<Integer> stack;

    // Stack to store minimum values
    Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        // Push into main stack
        stack.push(val);

        // Push into min stack if:
        // 1. minStack is empty
        // 2. current value <= current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

        // If top element is minimum,
        // remove from minStack also
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        return minStack.peek();
    }
}