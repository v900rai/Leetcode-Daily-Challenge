class Solution {
    public int numTilePossibilities(String tiles) {
        if(tiles == null) {
            return -1;
        }
        char[] tileArr = tiles.toCharArray();
        Arrays.sort(tileArr);
        return helper(tileArr, new HashSet());
    }
    private int helper(char[] tileArr, Set<Integer> indexes) {
        int result = 0;
        if(indexes.size()>0){
            result++;
        }
        for(int i=0; i<tileArr.length; i++) {
            if(i>0 && tileArr[i-1]== tileArr[i] && !indexes.contains(i-1)){ //check this only if tile[i-1]==tile[i]
                continue;
            }
            if(!indexes.contains(i)) {
                indexes.add(i);
                result += helper(tileArr, indexes);
                indexes.remove(i);
            }
        } 
        return result;
    }
}