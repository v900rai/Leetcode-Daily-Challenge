class Solution {
    public int maxGoodNumber(int[] nums) {
        String[] binNums=new String[nums.length];

        for(int i=0; i<binNums.length; i++){
            binNums[i]=Integer.toBinaryString(nums[i]);
        }

        Arrays.sort(binNums,(a,b)-> (b+a).compareTo(a+b));

        StringBuilder sb=new StringBuilder();
        for(String bin:binNums){
            sb.append(bin);
        }

        return Integer.parseInt(sb.toString(),2);

    }
}