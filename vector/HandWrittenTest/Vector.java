public class Vector<T>{
	int size;
	Object[] elements;

	public Vector(){
		size =0;
		elements = new Object[10];
	}

	private void ensureCapacity(){
		if(size>=elements.length-1){
			Object[] temp = new Object[2*size];
			for(int i=0;i<size;i++){
				temp[i]=elements[i];
			}
			elements=temp;
		}
	}

	public boolean contains(T ele){
		boolean result = false;
		for(int i=0;i<size;i++){
			if(ele.equals((T)elements[i])){
				result = true;
			}
		}
		return result;
	}

	public boolean add(T ele){
		if(this.contains(ele)){
			return false;
		}else{
			this.ensureCapacity();
			elements[size] = ele;
			size++;
		}
		return true;
	}

	public T elementAt(int index){
		if(0<=index && index<size){
			return (T) elements[index];
		}
		return null;
	}

	public int indexOf(T ele){
		for(int i=0;i<size;i++){
			if(ele.equals((T)elements[i])){
				return i;
			}
		}
		return -1;
	}

	public boolean isEmpty(){
		return size==0;
	}

	public boolean remove(T ele){
		int index = this.indexOf(ele);
		if(index==-1){
			return false;
		}else{
			for(int i=index;i<size-1;i++){
				elements[i] = elements[i+1];
			}
			size--;
		}
		return true;
	}

	public String toString(){
		String result = "[";
		for(int i=0;i<size;i++){
			result += elements[i] + ", ";
		}
		result = result.substring(0,result.length()-2) + "]";
		return result;
	}

	public static void main(String[] args){
		Vector<Integer> testboy = new Vector<Integer>();
		System.out.println(testboy.isEmpty());
		for(int i=0;i<400;i++){
			testboy.add(i);
		}
		System.out.println(testboy);

		testboy.remove(5);
		testboy.remove(350);
		System.out.println(testboy);
		System.out.println(testboy.isEmpty());
	}
}