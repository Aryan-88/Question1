import java.util.*;

public class TopologicalSort {
    
    // Function to perform DFS and topologically sort the graph
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack, List<List<Integer>> adj) {
        visited[v] = true;  // Mark the current node as visited
        
        // Recur for all the adjacent vertices
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, adj);
            }
        }
        
        // Push the current vertex to the stack after visiting all its neighbors
        stack.push(v);
    }

    // Function to perform topological sort
    void topologicalSort(int V, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();  // Stack to store the topological order
        boolean visited[] = new boolean[V];  // Mark all vertices as not visited

        // Call the recursive helper function for all vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, adj);
            }
        }

        // Print the contents of the stack as the topological order
        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;  // Number of vertices
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the directed graph
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Create an instance of TopologicalSort and perform the sort
        TopologicalSort ts = new TopologicalSort();
        ts.topologicalSort(V, adj);
    }
}
