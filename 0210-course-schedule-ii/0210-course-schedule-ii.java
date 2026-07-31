class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] pre : prerequisites) {
            list[pre[1]].add(pre[0]); 
        }

        int[] visited = new int[numCourses];

        Stack<Integer> stack = new Stack();

        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] != 2){
                if(dfs(stack,visited,i,list)){
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];
        int ind = 0;
        while(!stack.isEmpty()){
            res[ind++] = stack.pop();
        }

        return res;
    }

    boolean dfs(Stack<Integer> stack , int[] visited , int i , List<Integer>[] list){
        if(visited[i] == 1) return true; 
        if(visited[i] == 2) return false;

        visited[i] = 1;

        for(int node : list[i]){
            if(dfs(stack,visited,node,list)){
                return true;
            }
        }
        visited[i] = 2;
        stack.push(i);
        return false;
    }
}