class Pair{
    int node;
    int weight;

    Pair(int node , int weight){
        this.node = node;
        this.weight = weight;
    }
}

class Pair1{
    int node;
    int weight;
    int stops;

    Pair1(int node , int weight , int stops){
        this.node = node;
        this.weight = weight;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj  = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] place : flights){
            int u = place[0];
            int v = place[1];
            int w = place[2];

            adj.get(u).add(new Pair(v,w));
        }

        Queue<Pair1> que = new LinkedList<>();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        que.add(new Pair1(src, 0, 0));

        while (!que.isEmpty()) {
            Pair1 curr = que.poll();
            int node = curr.node;
            int weight = curr.weight;
            int stop = curr.stops;

            if (stop > k) continue;

            for (Pair adjCell : adj.get(node)) {
                int neighbor = adjCell.node;
                int edgeWeight = adjCell.weight;

                if (weight + edgeWeight < dist[neighbor]) {
                    dist[neighbor] = weight + edgeWeight;
                    que.offer(new Pair1(neighbor, dist[neighbor], stop + 1)); 
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}