class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1; // अंतिम तत्व के लिए -1 होना चाहिए
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i]; // वर्तमान तत्व को सहेजें
            arr[i] = max; // वर्तमान स्थान पर अधिकतम दाएँ तत्व को रखें
            max = Math.max(max, temp); // अधिकतम मान को अपडेट करें
        }
        return arr;
    }
}
