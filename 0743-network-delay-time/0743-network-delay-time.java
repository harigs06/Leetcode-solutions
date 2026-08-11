class Pair{
    int node;
    int weight;

    Pair(int n , int w){
        this.node = n;
        this.weight = w;
    }
}




class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] dist = new int[n];

        for(int i = 0 ; i < n ; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[k-1] = 0;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        PriorityQueue<Pair> que = new PriorityQueue<Pair>(
            (x,y) -> (x.weight - y.weight)
        );

        for(int i = 0 ; i < times.length ; i++){
            int u = times[i][0]-1;
            int v = times[i][1]-1;
            int w = times[i][2];

            adj.get(u).add(new Pair(v,w));
        }

        que.add(new Pair(k-1,0));

        while(!que.isEmpty()){
            int node = que.peek().node;
            int weight = que.peek().weight;

            que.remove();

            for(Pair adjConn : adj.get(node)){
                int adjNode = adjConn.node;
                int adjWeight = adjConn.weight;

                if(weight+adjWeight < dist[adjNode] ){
                    dist[adjNode] = weight+adjWeight;
                    que.add(new Pair(adjNode,dist[adjNode]));
                }

            }
        }

        int max = 0;

        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , dist[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max ;


        
    }
}