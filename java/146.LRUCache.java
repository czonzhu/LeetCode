public class LRUCache {
	//1. Node as data 2. move_to_tail method 
	private class Node{
		int key, val;
		Node prev, next;
		public Node(int key, int val){
			this.key = key;
			this.val = val;
			prev = null;
			next = null;
		}
	}
    private int capacity;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        move_to_tail(cur);
        return cur.val;
    }
    
    public void set(int key, int value) {
        if(this.get(key) != -1){
        	Node cur = map.get(key);
        	cur.val = value;
        	cur.prev.next = cur.next;
        	cur.next.prev = cur.prev;
        	move_to_tail(cur);
        	return;
        }
        if(map.size() == capacity){
        	map.remove(head.next.key);// Use key to remove
        	head.next = head.next.next;
        	head.next.prev = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node cur){
    	
    	Node tmp = tail.prev;
    	cur.prev = tmp;
    	cur.next = tail;
    	tail.prev = cur;
    	tmp.next = cur;
    	return;
    }
}
/*
	Modifier    | Class | Package | Subclass | World
————————————+———————+—————————+——————————+———————
public      |  y    |    y    |    y     |   y
————————————+———————+—————————+——————————+———————
protected   |  y    |    y    |    y     |   n
————————————+———————+—————————+——————————+———————
no modifier |  y    |    y    |    n     |   n    **also known as package-private**
————————————+———————+—————————+——————————+———————
private     |  y    |    n    |    n     |   n

y: accessible
n: not accessible
*/