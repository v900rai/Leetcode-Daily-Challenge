class Solution {
    public int countPrimeSetBits(int left, int right) {

        int primes=0;

        for(int i=left ; i<=right ;i++){

            int current=i;
            int bit=0;
            int set_bit=0;
            

            while(current>0){

              bit= (current%2);

              if(bit==1){
                set_bit++;
              }

              current/=2;

                

            }

            if(isPrime(set_bit)){
                primes++;
            }

            



        }

        return primes;
        
    }


    public boolean isPrime(int n) {

    if (n <= 1) return false;   // 0 and 1 are not prime

    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            return false;      // found a divisor
        }
    }

    return true;               // no divisors found
}

}