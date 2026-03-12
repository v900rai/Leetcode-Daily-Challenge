
import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++)
                parent[i] = i;
        }

        int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a,int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false;

            if(rank[pa] < rank[pb])
                parent[pa] = pb;
            else if(rank[pb] < rank[pa])
                parent[pb] = pa;
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int low = 0;
        int high = 0;

        for(int[] e : edges)
            high = Math.max(high, e[2] * 2);

        int ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(can(n, edges, k, mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    boolean can(int n, int[][] edges, int k, int X){

        DSU dsu = new DSU(n);

        int used = 0;
        int upgrades = 0;

        List<int[]> optional = new ArrayList<>();

        for(int[] e : edges){

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if(must == 1){

                if(s < X) return false;

                if(!dsu.union(u,v)) return false;

                used++;
            }
            else{
                optional.add(e);
            }
        }

   
        List<int[]> upgrade = new ArrayList<>();

        for(int[] e : optional){

            int s = e[2];

            if(s >= X){
                 if(dsu.union(e[0], e[1]))used++;}
            else if(s * 2 >= X){
                upgrade.add(e);}
        }

    

        for(int[] e : upgrade){
            if(used == n-1) break;

            if(upgrades == k) break;

            if(dsu.union(e[0], e[1])){
                upgrades++;
                used++;
            }
        }

        return used == n-1;
    }
}