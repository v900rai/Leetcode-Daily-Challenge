class Solution {
    public int findDuplicate(int[] nums) {
      HashSet<Integer> has=new HashSet<>();
      for(int  num : nums){
        if(has.contains(num)){
          return num;
        }
        has.add(num);
      }
      return -1;
        
    }
}