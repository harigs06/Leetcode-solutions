class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> ans = new ArrayList<>();

        int[] visited = new int[graph.length];

        for(int i = 0 ; i < graph.length ; i++){
            if(dfs(i,graph,visited)){
                ans.add(i);
            }
        }

        return ans;
  
    }

    boolean dfs(int i , int[][] graph , int[] visited){
        if(visited[i] == 1) return false;
        if(visited[i] == 2) return true;

        visited[i] = 1;

        for(int node : graph[i]){
            if(!dfs(node,graph,visited)){
                return false;
            }
        }

        visited[i] = 2;
        return true;
    }
}