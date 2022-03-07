package stack;

public interface Stack {
	boolean isEmpty();
	boolean isFull();
	void push(char item);
	char pop();
	char peek();
	void clear();
}
