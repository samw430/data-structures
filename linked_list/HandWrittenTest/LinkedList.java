public class LinkedList<T>{

	private class Node<T>{
		Node<T> next;
		T value;
		public Node(T ele){
			value = ele;
		}
	}

	Node<T> head;

	public LinkedList(){
		head = null;
	}

	public T head(){
		if(head != null){
			return head.value;
		}
		return null;
	}

	public T tail(){
		Node<T> temp = head;
		Node<T> follower = null;
		while(temp != null){
			follower = temp;
			temp = temp.next;
		}
		return follower.value;
	}

	public boolean contains(T ele){
		Node<T> temp = head;
		Node<T> follower = null;
		while(temp!= null){
			if(ele.equals(temp.value)) return true;
			follower = temp;
			temp = temp.next;
		}
		return false;
	}

	public int indexOf(T ele){
		Node<T> temp = head;
		int i=0;
		Node<T> follower = null;
		while(temp!= null){
			if(ele.equals(temp.value)) return i;
			i++;
			follower = temp;
			temp = temp.next;
		}
		return -1;
	}

	public void addFirst(T ele){
		Node<T> newHead = new Node<T>(ele);
		newHead.next = head;
		head = newHead;
	}

	public void addLast(T ele){
		Node<T> finger = head;
		Node<T> follower = null;
		while(finger!=null){
			follower = finger;
			finger = finger.next;
		}
		if(follower != null){
			follower.next = new Node<T>(ele);
		}else{
			head = new Node<T>(ele);
		}
	}

	public boolean remove(T ele){
		Node<T> finger = head;
		Node<T> follower = null;
		if(head.value.equals(ele)){
			head = head.next;
		}
		while(finger!=null){
			if(ele.equals(finger.value) && follower != null){
				follower.next = finger.next;
				return true;
			}else{
				follower = finger;
				finger = finger.next;
			}
		}
		return false;
	}

	public String toString(){
		String result = "[";
		Node<T> finger = head;
		while(finger!=null){
			result += finger.value + ", ";
			finger = finger.next;
		}
		result = result.substring(0,result.length()-2) + "]";
		return result;
	}

	public static void main(String[] args){
		LinkedList<Integer> testboy = new LinkedList<Integer>();
		System.out.println(testboy.head());
		for(int i=0; i<11; i++){
			testboy.addLast(i);
		}
		System.out.println(testboy);
		System.out.println(testboy.contains(5));
		System.out.println(testboy.contains(8));
		testboy.remove(1);
		testboy.remove(0);
		testboy.remove(40);
		System.out.println(testboy);
	}
}