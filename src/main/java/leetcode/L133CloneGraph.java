package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L133CloneGraph {
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

        public Node cloneGraph(Node node) {
            Map<Integer,Node> map = new HashMap();
            return dfs(node,map);
        }

        private Node dfs(Node node, Map<Integer,Node> map){
            if(node == null) return null;
            if(map.containsKey(node.val))return map.get(node.val);

            Node n = new Node(node.val);
            map.put(node.val,n);
            for(Node nb : node.neighbors){
                n.neighbors.add(dfs(nb,map));
            }
            return n;
        }

}
