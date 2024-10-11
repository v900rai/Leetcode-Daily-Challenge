class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        PriorityQueue<int[]> occupied = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();

        int targetFriendArrival = times[targetFriend][0];

        Arrays.sort(times, (a,b) -> a[0]- b[0]);

        int chairNo = 0;

        for(int i=0; i<n; i++) {
            int arrival = times[i][0];
            int depart = times[i][1];

            while(!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                free.offer(occupied.poll()[1]);
            }

            if(free.isEmpty()) {
                occupied.offer(new int[]{depart, chairNo});

                if(arrival == targetFriendArrival) {
                    return chairNo;
                }

                chairNo++;
            }

            else{
                int leastchairAvailable = free.poll();
                if(arrival == targetFriendArrival) {
                    return leastchairAvailable;
                }

                occupied.offer(new int[] {depart, leastchairAvailable});
            }
        }

        return -1;
    }
}