class Solution {
    private static class Ev {
        String type;
        int time;
        String data; // for OFFLINE it's the user id, for MESSAGE it's the mention string
        Ev(String type, int time, String data) {
            this.type = type;
            this.time = time;
            this.data = data;
        }
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers]; // 0 means online, otherwise time when user becomes online again

        // Build event objects
        List<Ev> evs = new ArrayList<>();
        for (List<String> e : events) {
            String type = e.get(0);
            int t = Integer.parseInt(e.get(1));
            String d = e.get(2);
            evs.add(new Ev(type, t, d));
        }

        // Sort by timestamp ascending. For same timestamp, OFFLINE before MESSAGE
        evs.sort((a, b) -> {
            if (a.time != b.time) return Integer.compare(a.time, b.time);
            if (a.type.equals(b.type)) return 0;
            // OFFLINE should come before MESSAGE
            if (a.type.equals("OFFLINE")) return -1;
            return 1;
        });

        // Process events in sorted order
        for (Ev e : evs) {
            int t = e.time;

            // First, bring back online any users whose offlineUntil <= t
            for (int u = 0; u < numberOfUsers; u++) {
                if (offlineUntil[u] > 0 && offlineUntil[u] <= t) {
                    offlineUntil[u] = 0;
                }
            }

            if (e.type.equals("OFFLINE")) {
                int uid = Integer.parseInt(e.data);
                // user becomes offline immediately and will be online at t + 60
                offlineUntil[uid] = t + 60;
            } else { // MESSAGE
                String mentionString = e.data;
                if (mentionString.equals("ALL")) {
                    for (int u = 0; u < numberOfUsers; u++) mentions[u]++;
                } else if (mentionString.equals("HERE")) {
                    for (int u = 0; u < numberOfUsers; u++) {
                        if (offlineUntil[u] == 0) mentions[u]++;
                    }
                } else {
                    // explicit ids separated by single spaces, may contain duplicates
                    String[] tokens = mentionString.split(" ");
                    for (String tok : tokens) {
                        if (tok.startsWith("id")) {
                            int id = Integer.parseInt(tok.substring(2));
                            mentions[id]++; // count even if offline
                        }
                    }
                }
            }
        }

        return mentions;
    }
}