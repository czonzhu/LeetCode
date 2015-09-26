/*
	Solutoin: 1. note down the distance to every word
			  2. note down the map.
	Caution: empty dictionary 
*/
public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
	    ArrayList<ArrayList<String>> rsts = new ArrayList<ArrayList<String>>();
	    ArrayList<String> path = new ArrayList<String>();
	    if(start.equals(end)){
	        path.add(start);
	        rsts.add(new ArrayList<String>(path));
	        return rsts;
	    }
	    
	    Queue<String> queue = new LinkedList<String>();
	    queue.offer(start);
	    
	    Map<String, Integer> ladder = new HashMap<String, Integer>();// mark the min step to get to the word
	    Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();// mark the adjacent word to that word
	    for(String str : dict){
	        ladder.put(str, Integer.MAX_VALUE);
	    }
	    ladder.put(start, 0);
	    int min = Integer.MAX_VALUE;
	    
	    while(!queue.isEmpty()){
	        String word = queue.poll();
	        int step = ladder.get(word) + 1;
	        if(step > min) break;
	        
	        for(int i = 0; i < word.length(); i++){
	            StringBuilder builder = new StringBuilder(word);
	            for(char c = 'a'; c <= 'z'; c++){
	                builder.setCharAt(i, c);
	                String new_word = builder.toString();
	                
	             
	                
	                if(ladder.containsKey(new_word)){
	                    
	                    if(step > ladder.get(new_word))
	                        continue;
	                    else if(step < ladder.get(new_word)){
	                        queue.offer(new_word);
	                        ladder.put(new_word, step);
	                    }
	                    else;
	                    
	                    if(map.containsKey(new_word)){
	                        map.get(new_word).add(word);
	                    }
	                    else{
	                        ArrayList<String> list = new ArrayList<String>();
	                        list.add(word);
	                        map.put(new_word, list);
	                    }
	                    if(new_word.equals(end))    
	                        min = step;
	                }
	                
	                else if(new_word.equals(end)){
	                        path.add(start);
	                        path.add(end);
	                        rsts.add(new ArrayList<String>(path));
	                        return rsts;
	                }
	                
	                    
	               
	                
	            }
	        }
	    }
	    ArrayList<String> rst = new ArrayList<String>();
	    backTrace(end, start, rst, rsts, map);
	    return rsts;
	}
	
	private void backTrace(String word, String start, ArrayList<String> list, ArrayList<ArrayList<String>> rsts
	                        , Map<String, ArrayList<String>> map){
	    if(word.equals(start)){
	        list.add(0, word);
	        rsts.add(new ArrayList<String>(list));
	        list.remove(0);
	        return;
	    }
	    
	    if(map.get(word) != null){
	        for(String s : map.get(word)){
	            list.add(0, word);
	            backTrace(s, start, list, rsts, map);
	            list.remove(0);
	        }
	    }
	    
	}
}
