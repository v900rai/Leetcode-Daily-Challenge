class Solution {
    // public int tribonacci(int n) {
    //   int arr[]={0,1,1};
    //   if(n<=2){
    //     return arr[n]; 
    //   }
    //   for(int i=3; i<=n; i++){
    //     int temp=arr[0]+arr[1]+arr[2];
    //     arr[0]=arr[1];
    //     arr[1]=arr[2];
    //     arr[2]=temp;
    //   }
    //   return arr[2];
        
    // }


   public int tribonacci(int n) {  
    // Base case: If n is 0 or 1, return n directly  
    if (n < 2) return n;  

    // Initialize the first three numbers of the Tribonacci sequence  
    int a = 0, b = 1, c = 1, d;  

    // Iterate while n is greater than 2 (since we already have first three values)
    while (n-- > 2) {  
        // Calculate the next Tribonacci number as the sum of the previous three  
        d = a + b + c;  

        // Shift values to prepare for the next iteration  
        a = b;  // Move b to a  
        b = c;  // Move c to b  
        c = d;  // Move new value d to c  
    }  

    // Return the nth Tribonacci number  
    return c;  
}
}
