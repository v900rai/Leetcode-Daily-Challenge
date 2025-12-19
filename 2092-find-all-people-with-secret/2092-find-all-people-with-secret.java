class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] m : meetings) {
            adj[m[0]].add(new int[]{m[1], m[2]});
            adj[m[1]].add(new int[]{m[0], m[2]});
        }

        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{firstPerson, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int person = cur[0];
            int time = cur[1];

            if (time > earliest[person]) continue;

            for (int[] nei : adj[person]) {
                int next = nei[0];
                int t = nei[1];

                if (t >= time && t < earliest[next]) {
                    earliest[next] = t;
                    pq.offer(new int[]{next, t});
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliest[i] != Integer.MAX_VALUE) {
                res.add(i);
            }
        }
        return res;
    }
}