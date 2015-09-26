public class FlattenIterator{
	private Stack<Iterator> iteratorStack;
	
	public FlattenIterator(List list){
		iteratorStack = new Stack<Iterator>();
		iteratorStack.push(list.iterator());
	}

	public boolean hasNext(){
		moveToNext();
		return next != null;
	}
	public Object next(){
		moveToNext();
		if(next == null)
	}
	private void moveToNext(){
		if((next == null) && !iteratorStack.empty()){
			if(iteratorStack.peek().hasNext()){
				final Object next = iteratorStack.peek().next();
				if(next instanceof Iterator){
					iteratorStack.push(next);
					moveToNext();
				}else if(next instanceof Iterable){
					iteratorStack.push((Iterable) next.iterator());
					moveToNext();
				} else{
					this.next = next;
				}
			}else{
				iteratorStack.pop();
				moveToNext();
			}
		} 
	}
}