class DisjointSet {
    private int[] parent;
    private int[] rank;
    int extras;
    int components;

    public DisjointSet(int n) {
        this.extras = 0;
        this.components = n; 
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findP(int u) {
        if (u == parent[u]) return u;
        return parent[u] = findP(parent[u]); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findP(u);
        int ulp_v = findP(v);

        if (ulp_u == ulp_v) {
            extras++;
            return;
        }

        components--;

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {

        DisjointSet ds = new DisjointSet(n);
        for(int[] edge : connections){
            ds.unionByRank(edge[0],edge[1]);
        }

        
        int edgesNeeded = ds.components - 1;

        return ds.extras >= edgesNeeded ? edgesNeeded : -1;


        
    }
}