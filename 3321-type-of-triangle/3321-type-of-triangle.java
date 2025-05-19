class Solution {
    public String triangleType(int[] nums) {
        // First, check if the given sides can form a valid triangle using triangle inequality theorem
        // The sum of any two sides must be greater than the third
        if (nums[0] + nums[1] > nums[2] &&
            nums[1] + nums[2] > nums[0] &&
            nums[2] + nums[0] > nums[1]) {

            // If all three sides are equal, it's an equilateral triangle
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return "equilateral";
            }

            // If all three sides are different, it's a scalene triangle
            else if (nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]) {
                return "scalene";
            }

            // If any two sides are equal, it's an isosceles triangle
            else if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) {
                return "isosceles";
            }
        }

        // If it doesn't satisfy the triangle inequality, it's not a triangle
        return "none";
    }
}
