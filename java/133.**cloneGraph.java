public class Solution{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// The hashmap is used for 1. record whether visited 2. decide which newNode's neighbors to add.
		// Use queue for bfs, one node used as center one time.
		if(node == null) return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node, newNode);
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		while(!queue.isEmpty()){
			UndirectedGraphNode tmp = queue.poll();
			for(UndirectedGraphNode nb : tmp.neighbors){
				if(!map.containsKey(nb)){
					map.put(nb, new UndirectedGraphNode(nb.label));
					queue.offer(nb);
				}
				map.get(tmp).neighbors.add(map.get(nb));
			}
		}
		return newNode;
	}
}