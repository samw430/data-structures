public class Stack<T>{

	private static class Node<T>{
		T value;
		Node<T> next;

		public Node(T data){
			value = data;
		}
	}

	Node<T> top;

	public Stack(){
		top = null;
	}

	public void push(T ele){
		Node<T> temp = new Node<T>(ele);
		temp.next = top;
		top = temp;
	}

	public T pop(){
		if(top != null){
			T result = top.value;
			top = top.next;
			return result;
		}else{
			return null;
		}
	}

	public T peek(){
		return top.value;
	}

	public boolean isEmpty(){
		return top ==null;
	}

	public static void main(String[] args){
		Stack<String> test = new Stack<String>();

		test.push("fam");
		test.push("there");
		test.push("hey");

		System.out.println(test.pop() + " " + test.pop() + " " + test.pop());
	}
}