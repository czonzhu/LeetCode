public class Solution{
	Map<String, List<String>> map;
	List<List<String>> results;
	public List<List<String>> findLadders(String start, String end, Set<String> dict){
		results = new ArrayList<List<String>>();
		if(dict.size() == 0)
			return results;
		int min = Integer.MAX_VALUE;

		Queue<String> queue = new LinkedList<String>();
		queue.add(start);

		map = new HashMap<String, List<String>>(); // node and its neightbor

		Map<String, Integer> ladder = new HashMap<String, Integer>();
		for(String string : dict)
			ladder.put(string, Integer.MAX_VALUE);
		ladder.put(start, 0);

		dict.add(end);

		while(!queue.isEmpty()){
			String word = queue.poll();

			int step = ladder.get(word) + 1;

			if(step > min) break;

			for(int i = 0; i < word.length(); i++){
				StringBuilder builder = new StringBuilder(word);
				for(char ch = 'a'; ch <= 'z'; ch++){
					builder.setCharAt(i, ch);
					String new_word = builder.toString();
					if(ladder.containsKey(new_word)){
						if(step > ladder.get(new_word))
							continue;
						else if(step < ladder.get(new_word)){
							queue.add(new_word);
							ladder.put(new_word, step);
						}else;

						if(map.containsKey(new_word))
							map.get(new_word).add(word);
						else{
							List<String> list = new ArrayList<String>();
							list.add(word);
							map.put(new_word, list);
						}
						if(new_word.equals(end))
							min = step;
					}
				}
			}
		}
		ArrayList<String> rst = new ArrayList<String>();
		backTrace(end, start, rst);

		return rst;
	}

	private void backTrace(String word, String start, List<String> list){
		if(word.equals(start)){
			list.add(0, start);
			results.add(new ArrayList<String>(list));
			list.remove(0);
			return;
		}
		list.add(0, word);
		if(map.get(word) != null){
			for(String s : map.get(word))
				backTrace(s, start, list);
		}
		list.remove(0);
	}
}