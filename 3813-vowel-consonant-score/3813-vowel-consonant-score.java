class Solution {
    public int vowelConsonantScore(String s) {
        int n = s.length();
        int v = 0;
        int c = 0;

        for(int i = 0; i<n; i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur) || cur==' '){
                continue;
            }
            if(cur=='a'|| cur=='e'|| cur=='i'||cur=='o'||cur=='u'){
                v++;
            }else{
                c++;
            }
        }

        if(c>0){
            return (int)Math.floor(v/c);
        }else{
            return 0;
        }
    }
}