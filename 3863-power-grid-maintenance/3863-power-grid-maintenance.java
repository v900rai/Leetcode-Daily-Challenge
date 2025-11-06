class Solution {
    public void dfs(int x, List<List<Integer>> adj, boolean[] vis,
    TreeSet<Integer> set, HashMap<Integer,Integer> mapping, int setNo) {
        vis[x] = true;
        set.add(x);
        mapping.put(x,setNo);
        for(int i=0;i<adj.get(x).size();i++) {
            int cur = adj.get(x).get(i);
            if(vis[cur] == false) {
                dfs(cur, adj, vis,set,mapping, setNo);
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=c;i++) adj.add(new ArrayList<>());
        for(int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }
        boolean[] vis = new boolean[c+1];
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        HashMap<Integer,Integer> mapping = new HashMap<>();
        int setNo = 1;
        for(int i=1;i<=c;i++) {
            if(vis[i] == false) {
                TreeSet<Integer> set = new TreeSet<>();
                dfs(i, adj, vis,set,mapping, setNo);
                map.put(setNo,set);
                setNo++;
            }
        }
        boolean[] online = new boolean[c+1];
        Arrays.fill(online,true);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++) {
            int type = queries[i][0];
            int x = queries[i][1];
            if(type == 1) {
                if(online[x] == true) {
                    ans.add(x);
                } else {
                    setNo = mapping.get(x);
                    TreeSet<Integer> set = map.get(setNo);
                    if(set.isEmpty())
                        ans.add(-1);
                    else
                        ans.add(set.first());
                }
            } else {
                online[x] = false;
                setNo = mapping.get(x);
                TreeSet<Integer> set = map.get(setNo);
                set.remove(x);
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i] = ans.get(i);
        return res;
    }
}