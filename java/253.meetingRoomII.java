public class Solution{
	public int minMeetingRooms(Interval[] intervals){
		if(intervals == null || intervals.length == 0) return 0;
		ArrayList<Integer> starts = new ArrayList<>(), ends = new ArrayList<>();
		for(Interval interval : intervals){
			starts.add(interval.start);
			ends.add(interval.end);
		}
		Collections.sort(starts);
		Collections.sort(ends);
		int i = 0, j = 0;
		int cur = 0, max = 0;
		while(i < intervals.length && j < intervals.length){
			if(starts.get(i) < ends.get(j)){
				cur++;
				i++;
				max = Math.max(max, cur);
			}
			else{
				cur--;
				j++;
			}
		}
		return max;
	}
}