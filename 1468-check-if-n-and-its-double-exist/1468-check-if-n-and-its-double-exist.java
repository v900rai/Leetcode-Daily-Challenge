class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer > set=new HashSet<>();
        for(int nums : arr){
            if(set.contains(nums*2)|| (nums%2==0 &&set.contains(nums/ 2))){
                return true;

            }
            set.add(nums);
        }
        return false;
        
    }
}