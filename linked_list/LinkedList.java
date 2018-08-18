public class LinkedList<T>{

	Node<T> head;

	public LinkedList(){
		head = new Node<T>(null);
	}

	public void appendElement(T ele){
		Node<T> tail = this.findTail();
		tail.setNext(new Node<T>(ele));
	}

	private Node<T> findTail(){
		Node<T> pointer = head;
		while(pointer.getNext() != null){
			pointer = pointer.getNext();
		}
		return pointer;
	}

	public String toString(){
		Node<T> pointer = head;
		String result = "";
		while(pointer.getNext() != null){
			pointer = pointer.getNext();
			result = result + ", " + pointer.value();
		}
		return result.substring(2);
	}

	public static void main(String[] args){
		LinkedList<String> stringList = new LinkedList<String>();
		stringList.appendElement("hey");
		stringList.appendElement("there");
		stringList.appendElement("fam");

		System.out.println(stringList);

		LinkedList<Integer> intList = new LinkedList<Integer>();
		intList.appendElement(1);
		intList.appendElement(5);
		intList.appendElement(7);


		System.out.println(intList);
	}
}