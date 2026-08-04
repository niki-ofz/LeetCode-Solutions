/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node==null)return null;

        HashMap<Node,Node> visited=new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();

        visited.put(node,new Node(node.val,new ArrayList<>()));
        q.offer(node);

        while (!q.isEmpty()) {
            Node nd=q.poll();
            
            for(Node neighbors:nd.neighbors){
                if(!visited.containsKey(neighbors)){

                    visited.put(neighbors,new Node(neighbors.val,new ArrayList<>()));
                    q.offer(neighbors);
                }

                visited.get(nd).neighbors.add(visited.get(neighbors));
            }
        }
        return visited.get(node);
    }
}