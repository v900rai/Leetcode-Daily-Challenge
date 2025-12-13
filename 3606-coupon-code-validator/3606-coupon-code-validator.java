import java.util.regex.Pattern;
import java.util.regex.Matcher;
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<String[]> ans = new ArrayList<>();
        Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
        Pattern x = Pattern.compile("electronics|grocery|pharmacy|restaurant");
        for(int i=0;i<n;i++){
            if(!code[i].isEmpty() && isActive[i] && x.matcher(businessLine[i]).matches() && !p.matcher(code[i]).find()){
                ans.add(new String[]{code[i],businessLine[i]});
            }
        }
        ans.sort((a,b)->{
            if(a[1].equals(b[1])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });
        List<String> ans1 = new ArrayList<>();
        for(String[] str : ans) ans1.add(str[0]);
        return ans1;
    }
}