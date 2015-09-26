public class Solution{
	public int[] maxSlidingWindow(int[] a, int k){
		if(a == null || k <= 0) return a;
		int[] rst = new int[a.length - k + 1];
		int id = 0;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for(int i = 0; i < a.length; i++){
			while(!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();// remove outrages
			while(!deque.isEmpty() && a[deque.peekLast()] < a[i]) deque.pollLast();// removeBubble, decending from left to right
			deque.offer(i);
			if(i >= k - 1){
				rst[id++] = a[deque.peek()];
			}
		}
		return rst;
	}
}