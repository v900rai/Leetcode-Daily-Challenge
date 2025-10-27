class Solution {
    public int numberOfBeams(String[] bank) {
        int prevc = 0;
        int beams = 0;

        for(String rows : bank){
            int currc = 0;

            for(int i = 0; i < rows.length(); i++){
                if(rows.charAt(i) == '1') currc++;
            }

            if(currc > 0){
                beams += prevc * currc;
                prevc = currc;
            }
        }

        return beams;
    }
}