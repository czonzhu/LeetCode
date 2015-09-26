public class Solution{
	// list.toArray(array); Fills an array
	// Arrays.asList(array); turns array into a list
	private class Course{
		private int id = 0;
		List<Course> pre = new ArrayList<Course>();
		List<Course> preFor = new ArrayList<Course>();
		public Course(int id){
			this.id = id;
		}
		public void add(Course c){
			pre.add(c);
		}
		public void added(Course c){
			preFor.add(c);
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites){
		int[] rst = new int[numCourses];
		int num = 0;// judge isFinish
		Course[] courses = new Course[numCourses];
		for(int i = 0; i < numCourses; i++) courses[i] = new Course(i);
		for(int i = 0; i < prerequisites.length; i++){
			courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
			courses[prerequisites[i][1]].added(courses[prerequisites[i][0]]);
		}

		Queue<Course> queue = new LinkedList<Course>();
		for(Course c : courses){
			if(c.pre.size() == 0) queue.offer(c);
		}

		int index = 0;
		while(!queue.isEmpty()){
			Course cur = queue.poll();
			rst[index++] = cur.id;
			num++;
			for(Course c : cur.preFor){
				c.pre.remove(cur);
				if(c.pre.size() == 0)
					queue.offer(c);
			}
		}
		return num == numCourses ? rst : new int[0];
	}
}