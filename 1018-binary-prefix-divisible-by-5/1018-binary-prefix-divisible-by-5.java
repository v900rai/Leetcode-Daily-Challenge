class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {

        List<Boolean> result = new ArrayList<>();
      
        int remainder = 0;
        for(int num : nums){
            remainder = (remainder * 2 + num) % 5;
            if(remainder == 0){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}