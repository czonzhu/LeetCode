public class Solution{
	// 1. how to construct a graph according to the edge list
	// 2. how to judge whether a graph is cyclic
	class Course{
		boolean visited = false;
		boolean tested = false;
		List<Course> pre = new ArrayList<Course>();
		public void add(Course c){
			pre.add(c);
		}
	}

	public boolean canFinish(int numCourses, int[][] prerequisites){
		Course[] courses = new Course[numCourses];
		for(int i = 0; i < numCourses; i++){
			courses[i] = new Course();
		}
		for(int i = 0; i < prerequisites.length; i++){
			courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
		}
		for(int i = 0; i < numCourses; i++){
			if(isCyclic(courses[i])) return false;
		}
		return true;
	}

	private boolean isCyclic(Course cur){
		if(cur.tested) return false;
		if(cur.visited) return true;
		cur.visited = true;
		for(Course c : cur.pre){
			if(isCyclic(c)) return true;
		}
		cur.tested = true;
		return false;
	}
}