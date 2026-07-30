import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build adjacency list
        List<Integer>[] list = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] pre : prerequisites) {
            list[pre[0]].add(pre[1]); // Fixed: add() instead of put()
        }

        boolean[] visited = new boolean[numCourses];
        HashSet<Integer> recursionStack = new HashSet<>();

        // 2. Run DFS for every unvisited node
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, visited, list, recursionStack)) {
                    return false; // Found a cycle -> cannot finish
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int node, boolean[] visited, List<Integer>[] list, HashSet<Integer> stack) {
        // Cycle detected: node is in current recursion stack
        if (stack.contains(node)) {
            return true;
        }

        // Already visited and confirmed no cycle in this path
        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        stack.add(node);

        for (int neighbor : list[node]) {
            if (hasCycle(neighbor, visited, list, stack)) {
                return true;
            }
        }

        // Backtrack
        stack.remove(node);
        return false;
    }
}