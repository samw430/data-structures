import java.util.LinkedList;

public class GeneralTree<T>{

	T value;
	LinkedList<GeneralTree<T>> children;

	public GeneralTree(T ele){
		value = ele;
		children = new LinkedList<GeneralTree<T>>();
	}

	public void addChild(T ele){
			children.addFirst(new GeneralTree<T>(ele));
	}

	public GeneralTree<T> getChild(T ele){
		if(this.containsChild(ele)){
			for(int i =0; i<children.size(); i++){
				if(children.get(i).value.equals(ele)){
					return children.get(i);
				}
			}
		}else{
			return null;
		}
		return null;
	}

	public boolean containsChild(T ele){
		boolean result = false;
		for(int i =0; i<children.size(); i++){
			if(children.get(i).value.equals(ele)){
				result = true;
				break;
			}
		}
		return result;
	}

	public boolean contains(T ele){
		//System.out.println("Looking for " + ele);
		//System.out.println("Found in node " + value);
		if(value.equals(ele)){
			return true;
		}else if(children.isEmpty()){
			return false;
		}
		boolean result = false;
		for(int i =0; i<children.size(); i++){
			//System.out.println("Checking child");
			result = result || children.get(i).contains(ele);
		}
		return result;
	}

	public static void main(String[] args){
		GeneralTree<Integer> root = new GeneralTree<Integer>(5);
		root.addChild(6);
		root.addChild(7);
		root.addChild(8);
		root.addChild(9);
		root.addChild(10);
		root.addChild(11);

		System.out.println(root.contains(5));
		System.out.println(root.contains(40));

		GeneralTree<Integer> child = root.getChild(8);
		child.addChild(40);
		child.addChild(50);

		System.out.println(child.contains(9));
		System.out.println(child.contains(40));

	}
}