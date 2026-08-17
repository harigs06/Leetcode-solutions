class DisjointSet {
    List<Integer> size;
    List<Integer> rank;
    List<Integer> parent;
    int extras;
    int n;

    // Use n + 1 if you want 1-based indexing support out of the box
    public DisjointSet(int n) {
        extras = 0;
        size = new ArrayList<>();
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        this.n = n;
        
        for (int i = 0; i <= n; i++) {
            size.add(1);
            rank.add(0);
            parent.add(i);
        }
    }

    public int findP(int u) {
        if (u == parent.get(u)) return u;
        parent.set(u, findP(parent.get(u)));
        return parent.get(u);
    }

    public boolean find(int u, int v) {
        return findP(u) == findP(v);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findP(u);
        int ulp_v = findP(v);

        if (ulp_u == ulp_v){
             extras++;
             return;
            }

        int ru = rank.get(ulp_u);
        int rv = rank.get(ulp_v);

        if (ru < rv) {
            parent.set(ulp_u, ulp_v);
        } else if (rv < ru) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_u, ulp_v);
            rank.set(ulp_v, rank.get(ulp_v) + 1);
        }
    }

    public int components() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent.get(i) == i) count++;
        }
        return count;
    }
  }  
class Solution {
    public int makeConnected(int n, int[][] connections) {

        DisjointSet ds = new DisjointSet(n);
        for(int[] edge : connections){
            ds.unionByRank(edge[0],edge[1]);
        }

        int components = ds.components();
        int edgesNeeded = components - 1;

        return ds.extras >= edgesNeeded ? edgesNeeded : -1;


        
    }
}