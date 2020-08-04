import java.util.*;

/**
 * time: O(v)
 * space: O(v)
 */
public class L133_CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Queue<Node> q = new LinkedList();
        Map<Integer, Node> map = new HashMap();
        q.offer(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(map.containsKey(cur.val) && map.get(cur.val).neighbors.size() != 0) continue;
            if(!map.containsKey(cur.val)) map.put(cur.val, new Node(cur.val));
            List<Node> edges = cur.neighbors;
            for(Node e : edges){
                if(!map.containsKey(e.val)) map.put(e.val, new Node(e.val));
                map.get(cur.val).neighbors.add(map.get(e.val));
                q.offer(e);
            }
        }

        return map.get(1);
    }

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
}
