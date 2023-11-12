class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (!visited[course]) {
                if (isCyclic(course, graph, visited, recStack)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCyclic(int course, List<List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        visited[course] = true;
        recStack[course] = true;

        // Recur for all the vertices adjacent to this vertex
        for (Integer neighbor : graph.get(course)) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, graph, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[course] = false;

        return false;
    }
}
