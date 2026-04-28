class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       
        Set<Integer> numsSett =new HashSet<>();
        for(int num : nums){
          numsSett.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=nums.length; i++){
          if(!numsSett.contains(i)){
            result.add(i);
          }
        }
        return result;
    }
}