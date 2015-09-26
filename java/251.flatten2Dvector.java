public class Vector2D{
	private Iterator<List<Integer>> out;
	private Iterator<Integer> in;
	public Vector2D(List<List<Integer>> vec2d){
		this.out = vec2d.iterator();
	}

	public int next(){
		hasNext();
		return in.next();
	}

	public boolean hasNext(){
		while((in == null || !in.hasNext()) && out.hasNext())
			in = out.next().iterator();
		return in != null && in.hasNext();
	}
}