class Solution {
    public int maxNumberOfBalloons(String text) 
    {
        int freq[]=new int[26];
        for(int i=0;i<text.length();i++)
        {
            freq[text.charAt(i)-97]++;
        }
        return Math.min(Math.min(freq['b'-97],freq['a'-97]),Math.min(Math.min(freq['l'-97]/2,freq['o'-97]/2),freq['n'-97]));
    }
}