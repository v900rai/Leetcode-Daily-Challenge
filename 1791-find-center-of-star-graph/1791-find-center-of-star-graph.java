class Solution {
    public int findCenter(int[][] edges) {

        // First edge ke 2 nodes
        int a = edges[0][0]; // 1
        int b = edges[0][1]; // 2

        // Second edge ke 2 nodes
        int c = edges[1][0]; // 2
        int d = edges[1][1]; // 3

        // Agar a dono jagah mil gaya
        if (a == c || a == d) {
            return a;   // a center hai
        }

        // warna b hi center hoga
        return b;
    }
}
