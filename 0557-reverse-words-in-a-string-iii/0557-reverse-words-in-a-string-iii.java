class Solution {

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int l = 0, n = arr.length;

        for (int r = 0; r <= n; r++) {
            if (r == n || arr[r] == ' ') {
                reverse(arr, l, r - 1);
                l = r + 1;
            }
        }

        return new String(arr);
    }
}