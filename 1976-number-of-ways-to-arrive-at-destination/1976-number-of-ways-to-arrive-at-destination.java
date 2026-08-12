class Pair{
    int node;
    long weight;

    Pair(int n , long w){
        this.node = n;
        this.weight = w;
    }
}


class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD = 1_000_000_007L;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < roads.length ; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        long[] dist = new long[n];
        for(int i = 0 ; i < n ; i++)dist[i] = Long.MAX_VALUE;
        dist[0] = 0;

        PriorityQueue<Pair> que = new PriorityQueue<Pair>(
            (x,y) -> (int) (x.weight - y.weight)
        );

        long[] ways = new long[n];
        ways[0] = 1;


        que.add(new Pair(0,0));

        while(!que.isEmpty()){

            int node = que.peek().node;
            long weight = que.peek().weight;

            que.remove();

            if (weight > dist[node]) {
                continue;
            }

            for(Pair adjCell : adj.get(node)){
                int neighbour = adjCell.node;
                long adjWeight = adjCell.weight;

                if(weight+adjWeight == dist[neighbour]){
                    ways[neighbour] = (ways[neighbour] + ways[node]) % MOD;
                }else if(weight+adjWeight < dist[neighbour]){
                    dist[neighbour] = weight+adjWeight;
                    ways[neighbour] = ways[node];
                    que.add(new Pair(neighbour,dist[neighbour]));
                }
            }


        }

        return (int) ways[n-1];
    }
}