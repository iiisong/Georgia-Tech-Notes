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
        PriorityQueue<VertexDistance<T>> pq = new PriorityQueue<>(); // pq for traversal
        Map<VertexDistance<T>, Vertex<T>> prevMap = new HashMap<>(); // map to track prev nodes
        // VertexDistance instead of Vertex because potentially multiple different paths lead to node
            // storing it as <Vertex<T>, Vertex<T>> could potentially override and lose the prev node data for edge

        pq.add(new VertexDistance<T>(start, 0)); // "instantiate" pq
  
        // note: prims implementation can't add to result forward but only backwards
            // as in, cant add to result when iterating through the new edges only after getting to node
            // this is bc unvisited edge cannot ensure
        
        // run till pq empty
        while (pq.size() != 0) {
            VertexDistance<T> v = pq.remove();

            // make sure nodes unvisited, different from other implementation
                //can't requires checking all edges to node to add vs first node
                // djikstra ensures first appearance is shortest path
                // prims cant bc not based on distance to start but general distance
            // skip over if already visited
            if (visited.contains(v.getVertex())) {
                continue;
            }

            // mark it as visited
            visited.add(v.getVertex());
            
            // convenient way to skip first cycle as no edges "led" to it (arbitrary start pt)
                // alternate method is to instantiate prevMap and pq outside loop
            if (prevMap.containsKey(v)) {
                // add edges (bidirectional) and pull from map to find prev node
                result.add(new Edge<T>(prevMap.get(v), v.getVertex(), v.getDistance()));
                result.add(new Edge<T>(v.getVertex(), prevMap.get(v), v.getDistance()));
            }

            // iterate through edges
            for (VertexDistance<T> n : graph.getAdjList().get(v.getVertex())) {
                if (!visited.contains(n.getVertex())) { // only add unvisited edges
                    prevMap.put(n, v.getVertex()); // put prev prev node value for "edge"
                    pq.add(n); // add edge in pq
                }
            }
        }

        return result;
    }