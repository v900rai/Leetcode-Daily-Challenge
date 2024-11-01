class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans=new StringBuilder();
        int count=1;

        //add krna 
        ans.append(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count ++;
            }
            else{
                count=1; 
                //reset krna hoga

            }
            if(count<3){
                ans.append(s.charAt(i));
                //append the character only
            }
        }
        return ans.toString();
    }
}