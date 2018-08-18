public class Queue<T>{
	private class Node<T>{
		T value;
		Node<T> next;
		public Node(T ele){
			value = ele;
		}
	}

	Node<T> head;

	public Queue(){
		head = null;
	}

	public void add(T ele){
		Node<T> finger = head;
		Node<T> follower = null;

		if(head == null){
			head = new Node<T>(ele);
		}else{
			while(finger != null){
				follower = finger;
				finger = finger.next;
			}
			follower.next = new Node<T>(ele);
		}
	}

	public T peek(){
		if(head != null){
			return head.value;
		}
		return null;
	}

	public T remove(){
		if( head != null){
			T result = head.value;
			head = head.next;
			return result;
		}
		return null;
	}

	public boolean isEmpty(){
		return head == null;
	}

	public static void main(String args[]){
		Queue<Integer> testboy = new Queue<Integer>();
		System.out.println(testboy.isEmpty());
		testboy.add(5);
		testboy.add(6);
		testboy.add(7);
		testboy.add(8);
		System.out.println(testboy.remove());
		System.out.println(testboy.remove());
		System.out.println(testboy.remove());
		System.out.println(testboy.remove());
		System.out.println(testboy.remove());
		System.out.println(testboy.remove());
	}
}