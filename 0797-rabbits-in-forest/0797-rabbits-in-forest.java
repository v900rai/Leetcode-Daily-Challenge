class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int ans: answers){
            if(map.getOrDefault(ans,ans)==ans){
                count+=ans+1;
                map.put(ans,0);
            }
            else{
                map.put(ans,map.get(ans)+1);
            }
        }
        return count;
        
    }
}