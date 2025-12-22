import java.util.Stack;

class MinStack {

    // Main stack: sabhi elements store karta hai
    private Stack<Integer> stack = new Stack<>();

    // Min stack: har step par minimum element store karta hai
    private Stack<Integer> minStack = new Stack<>();

    // 🔹 Push element into stack
    public void push(int x) {

        // Element ko main stack me push karo
        stack.push(x);

        // Agar minStack empty hai
        // ya current element chhota ya equal hai current min se
        // to minStack me bhi push karo
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // 🔹 Remove top element
    public void pop() {

        // Main stack ka top element nikaalo
        int removed = stack.pop();

        // Agar removed element hi current minimum tha
        // to minStack se bhi pop karo
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // 🔹 Get top element of stack
    public int top() {

        // Stack ka top element return karta hai
        return stack.peek();
    }

    // 🔹 Get minimum element in stack (O(1))
    public int getMin() {

        // Min stack ka top hamesha current minimum hota hai
        return minStack.peek();
    }
}
