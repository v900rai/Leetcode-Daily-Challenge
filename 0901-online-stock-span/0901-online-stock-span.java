import java.util.Stack;

class StockSpanner {

    // Stack store करेगा pair: [price, span]
    Stack<int[]> stack;

    // Constructor
    public StockSpanner() {
        // Stack initialize कर रहे हैं
        stack = new Stack<>();
    }
    
    // यह method हर नए price के लिए span return करेगा
    public int next(int price) {

        // कम से कम span हमेशा 1 होगा (आज का दिन)
        int span = 1;

        // जब तक stack empty नहीं है
        // और stack का top price current price से छोटा या बराबर है
        while (!stack.isEmpty() && stack.peek()[0] <= price) {

            // पिछले span को add कर दो
            span += stack.peek()[1];

            // उस element को remove कर दो
            stack.pop();
        }

        // current price और उसका span stack में push करो
        stack.push(new int[]{price, span});

        // final span return करो
        return span;
    }
}