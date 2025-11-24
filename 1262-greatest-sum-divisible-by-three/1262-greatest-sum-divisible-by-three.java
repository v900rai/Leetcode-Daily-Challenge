class Solution {
    public int maxSumDivThree(int[] nums) {
        
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%3==1){
                list1.add(nums[i]);
            }
            else if(nums[i]%3==2){
                list2.add(nums[i]);
            }
            sum+=nums[i];
        }
        if(sum%3==0)
        return sum;
        Collections.sort(list1);
        Collections.sort(list2);
        if(sum%3==1){
           if(list1.size()>0&&list2.size()>1) {
            sum-=Math.min(list1.get(0),list2.get(0)+list2.get(1));
            }
            else if(list1.size()>0){
                sum-=list1.get(0);
            }
            else{sum-=(list2.get(0)+list2.get(1));}
        }
        else if(sum%3==2){
            if(list2.size()>0 && list1.size()>1){
                sum-=Math.min(list2.get(0),(list1.get(0)+list1.get(1)));
            }
            else if(list2.size()>0){
                sum-=list2.get(0);
            }
            else{
                sum-=(list1.get(0)+list1.get(1));
            }
        }
        return sum;

    }
}