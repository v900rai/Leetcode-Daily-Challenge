class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap banaya (largest element upar rahe)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // Saare stones heap me daal diye
        for (int a : stones) {
            pq.offer(a);
        }

        // Jab tak 1 se zyada stones hain
        while (pq.size() > 1) {

            // Sabse heavy stone nikala
            int first = pq.poll();

            // Dusra sabse heavy stone nikala
            int second = pq.poll();

            // Dono stones ko smash kiya
            // Agar equal hue → difference 0
            // Agar unequal → heavy - light
            pq.offer(first - second);
        }

        // Last remaining stone ka weight
        return pq.poll();
    }
}
