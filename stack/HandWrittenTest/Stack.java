public class Stack<T>{
	private class Node<T>{
		T value;
		Node<T> next;

		public Node(T ele){
			value = ele;
		}
	}

	Node<T> head;

	public Stack(){
		head = null;
	}

	public T pop(){
		if( head != null){
			T result = head.value;
			head = head.next;
			return result;
		}
		return null;
	}

	public void push(T ele){
		Node<T> finger = head;
		if(head == null){
			head = new Node<T>(ele);
		}else{
			while(finger.next != null){
				finger = finger.next;
			}
			finger.next = new Node<T>(ele);
		}
	}

	public boolean isEmpty(){
		return head == null;
	}

	public T peek(){
		if(head != null){
			return head.value;
		}
		return null;
	}

	public static void main(String[] args){
		Stack<String> test = new Stack<String>();

		test.push("fam");
		test.push("there");
		test.push("hey");

		System.out.println(test.pop() + " " + test.pop() + " " + test.pop());
	}	
}