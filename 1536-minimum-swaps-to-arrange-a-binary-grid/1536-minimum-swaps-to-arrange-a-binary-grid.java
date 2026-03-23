/*
    Problem Statement:
    -----------------
    We are given an n × n binary grid.

    We are allowed to swap adjacent rows.
    Our goal is to make the grid valid such that:

        For every row i,
        the number of trailing zeros in that row
        must be at least (n - 1 - i).

    If it is impossible, return -1.
    Otherwise, return the minimum number of adjacent row swaps.


    Understanding the Requirement:
    ------------------------------
    In a valid grid:

        Row 0 must have at least (n-1) trailing zeros.
        Row 1 must have at least (n-2) trailing zeros.
        Row 2 must have at least (n-3) trailing zeros.
        ...
        Row n-1 must have at least 0 trailing zeros.

    Why?

        Because in a valid configuration,
        all 1s must lie on or below the main diagonal.

    So effectively:
        Each row must have enough trailing zeros
        to "push" its rightmost 1 to the left of the diagonal.


    Step 1 — Preprocessing:
    -----------------------
    For each row:
        Count trailing zeros.

    We do this by scanning from right to left
    until we encounter the first 1.

    If the rightmost 1 is at column col,
        trailing zeros = n - col - 1.

    Store these values in an array arr[].


    Step 2 — Greedy Strategy:
    -------------------------
    We process rows from top to bottom.

    For each position i:
        Required trailing zeros = (n - 1 - i).

    We search downward from row i
    to find the first row whose trailing zeros ≥ required.

    If no such row exists → return -1.


    Step 3 — Row Swapping Logic:
    ----------------------------
    Once we find a suitable row at index idx:

        We need to bring it to position i.

    Since only adjacent swaps are allowed:
        Number of swaps required = idx - i.

    We simulate the row movement by:
        - Storing arr[idx]
        - Shifting all elements between i and idx upward
        - Placing selected row at position i

    This mimics bubbling the row upward.


    Why Greedy Works:
    -----------------
    At each position i,
    we choose the nearest row that satisfies the condition.

    This is optimal because:
        - Bringing a farther row would increase swaps.
        - Bringing a nearer row never blocks future feasibility,
            since remaining rows still keep their order.


    Complexity Analysis:
    --------------------
    Counting trailing zeros:
        O(n^2)

    For each row:
        Worst case we scan remaining rows → O(n)

    Total worst-case time:
        O(n^2)

    Space complexity:
        O(n)  (for trailing zero array)

    This is efficient for constraints (n ≤ 200).


    When Do We Return -1?
    ---------------------
    If at some position i,
    no row below satisfies required trailing zeros,
    then arrangement is impossible.
*/

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length ;
        int[] arr = new int[n] ;
        for(int row = 0 ; row < n ; row ++)
        {
            int col = n - 1 ;

            while(col >= 0 && grid[row][col] != 1) 
            col -- ;

            arr[row] = n - col - 1 ;
        }

        //print(arr) ;

        int count = 0 ;

        for(int i = 0 ; i < n ; i ++)
        {
            int need = n - 1 - i ;

            int idx = i ;

            while(idx < n && arr[idx] < need) idx ++ ;

            if(idx == n) return -1 ;

            int ans = arr[idx] ;

            for(int j = idx ; j > i ; j --)
            {
                arr[j] = arr[j-1] ;
            }

            arr[i] = ans ;

            count += idx - i ;
        }

        return count ;
        
    }

    void print(int[] arr)
    {
        for(int a : arr)
        {
            System.out.print(a + " ") ;
        }

        System.out.println() ;
    }
}