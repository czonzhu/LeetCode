/*
	Solution : 1. fill border 'O' with 'P'
			   2. replace remaining 'O' with 'X'
			   3. replace 'P' with 'X'
	Caution: in floodFill function, use iteration to reduce the time complexity.
			 Pay attention to edge condition to avoid overflow.

*/

public class Solution {
    public class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
	public void solve(ArrayList<ArrayList<Character>> a) {
	    if(a.size() < 3 || a.get(0).size() < 3) return;
	    fillBorder(a, 'O', 'P');
	    replace(a, 'O', 'X');
	    replace(a, 'P', 'O');
	}
	
	public void fillBorder(ArrayList<ArrayList<Character>> a, char from, char to){
	    for(int i = 0; i < a.size(); i++){
	        floodFill(a, i, 0, from, to);
	        floodFill(a, i, a.get(0).size() - 1, from, to);
	    }
	    for(int j = 1; j < a.get(0).size() - 1; j++){
	        floodFill(a, 0, j, from, to);
	        floodFill(a, a.size() - 1, j, from, to);
	    }
	}
	public void floodFill(ArrayList<ArrayList<Character>> a, int x, int y, char from, char to){
	    if(x < 0 || y < 0 || x >= a.size() || y >= a.get(0).size() || a.get(x).get(y) != from) return;
	    Stack<Node> stack = new Stack<Node>();
	    stack.push(new Node(x, y));
	    while(!stack.empty()){
	        Node tmp = stack.pop();
	        a.get(tmp.x).set(tmp.y, to);
	        if(tmp.x > 0 && a.get(tmp.x - 1).get(tmp.y) == from){
	            stack.push(new Node(tmp.x - 1, tmp.y));
	        }
	        if(tmp.y > 0 && a.get(tmp.x).get(tmp.y - 1) == from){
	            stack.push(new Node(tmp.x, tmp.y - 1));
	        }
	        if(tmp.x < a.size() - 1 && a.get(tmp.x + 1).get(tmp.y) == from){
	            stack.push(new Node(tmp.x + 1, tmp.y));
	        }
	        if(tmp.y < a.get(0).size() - 1 && a.get(tmp.x).get(tmp.y + 1) == from){
	            stack.push(new Node(tmp.x, tmp.y + 1));
	        }
	    }
	}
	public void replace(ArrayList<ArrayList<Character>> a,  char from, char to){
	    for(int i = 0; i < a.size(); i++){
	        for(int j = 0; j < a.get(0).size(); j++){
	            if(a.get(i).get(j) == from){
	                a.get(i).set(j, to);
	            }
	        }
	    }
	}
	
}
