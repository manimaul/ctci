//Given a directed graph, design an algorithm to find out whether there is a route between two nodes;

import java.util.*;

class q4_2 {

    //demonstration of answer
    public static void main(String[] args) {

        //create a conveluted graph
        GraphSet<Integer> gs = new GraphSet<Integer>(0);
        GraphSet<Integer>.Graph node;
        ArrayList<GraphSet<Integer>.Graph> nodes;
        node = gs.getAllNodes().get(0); //node 0
        nodes = node.addNodes(new Integer[] {1,2}); //add nodes 1 and 2 to 0
        nodes.get(1).addNode(3); //add node 3 to node 2
        node = nodes.get(1).addNode(4); //add node 3 to node 2

        //should be true
        System.out.println(String.format("is route between 0 and 4: %b", gs.isRouteBetween(gs.getAllNodes().get(0), node)));

        //should be false
        System.out.println(String.format("is route between 1 and 4: %b", gs.isRouteBetween(gs.getAllNodes().get(1), node)));
    }
}

class GraphSet<E> {
    private final ArrayList<Graph> masterList = new ArrayList<Graph>();

    /**
     *instanciate set with an initial first node
     */
    public GraphSet(E e) {
        Graph node = new Graph(e);
        masterList.add(node);
    }


    //answer q4_2 using breadth search first
    public boolean isRouteBetween(Graph pNode1, Graph pNode2) {
        resetVisited();

        Queue<Graph> queue = new LinkedList<Graph>();
        queue.offer(pNode1);

        Graph node;
        while(queue.size() > 0) {
            node = queue.poll();
            node.visited = true;
            if (node.equals(pNode2)) {
                return true;
            }
            for (Graph n: node.getNodes()) {
                if (!n.visited) {
                    queue.offer(n);
                }
            }
        }

        return false;
    }

    //answer q4_2 using recursion
    // public boolean isRouteBetween(Graph pNode1, Graph pNode2) {
    //  pNode1.visited = true;

    //  if (pNode1.equals(pNode2))
    //      return true;

        
    //  for (Graph node: pNode1.getNodes()) {
    //      if (!node.visited && isRouteBetween(node, pNode2))
    //          return true;
    //  }

    //  return false;
    // }

    public void resetVisited() {
        for (Graph g: masterList) {
            g.visited = false;
        }
    }

    /**
     * @return read only List<Graph> of nodes.
     */
    public List<Graph> getAllNodes() {
        return Collections.unmodifiableList(masterList);
    }

    class Graph {
        public E data;
        public boolean visited = false;
        private ArrayList<Graph> nodes = null;

        // private Class<E> getAsData(Class<E> a){
        //     return a;
        // }    

        public Graph(E e) {
            data = e;
        }

        /**
         * @return read only List<Graph> of nodes.
         */
        public List<Graph> getNodes() {
            if (nodes == null)
                nodes = new ArrayList<Graph>();

            return Collections.unmodifiableList(nodes);
        }

        public ArrayList<Graph> addNodes(E[] es) {
            ArrayList<Graph> graphs = new ArrayList<Graph>(es.length);
            for (int i = 0; i< es.length; i++) {
                graphs.add(addNode(es[i]));
            }
            return graphs;
        }

        public Graph addNode(E e) {
            if (nodes == null)
                nodes = new ArrayList<Graph>();

            Graph node = new Graph(e);
            nodes.add(node);
            masterList.add(node);
            return node;
        }

        public void attachNode(Graph node) {
            if (nodes == null)
                nodes = new ArrayList<Graph>();

            nodes.add(node);
        }

    }

}