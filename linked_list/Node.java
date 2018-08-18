public class Node<T>{

	T value;
	Node<T> next;

	public Node(T ele){
		value = ele;
		next = null;
	}

	public void setNext(Node<T> newNext){
		next = newNext;
	}

	public T value(){
		return value;
	}

	public Node<T> getNext(){
		return next;
	}
}