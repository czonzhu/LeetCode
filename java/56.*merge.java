/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // 1. sort 2. [1, 4]: [5, 6], [2, 3] [2,5]
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)  return rst;
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b){
               return a.start - b.start;
           } 
        });
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.start > prev.end){
                rst.add(prev);
                prev = cur;
            }
            else
                prev.end = Math.max(prev.end, cur.end);
        }
        rst.add(prev);
        return rst;
    }
}