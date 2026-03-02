class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        summ(al,temp,candidates,target,0);
        return al;
    }
    public void summ(List<List<Integer>> al,List<Integer>temp,int[] nums, int target,int i){
        if(i==nums.length){
            if(target==0){
                al.add(new ArrayList<>(temp));
            }
            return;
        }
        if(nums[i]<=target){
            temp.add(nums[i]);
            summ(al,temp,nums,target-nums[i],i);
            temp.remove(temp.size()-1);
        }
        summ(al,temp,nums,target,i+1);
    }

    
}