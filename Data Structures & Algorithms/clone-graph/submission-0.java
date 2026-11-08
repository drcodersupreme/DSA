class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    private Node dfs(Node node) {

        // If already cloned, return its clone
        if(map.containsKey(node)){
            return map.get(node);
        }

        // Create a clone of the current node
        Node clone = new Node(node.val);

        // Store mapping before visiting neighbors
        map.put(node, clone);

        // Traverse all neighbors
        for(Node it : node.neighbors){

            // Add cloned neighbor to cloned node
            clone.neighbors.add(dfs(it));
        }

        return clone;
    }

    public Node cloneGraph(Node node) {

        if(node == null) return null;

        return dfs(node);
    }
}