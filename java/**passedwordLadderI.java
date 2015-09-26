public class Solution {
	public int ladderLength(String start, String end, ArrayList<String> dictV) {
	    if(start.equals(end)) return 1;
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> ladder = new HashMap<String, Integer>();// Marks down the level of a word
        for(String str : dictV){
            ladder.put(str, Integer.MAX_VALUE);
        }
        ladder.put(start, 1);
	    Queue<String> queue = new LinkedList<String>();
	    queue.offer(start);
	    dictV.add(end);
	    
	    
	   
	    while(!queue.isEmpty()){
	        String word = queue.poll();
	        int step = ladder.get(word) + 1;
	        if(step > min) break;
	        for(int i = 0; i < word.length(); i++){
	            StringBuilder builder = new StringBuilder(word);
	            for(char c = 'a'; c <= 'z'; c++){
	                builder.setCharAt(i, c);
	                String tmp = builder.toString();
	                if(ladder.containsKey(tmp)){
	                    if(step > ladder.get(tmp)) continue;
	                    else if(step < ladder.get(tmp)){
	                        ladder.put(tmp, step);
	                        queue.offer(tmp);
	                    }
	                    else;
	                    if(tmp.equals(end)){
	                        min = step;
	                    }
	                }
	            }
	        }
	    }
	    return min == Integer.MAX_VALUE ? 0 : min;
	}
	

}
