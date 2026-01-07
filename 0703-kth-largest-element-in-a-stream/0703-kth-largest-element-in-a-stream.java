class KthLargest {

    int[] heap;
    int k;
    int size;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k];
        this.size = 0;
        for(int num: nums) add(num);
    }
    
    public int add(int val) {
        if (size < k) {
            // Heap is not full. Add to end and swim up.
            heap[size] = val;
            siftUp(size);
            size++;
        } else if (val > heap[0]) {
            // Heap is full, but new val is bigger than the smallest (root).
            // Replace root and sink down to correct position.
            heap[0] = val;
            siftDown(0);
        }

        return heap[0];
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[i] < heap[parent]) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void siftDown(int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            // Check if Left Child is smaller
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            // Check if Right Child is smaller than current smallest
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            // If the parent (i) is already the smallest, we are done
            if (smallest == i) {
                break;
            }

            swap(i, smallest);
            i = smallest; // Continue sinking down
        }
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */