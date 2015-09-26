class MyQueue{
	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> output = new Stack<Integer>();

	public void push(int x){
		input.push(x);
	}

	public void pop(){
		peek();
		output.pop();
	}

	public int peek(){
		if(output.empty()){
			while(!input.empty()){
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	public boolean empty(){
		return input.empty() && output.empty();
	}
}  