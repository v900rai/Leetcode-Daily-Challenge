class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();


        Map<Character , Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);


            if(!seen.contains(ch)){
                while(!stack.isEmpty() && ch < stack.peek() && i< map.get(stack.peek())){
                    seen.remove(stack.pop());
                }
                seen.add(ch);
                stack.push(ch);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}