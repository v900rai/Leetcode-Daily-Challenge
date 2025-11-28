class Solution {
    private int totalComponents = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(adj,0,-1,values,k);
        return totalComponents;
    }

    long dfs(ArrayList<ArrayList<Integer>> adj, int u, int prev,int[] values, int k){
        long sum = values[u];

        for(int v : adj.get(u)){
            if(v != prev) sum += dfs(adj,v,u,values,k);
        }
        if(sum % k ==0) ++totalComponents;

        return sum;
    }
}