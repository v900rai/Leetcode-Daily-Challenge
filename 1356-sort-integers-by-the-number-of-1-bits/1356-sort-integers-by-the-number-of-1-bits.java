class Solution {
    public int[] sortByBits(int[] arr) 
    {
        quickSort(0,arr.length-1,arr);
        return arr;
    }
    public void quickSort(int low, int high, int arr[])
    {
        if(low < high)
        {
            int p = partition(low, high, arr);
            quickSort(low, p - 1, arr);
            quickSort(p+1, high, arr);
        }        
    }
    public int partition(int low, int high, int arr[])
    {
        int pivotIndex = low + (int)(Math.random() * (high - low + 1)), j = low-1, x;
        swap(pivotIndex, high, arr);
        x = arr[high];
        for(int i = low; i < high; i++)
        {
            if(compare(arr[i],x) < 0)
            {
                j++;
                swap(i,j,arr);
            }
        }
        swap(j+1,high,arr);
        return j+1;
    }
    public void swap(int i, int j, int arr[])
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int compare(int a, int b)
    {
        int countA = Integer.bitCount(a), countB = Integer.bitCount(b);
        if(countA == 0 || countB == 0)
            return a - b;            
        if(countA == 1 && countB == 1)
            return (a-b);
        else if(countA == 1)
            return -1;
        else if(countB == 1)
            return 1;
        else
            if(countA == countB)
                return a - b;
            else
                return countA - countB;
    }
}