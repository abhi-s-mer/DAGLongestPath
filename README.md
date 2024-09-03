### Class: `DirectedGraph`

#### Attributes:
- `int numVertices`: The number of vertices in the graph.
- `List<List<Integer>> adjacencyList`: The adjacency list to store edges between vertices.

#### Methods:

1. **`DirectedGraph(int numVertices)`**:
   - **Description**: Constructor that initializes the graph with a given number of vertices.
   - **Initialization**: Creates an adjacency list for each vertex.

2. **`void addDirectedEdge(int u, int v)`**:
   - **Description**: Adds a directed edge from vertex `u` to vertex `v`.
   - **Usage**: This method is used to build the graph by specifying directed edges.

3. **`void performTopologicalSort(int vertex, boolean[] visited, Deque<Integer> stack)`**:
   - **Description**: Recursively performs topological sorting on the graph.
   - **Parameters**:
     - `int vertex`: The current vertex being processed.
     - `boolean[] visited`: An array to keep track of visited vertices.
     - `Deque<Integer> stack`: A stack that stores the vertices in topologically sorted order.
   - **Functionality**: Marks the current vertex as visited, then recursively visits all its unvisited neighbors, and finally pushes the current vertex onto the stack.

4. **`int computeLongestPathFrom(int source)`**:
   - **Description**: Computes the longest path starting from the given source vertex.
   - **Parameters**:
     - `int source`: The vertex from which the longest path is calculated.
   - **Returns**: The length of the longest path from the source vertex.
   - **Functionality**: 
     - First, it performs a topological sort of all vertices.
     - Then, it traverses the vertices in topologically sorted order, starting from the source vertex, to calculate the longest path using a DFS-based exploration.

5. **`int exploreLongestPath(int vertex)`**:
   - **Description**: A helper method that recursively calculates the longest path from the given vertex.
   - **Parameters**:
     - `int vertex`: The current vertex being explored.
   - **Returns**: The length of the longest path starting from this vertex.
   - **Functionality**: Recursively explores all neighbors of the current vertex, returning the maximum path length found.

### Main Method

**`public static void main(String[] args)`**:
- **Description**: The driver method that tests the graph implementation and longest path calculation.
- **Functionality**:
  - A graph with 6 vertices is created, and directed edges are added between them.
  - The longest path starting from vertex 0 is calculated and printed.

