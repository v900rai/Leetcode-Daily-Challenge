import java.util.*;

class Solution {

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        String digits = "123456789";

        // low me kitne digits hain
        int minLength = String.valueOf(low).length();

        // high me kitne digits hain
        int maxLength = String.valueOf(high).length();


        // Number ki length decide karega
        for (int len = minLength; len <= maxLength; len++) {


            // Substring ka starting index
            for (int start = 0; start + len <= 9; start++) {

                // Sequential substring nikalo
                String str = digits.substring(start, start + len);

                // String ko integer me convert karo
                int num = Integer.parseInt(str);


                // Range check
                if (num >= low && num <= high) {

                    ans.add(num);
                }
            }
        }

        return ans;
    }
}