import java.util.Arrays;

public class TransitiveClosure {
    final static int V = 5;  // Number of vertices in the graph

    // Function to compute transitive closure using Floyd-Warshall Algorithm
    void transitiveClosure(int graph[][]) {
        int reach[][] = new int[V][V]; // Create a closure matrix
        
        // Initialize the reachability matrix to be the same as the input graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                reach[i][j] = graph[i][j];
            }
        }

        // Compute the transitive closure using the Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Update reachability if a path exists through an intermediate vertex k
                    reach[i][j] = (reach[i][j] != 0) || ((reach[i][k] != 0) && (reach[k][j] != 0)) ? 1 : 0;
                }
            }
        }

        // Print the transitive closure matrix
        printSolution(reach);
    }

    // Utility function to print the solution matrix
    void printSolution(int reach[][]) {
        System.out.println("Transitive Closure Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(reach[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TransitiveClosure tc = new TransitiveClosure();
        
        // Adjacency matrix representation of the graph
        int graph[][] = new int[][] {
            {1, 1, 0, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1}
        };
        
        // Call the transitiveClosure function to compute the closure matrix
        tc.transitiveClosure(graph);
    }
}

