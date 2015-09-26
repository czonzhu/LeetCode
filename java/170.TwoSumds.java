public class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
	public void add(int number) {
	    map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
        return;
	}

	public boolean find(int value) {
	    for(int key : map.keySet()){
	        if(map.containsKey(value - key)){
	            if(value - key != key || map.get(key) > 1) return true;
	        }
	    }
	    return false;
	}
}