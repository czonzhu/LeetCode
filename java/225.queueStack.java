class MyStack {
    private Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
        for(int i = 0; i < queue.size() - 1; i++){
            queue.offer(queue.poll());
        }
        return;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
        return;
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}