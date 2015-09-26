/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// 1. insert view 2. take newInterval as the main role
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            rst.add(newInterval);
            return rst;
        }
        int pos = 0;
        for(Interval tmp : intervals){
            if(newInterval.end < tmp.start)
                rst.add(tmp);
            else if(newInterval.start > tmp.end){
                rst.add(tmp);
                pos++;
            }
            else{
                newInterval.start = Math.min(tmp.start, newInterval.start);
                newInterval.end = Math.max(tmp.end, newInterval.end);
            }
        }
        rst.add(pos, newInterval);
        return rst;
    }
}