class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int small=Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=1;i<arr.length;i++){
            int diff=arr[i]-arr[i-1];
            if(diff<small){
                small=diff;
            }
        }
        List<List<Integer>> lst=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            int diff=arr[i]-arr[i-1];
            if(diff==small){
                List<Integer> ls=new ArrayList<>();
                ls.add(arr[i-1]);
                ls.add(arr[i]);
                lst.add(new ArrayList<>(ls));
            }
        }
        return lst;
    }
}