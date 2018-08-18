public class Queue<T>{

	public static class QueueNode<T>{

		public T value;
		public QueueNode<T> next;

		public QueueNode(T ele){
			value = ele;
		}
	}

	QueueNode<T> front;
	QueueNode<T> tail;

	public void add(T ele){
		if(front == null){
			front = new QueueNode<T>(ele);
			tail = front;
		}else{
			tail.next = new QueueNode<T>(ele);
			tail = tail.next;
		}

	}

	public T peek(){
		if(front == null) return null;
		return front.value;
	}

	public T remove(){
		if(front == null) return null;
		T result = front.value;
		front = front.next;
		if(front == null){
			tail = null;
		}
		return result;
	}

	public boolean isEmpty(){
		return front == null;
	}

	public static void main(String[] args){
		Queue<String> test = new Queue<String>();

		test.add("fam");
		test.add("there");
		test.add("hey");

		System.out.println(test.remove() + " " + test.remove() + " " + test.remove());
	}
}