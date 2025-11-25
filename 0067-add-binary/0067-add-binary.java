class Solution {
    public String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();

        int i = a.length() - 1; // last index of a
        int j = b.length() - 1; // last index of b
        int carry = 0;

        while(i >= 0 || j >= 0){  // jab tak dono complete na ho jaye
            int sum = carry;     // start sum with carry

            if(i >= 0)
                sum += a.charAt(i--) - '0'; // char ko number me convert
            if(j >= 0)
                sum += b.charAt(j--) - '0';

            carry = sum > 1 ? 1 : 0; // agar sum 2 or 3 ho → carry = 1

            res.append(sum % 2); // 0 ya 1 add hoga
        }

        if(carry != 0)
            res.append(carry); // last me carry bach jaye to add

        return res.reverse().toString(); // because LSB se add kiya
    }
}
