import java.util.LinkedList;


public class DFSQueue<T> implements Queue<T> {
	
	LinkedList<T> queue;
	
	public DFSQueue(){
		queue=new LinkedList<T>();
	}
	
	public void push(T node){
		queue.addFirst(node);
	}
	
	public T pop(){
		return queue.removeFirst();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
}
