public class Solution{
	public List<int[]> getSkyline(int[][] buildings){
		if(buildings.length == 0)
			return new LinkedList<int[]>();
		return recurSkyline(buildings, 0, buildings.length - 1);
	}

	private LinkedList<int[]> recurSkyline(int[][] buildings, int p, int q){
		if(p < q){
			int mid = p + (q - p) / 2;
			return merge(recurSkyline(buildings, p, mid),
				recurSkyline(buildings, mid + 1, q));
		}else{
			LinkedList<int[]> rst = new LinkedList<int[]>();
			rst.add(new int[]{buildings[p][0], buildings[p][2]});
			rst.add(new int[]{buildings[p][1], 0});
			return rst;
		}
	}

	private LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2){
		LinkedList<int[]> rst = new LinkedList<int[]>();
		int h1 = 0, h2 = 0;
		while(l1.size() > 0 && l2.size() > 0){
			int x = 0, h = 0;
			if(l1.getFirst()[0] < l2.getFirst()[0]){
				x = l1.getFirst()[0];
				h1 = l1.getFirst()[1];
				h = Math.max(h1, h2);
				l1.removeFirst();
			}else if(l1.getFirst()[0] > l2.getFirst()[0]){
				x = l2.getFirst()[0];
				h2 = l2.getFirst()[1];
				h = Math.max(h1, h2);
				l2.removeFirst();
			}else{
				x = l1.getFirst()[0];
				h1 = l1.getFirst()[1];
				h2 = l2.getFirst()[1];
				h = Math.max(h1, h2);
				l1.removeFirst();
				l2.removeFirst();
			}
			if(rst.size() == 0 || h != rst.getLast()[1]){
				rst.add(new int[]{x, h});
			}
		}
		rst.addAll(l1);
		rst.addAll(l2);
		return rst;
	}
}