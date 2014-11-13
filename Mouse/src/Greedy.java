import java.util.PriorityQueue;

public class Greedy<T> implements Queue<T> {

	PriorityQueue<T> heap;

	public Greedy() {
		heap = new PriorityQueue<>();
	}

	@Override
	public void push(T node) {
		heap.add(node);
	}

	public T pop() {
		return heap.remove();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

}
