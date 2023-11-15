import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Your implementation of various different graph algorithms.
 *
 * @author Isaac Song
 * @userid isong41
 * @GTID 903808112
 * @version 1.0
 */
public class GraphAlgorithms {
    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you may use is the
     * adjacency list from graph. DO NOT create new instances of Map
     * for BFS (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin the bfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     * @throws IllegalArgumentException if any input is null, or if start
     *                                  doesn't exist in the graph
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        if (start == null) {
            throw new IllegalArgumentException("start cannot be null");
        }

        if (graph == null) {
            throw new IllegalArgumentException("graph cannot be null");
        }

        if (!graph.getVertices().contains(start)) {
            throw new IllegalArgumentException("start not in graph");
        }

        // queue
        List<Vertex<T>> visited =  new ArrayList<>();
        visited.add(start); // "instantiate" the queue

        // shorthand to iterate through all possible nodes
        //      honestly bad practice bc for loops should iterate through set lengths
        //      changing lengths of arrays during iteration is risky
        //      but short :)
        for (int i = 0; i < visited.size(); i++) {
            // iterate through edges, foreach for conciseness
            for (VertexDistance<T> v : graph.getAdjList().get(visited.get(i))) {
                if (!visited.contains(v.getVertex())) { // only allow unvisited nodes
                    visited.add(v.getVertex()); // queue add for bfs
                }
            }
        }

        return visited;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * *NOTE* You MUST implement this method recursively, or else you will lose
     * all points for this method.
     *
     * You may import/use java.util.Set, java.util.List, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you may use is the
     * adjacency list from graph. DO NOT create new instances of Map
     * for DFS (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin the dfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     * @throws IllegalArgumentException if any input is null, or if start
     *                                  doesn't exist in the graph
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        if (start == null) {
            throw new IllegalArgumentException("start cannot be null");
        }

        if (graph == null) {
            throw new IllegalArgumentException("graph cannot be null");
        }

        if (!graph.getVertices().contains(start)) {
            throw new IllegalArgumentException("start not in graph");
        }

        LinkedList<Vertex<T>> visited = new LinkedList<>();
        visited.add(start);

        return dfsRecurse(start, graph, visited);

        /*
        // stack
        List<Vertex<T>> visited =  new LinkedList<>();
        visited.add(start); // "instantiate" the stack

        // shorthand to iterate through all possible nodes
        //      honestly bad practice bc for loops should iterate through set lengths
        //      changing lengths of arrays during iteration is risky
        //      but short :)
        for (int i = 0; i < visited.size(); i++) {
            // iterate through edges in reverse order to appease dfs checker which dfs on first edge not last
            // theoretically both orders (first edge vs last edge) should qualify as dfs
            for (int j = graph.getAdjList().get(visited.get(i)).size() - 1; j >= 0; j--) {
                VertexDistance<T> v = graph.getAdjList().get(visited.get(i)).get(j);
                if (!visited.contains(v.getVertex())) { // only allow unvisited nodes
                    visited.add(i + 1, v.getVertex()); // previously seen nodes remain in same index location
                    // theoretically simpler code would have result list and use stack and pop but longer implementation
                }
            }
        }

        // note: another dfs implementation should be possible to do with result array like the pq implmentation below

        return visited;
        */
    }

    /**
     * Recursive helper for dfs
     *
     * @param <T> generic typing of data
     * @param vertex current node
     * @param graph graph
     * @param visited result array
     * @return list of traversal
     */
    private static <T> List<Vertex<T>> dfsRecurse(Vertex<T> vertex, Graph<T> graph, List<Vertex<T>> visited) {
        
        for (VertexDistance<T> vd : graph.getAdjList().get(vertex)) {
            if (!visited.contains(vd.getVertex())) {
                visited.add(vd.getVertex());
                visited = dfsRecurse(vd.getVertex(), graph, visited);
            }
        }

        return visited;
    }

    /**
     * Finds the single-source shortest distance between the start vertex and
     * all vertices given a weighted graph (you may assume non-negative edge
     * weights).
     *
     * Return a map of the shortest distances such that the key of each entry
     * is a node in the graph and the value for the key is the shortest distance
     * to that node from start, or Integer.MAX_VALUE (representing
     * infinity) if no path exists.
     *
     * You may import/use java.util.PriorityQueue,
     * java.util.Map, and java.util.Set and any class that
     * implements the aforementioned interfaces, as long as your use of it
     * is efficient as possible.
     *
     * You should implement the version of Dijkstra's where you use two
     * termination conditions in conjunction.
     *
     * 1) Check if all of the vertices have been visited.
     * 2) Check if the PQ is empty.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin the Dijkstra's on (source)
     * @param graph the graph we are applying Dijkstra's to
     * @return a map of the shortest distances from start to every
     * other node in the graph
     * @throws IllegalArgumentException if any input is null, or if start
     *                                  doesn't exist in the graph.
     */
    public static <T> Map<Vertex<T>, Integer> dijkstras(Vertex<T> start,
                                                        Graph<T> graph) {
        if (start == null) {
            throw new IllegalArgumentException("start cannot be null");
        }

        if (graph == null) {
            throw new IllegalArgumentException("graph cannot be null");
        }

        if (!graph.getVertices().contains(start)) {
            throw new IllegalArgumentException("start not in graph");
        }

        Map<Vertex<T>, Integer> result = new HashMap<>(); // result map
        PriorityQueue<VertexDistance<T>> pq = new PriorityQueue<>(); // priority queue

        

        pq.add(new VertexDistance<T>(start, 0)); // "instantiate" pq

        // run till pq empty
        while (pq.size() != 0) {
            VertexDistance<T> v = pq.remove();

            if (result.containsKey(v.getVertex())) {
                continue;
            }

            if (result.size() == graph.getVertices().size()) {
                break;
            }

            result.put(v.getVertex(), v.getDistance()); // put in result

            // iterate through edges
            for (VertexDistance<T> n : graph.getAdjList().get(v.getVertex())) {
                if (!result.containsKey(n.getVertex())) { // only add unvisited edges
                    pq.add(new VertexDistance<T>(n.getVertex(), v.getDistance() + n.getDistance())); // put in pq
                }
            }
        }

        // note: another pq implementation should be possible to do without result array 
        //      like the dfs implmentation above

        for (Vertex<T> v : graph.getVertices()) {
            if (!result.containsKey(v)) {
                result.put(v, Integer.MAX_VALUE);
            }
        }

        return result;
    }

    /**
     * Runs Prim's algorithm on the given graph and returns the Minimum
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * You should NOT allow self-loops or parallel edges in the MST.
     *
     * You may import/use PriorityQueue, java.util.Set, and any class that 
     * implements the aforementioned interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * The only instance of java.util.Map that you may use is the
     * adjacency list from graph. DO NOT create new instances of Map
     * for this method (storing the adjacency list in a variable is fine).
     *
     * @param <T> the generic typing of the data
     * @param start the vertex to begin Prims on
     * @param graph the graph we are applying Prims to
     * @return the MST of the graph or null if there is no valid MST
     * @throws IllegalArgumentException if any input is null, or if start
     *                                  doesn't exist in the graph.
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        if (start == null) {
            throw new IllegalArgumentException("start cannot be null");
        }

        if (graph == null) {
            throw new IllegalArgumentException("graph cannot be null");
        }

        if (!graph.getVertices().contains(start)) {
            throw new IllegalArgumentException("start not in graph");
        }

        Set<Edge<T>> result = new HashSet<>(); // result set
        Set<Vertex<T>> visited = new HashSet<>(); // visited set
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>(); // pq for traversal
        
        // prepopulate n
        for (VertexDistance<T> n : graph.getAdjList().get(start)) {
            pq.add(new Edge<T>(start, n.getVertex(), n.getDistance())); 
        }
        
        // run till pq empty
        while (pq.size() != 0) {
            // remove edge
            Edge<T> e = pq.remove();

            // note: prims implementation can't add to result forward but only backwards
            //      as in, cant add to result when iterating through the new edges only after getting to node
            //      this is bc just bc unvisited edge cannot ensure is shortest edge

            // skip if destination node visited
            if (visited.contains(e.getV())) {
                continue;
            }

            if (visited.size() == graph.getVertices().size()) {
                break;
            }

            // mark it as visited
            visited.add(e.getV());
        
            // add edge to set (both directions)
            result.add(e);
            result.add(new Edge<T>(e.getV(), e.getU(), e.getWeight()));

            // iterate through edges
            for (VertexDistance<T> n : graph.getAdjList().get(e.getV())) {
                pq.add(new Edge<T>(e.getV(), n.getVertex(), n.getDistance())); // add edge in pq
            }
        }

        
        if (visited.size() != graph.getVertices().size()) {
            return null;
        }

        return result;
    }
}