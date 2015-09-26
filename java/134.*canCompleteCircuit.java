public class Solution{
	public int canCompleteCircuit(int[] gas, int[] cost){
		int rst = 0, cur = 0, j = 0;
		for(int i = 0; i < gas.length; i++){
			rst += gas[i] - cost[i];
			cur += gas[i] - cost[i];
			if(cur < 0){
				j = i + 1;
				cur = 0;
			}
		}
		return rst >= 0 ? j : -1;
	}
}