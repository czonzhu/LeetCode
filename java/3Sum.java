// Pay attention to Dup
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        Collections.sort(a);
        if(a == null || a.size() < 3) return rst;
        for(int i = 0; i < a.size() - 2; i++){
            int l = i + 1, r = a.size() - 1;
            if(i != 0 && a.get(i) == a.get(i - 1)) continue;
            while(l < r){
                
                if(a.get(l) + a.get(r) + a.get(i) == 0){
                    path.clear();
                    path.add(a.get(i)); path.add(a.get(l)); path.add(a.get(r)); 
                    rst.add(new ArrayList<Integer>(path));
                    l++; r--;
                    while(l < r &&  a.get(l) == a.get(l - 1)) l++;
                    while(l < r && r < a.size() - 1 && a.get(r) == a.get(r + 1)) r--;
                }
                else if(a.get(l) + a.get(r) + a.get(i) < 0){
                    l++;
                }
                else r--;
            }
        }
        return rst;
    }
}
