class Solution {
    public int maxPower(String s) {
		int max = 1;
    int  len = 1;
		for (int i = 1; i < s.length(); i++) {

			if (s.charAt(i - 1) == s.charAt(i)) {
				len++;
			} else {
				if (max < len) {
					max = len;
				}
				len = 1;
			}
		}
		if (max < len) {
			max = len;
		}

		return max;
        
    }
}