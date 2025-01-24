import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        int[] outdegree = new int[n];

        // Initialize reverse graph
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Build the reverse graph and calculate outdegree
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
            }
            outdegree[i] = graph[i].length;
        }

        // Queue for nodes with outdegree 0 (terminal nodes)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform BFS on the reverse graph
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);

            // Reduce the outdegree of neighbors in the reversed graph
            for (int neighbor : reverseGraph.get(node)) {
                outdegree[neighbor]--;
                if (outdegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Sort the safe nodes in ascending order
        Collections.sort(safeNodes);

        return safeNodes;
    }
}
