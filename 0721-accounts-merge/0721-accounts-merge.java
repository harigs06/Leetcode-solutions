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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < accounts.get(i).size() ; j++){

                String mail = accounts.get(i).get(j);

                if(map.containsKey(mail)){
                    ds.unionByRank( i , map.get(mail) );
                    // map.put(mail,i);
                }else{
                    map.put(mail,i);
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            mergedMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String,Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.findP(it.getValue());
            mergedMail[node].add(mail);
        }


        List<List<String>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(mergedMail[i].size() == 0)continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergedMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }


        return ans;



    }
}