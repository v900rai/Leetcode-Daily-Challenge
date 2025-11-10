class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int count = 0;

        for(int num : nums) {
            while(!st.isEmpty() && st.peek() > num) {
                // removing larger elements in the middle
                st.pop();
            }

            if(st.isEmpty() || st.peek() < num) {
                // [0,1]
                if(num!=0)
                    count++; // current larger element would require operations
                st.push(num);
            }
        }
 
        return count;
    }
}