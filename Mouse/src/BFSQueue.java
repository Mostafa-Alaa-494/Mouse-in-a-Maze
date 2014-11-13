import java.util.LinkedList;

public class BFSQueue<T> implements Queue<T> {
	LinkedList<T> queue;

	public BFSQueue() {
		queue = new LinkedList<>();
	}

	public void push(T node) {
		queue.addLast(node);
	}

	public T pop() {
		return queue.removeFirst();

	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
