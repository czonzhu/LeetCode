public class Solution{
	public int maxPoints(Point[] points){
		// one points with all other, hash the k with the number, record the dup, avoid x1 == x2
		if(points == null || points.length == 0) return 0;
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 1;
		for(int i = 0; i < points.length; i++){
			map.clear();
			map.put((double)Integer.MIN_VALUE, 1); // For writing convenience because of map.value() + dup incase all are dup
			int dup = 0;
			for(int j = i + 1; j < points.length; j++){
				if(points[j].x == points[i].x && points[j].y == points[i].y){
					dup++;
					continue;
				}
				double k = points[j].x - points[i].x == 0 ? Integer.MAX_VALUE :
				0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);//(double)(0 / -1) = -0.0
				if(map.containsKey(k)) map.put(k, map.get(k) + 1);
				else map.put(k, 2);
			}
			for(int num : map.values())
				max = Math.max(max, num + dup);
		}
		return max;
	}

}