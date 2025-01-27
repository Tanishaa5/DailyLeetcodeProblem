

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Initialize a graph with a transitive closure matrix
        boolean[][] graph = new boolean[numCourses][numCourses];

        // Step 2: Populate the graph with direct prerequisites
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = true;
        }

        // Step 3: Compute transitive closure using Floyd-Warshall
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    // If i->k and k->j, then i->j
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        // Step 4: Process queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(graph[query[0]][query[1]]);
        }

        return result;
    }
}
