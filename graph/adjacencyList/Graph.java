import java.util.LinkedList;

public class Graph{

	LinkedList<Integer>[] allNodes;

	public Graph(int numberNodes){
		allNodes = new LinkedList[numberNodes];
		for(int i =0; i<numberNodes;i++){
			allNodes[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int a, int b){
		if(!allNodes[a].contains(b)){
			allNodes[a].add(b);
		}
		if(!allNodes[b].contains(a)){
			allNodes[b].add(a);
		}
	}

	public void breadthFirst(int node){
		boolean[] visited = new boolean[allNodes.length];
		LinkedList<Integer> nodes = new LinkedList<Integer>();
		nodes.add(node);

		while(!nodes.isEmpty()){
			int current = nodes.removeFirst();
			System.out.println(current);
			visited[current] = true;
			for(int neighbor: allNodes[current]){
				if(!visited[neighbor]){
					nodes.add(neighbor);
				}
			}
		}

	}

	public void depthFirst(int node){
		boolean[] visited = new boolean[allNodes.length];

		depthHelper(node, visited);
	}

	public void depthHelper(int node, boolean[] visited){
		System.out.println(node);
		visited[node] = true;
		for(int current : allNodes[node]){
			if(!visited[current]){
				depthHelper(current, visited);
			}
		}
	}

	public static void main(String[] args){
		Graph test = new Graph(6);
		test.addEdge(0,1);
		test.addEdge(0,3);
		test.addEdge(1,2);
		test.addEdge(3,5);
		test.depthFirst(0);
		test.breadthFirst(0);
	}
}