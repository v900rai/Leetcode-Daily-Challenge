
class Solution{
public List<String>fizzBuzz(int n){
// Arraylist 
List<String>result=new ArrayList<>();
//traversal full array
for(int i=1;i<=n;i++){
if(i%3==0&&i%5==0){
result.add("FizzBuzz");
}else if(i%3==0){
result.add("Fizz");


}else if(i%5==0){
result.add("Buzz");
}else{
    
result.add(Integer.toString(i));
}
}
return result;
}
}