class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 0) return nums; // यदि array खाली है, तो उसे 그대로 return करें
        
        QuickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void QuickSort(int[] nums, int start, int end) {
        if (start >= end) return; // Base Case: यदि start index, end से बड़ा या बराबर हो जाए, तो return करें
        
        int pivot = nums[(start + end) / 2]; // मध्य तत्व को pivot चुनते हैं
        int left = start, right = end;

        while (left <= right) {
            // Left pointer को तब तक बढ़ाएँ जब तक हमें pivot से बड़ा तत्व ना मिले
            while (nums[left] < pivot) left++;

            // Right pointer को तब तक घटाएँ जब तक हमें pivot से छोटा तत्व ना मिले
            while (nums[right] > pivot) right--;
            
            if (left <= right) { // यदि left <= right, तो swap करें
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
        
        // अब, दो भागों में QuickSort को लागू करें
        QuickSort(nums, start, right); // Left part
        QuickSort(nums, left, end); // Right part
    }
}
